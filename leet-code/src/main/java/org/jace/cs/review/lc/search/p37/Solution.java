package org.jace.cs.review.lc.search.p37;

import java.util.*;

/**
 * Rule based pruning + DFS backtracking
 */
public class Solution {

    List<Cell>[] rowIndex = new List[9];
    List<Cell>[] columnIndex = new List[9];
    List<Cell>[] squareIndex = new List[9];
    List<Cell> unfilled = new LinkedList<>();
    List<Cell> allCells = new LinkedList<>();

    public void solveSudoku(char[][] board) {
        Tester.printMap(board);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                Cell cell = new Cell(i, j, board);
                allCells.add(cell);
                if (cell.isUnknown()) {
                    unfilled.add(cell);
                }
                if (rowIndex[cell.row] == null) {
                    rowIndex[cell.row] = new ArrayList<>();
                }
                rowIndex[cell.row].add(cell);
                if (columnIndex[cell.column] == null) {
                    columnIndex[cell.column] = new ArrayList<>();
                }
                columnIndex[cell.column].add(cell);
                if (squareIndex[cell.square] == null) {
                    squareIndex[cell.square] = new ArrayList<>();
                }
                squareIndex[cell.square].add(cell);

            }
        }
        pruneRule(board);

        System.out.println("Starting DFS");
        dfs(unfilled);
        unfilled.forEach(System.out::println);
        Tester.printMap(board);
    }

    private boolean dfs(List<Cell> unfilled) {
        if(unfilled.size() == 0) {
            return isValid();
        }
        Cell head = unfilled.remove(0);
        Set<Integer> backUp = new HashSet<>(head.available);
        List<Integer> available = new LinkedList<>(head.available);

        while(!available.isEmpty()) {
            int tries = available.remove(0);
            head.fill(tries);
            if(checkUnit(rowIndex[head.row])
                    && checkUnit(columnIndex[head.column])
                    && checkUnit(squareIndex[head.square])) {
                if(dfs(unfilled)) {
                    return true;
                }
            }
            //try another
            head.unFill(available);
        }
        //backtrack
        head.available.clear();
        head.available.addAll(backUp);
        unfilled.add(head);
        return false;
    }

    private boolean isValid() {
       for(int i = 0; i < 9; i++) {
           if(!checkDone(rowIndex[i])
           || !checkDone(columnIndex[i])
           || !checkDone(squareIndex[i])) {
               return false;
           }
       }
       return true;
    }

    private boolean checkDone(List<Cell> cells) {
        int sum = 0;
        for(Cell cell : cells) {
            int filled = cell.getFilledNumber();
            sum += filled;
        }
        return sum == 45;
    }

    private boolean checkUnit(List<Cell> cells) {
        int[] valid = new int[10];
        for(Cell cell : cells) {
            if(!cell.isUnknown()) {
                int filled = cell.getFilledNumber();
                valid[filled]++;
                if(valid[filled] > 1) {
               //     System.out.println("Cells are invalid: " + cells);
                    return false;
                }
            }
        }
        return true;
    }


    private void pruneRule(char[][] board) {
        int round = 0;
        int gain;
        do {
            int initialUnknown = unfilled.size();
            for (Cell cell : allCells) {
                if (!cell.isUnknown()) {
                    apply(cell, rowIndex[cell.row]);
                    apply(cell, columnIndex[cell.column]);
                    apply(cell, squareIndex[cell.square]);
                }
            }
            int newUnknown = unfilled.size();
            System.out.println("Rule based pruning  gain=" + (initialUnknown - newUnknown));
            for(int i = 0; i < 9; i++) {
                fill(rowIndex[i]);
                fill(columnIndex[i]);
                fill(squareIndex[i]);
            }
            int finalUnknown = unfilled.size();
            System.out.println("fill based pruning gain=" + (newUnknown - finalUnknown));
            gain =  initialUnknown - finalUnknown;
            System.out.println("Map after round " + round + " unknwon changes from " + initialUnknown + " to " + newUnknown + " to " + finalUnknown + " gain=" + gain);
            Tester.printMap(board);
            round++;
        } while (gain > 0);
    }

    private void fill(List<Cell> index) {
        Map<Integer, List<Cell>> matching = new HashMap<>();
        Set<Integer> known = new HashSet<>();
        for(Cell cell : index) {
            if(cell.isUnknown()) {
                for(Integer candidate : cell.available) {
                    if(!matching.containsKey(candidate)) {
                        matching.put(candidate, new ArrayList<>());
                    }
                    matching.get(candidate).add(cell);
                }
            } else {
                known.add(cell.getFilledNumber());
            }
        }
        matching.forEach((k,v) -> {
            if(!known.contains(k) && v.size() == 1) {
                v.get(0).fill(k);
                unfilled.remove(v.get(0));
            }
        });
    }

    private void apply(Cell cell, List<Cell> index) {
        for (Cell unknown : index) {
            if (unknown.isUnknown()) {
                unknown.prune(cell.getFilledNumber());
                if (!unknown.isUnknown()) {
                    unfilled.remove(unknown);
                }
            }
        }
    }

    class Cell {
       public final int id;
        public final int row;
        public  final int column;
        public  final int square;
        public final char[][] board;
        Set<Integer> available;
        char fill;

        public Cell(int i, int j, char[][] board) {
            this.row = i;
            this.column = j;
            this.square = (i / 3) * 3 + j / 3;
            this.id = row * 9 + column;
            this.board = board;
            fill = board[i][j];
            if (isUnknown()) {
                available = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
            } else {
                available = new HashSet<>();
            }
        }

        public boolean isUnknown() {
            return fill == '.';
        }

        public int getFilledNumber() {
            return fill - '0';
        }

        public void fill(int number) {
            if(fill == number + '0') {
                return;
            }
            fill = (char)(number + '0');
//            System.out.printf("Fill cell[%d,%d:%s] with [%c]\n", row, column, available, fill);
            board[row][column] = fill;
            available = new HashSet<>();
        }

        public void unFill(Collection<Integer> available) {
            fill = '.';
            board[row][column] = fill;
//            System.out.printf("Unfill cell[%d:%d:%s] with [%c]\n", row, column, available, fill);
            this.available.clear();
            this.available.addAll(available);
        }

        public void prune(int number) {
            available.remove(number);
            if (available.size() == 1) {
                fill(available.iterator().next());
            }
        }

        @Override
        public String toString() {
            return String.format("[%d,%d,%d,%c:%s]", row, column, square, fill, available);
        }

    }
}
