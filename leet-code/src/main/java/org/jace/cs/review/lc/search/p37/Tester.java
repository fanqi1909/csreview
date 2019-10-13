package org.jace.cs.review.lc.search.p37;

public class Tester {
    public static void main(String[] args) {
        Solution solution = new Solution();

        char[][] map = new char[][]{
                new char[]{'5','3','.','.','7','.','.','.','.'},
                new char[]{'6','.','.','1','9','5','.','.','.'},
                new char[]{'.','9','8','.','.','.','.','6','.'},
                new char[]{'8','.','.','.','6','.','.','.','3'},
                new char[]{'4','.','.','8','.','3','.','.','1'},
                new char[]{'7','.','.','.','2','.','.','.','6'},
                new char[]{'.','6','.','.','.','.','2','8','.'},
                new char[]{'.','.','.','4','1','9','.','.','5'},
                new char[]{'.','.','.','.','8','.','.','7','9'}
        };

        char[][] map2 = new char[][]{
                new char[]{'.','6','.','.','3','.','7','8','.'},
                new char[]{'8','.','.','.','.','9','.','5','.'},
                new char[]{'.','.','5','.','.','.','1','.','4'},
                new char[]{'.','.','9','.','.','4','8','1','.'},
                new char[]{'5','.','1','.','8','.','9','6','.'},
                new char[]{'.','.','6','7','.','.','4','.','.'},
                new char[]{'.','.','8','.','.','.','.','7','.'},
                new char[]{'.','.','.','.','.','.','5','.','.'},
                new char[]{'1','.','.','4','.','.','.','.','.'}
        };

        char[][] map3 = new char[][]{
                new char[]{'.','.','4','.','1','.','.','.','.'},
                new char[]{'.','.','7','.','.','.','2','4','8'},
                new char[]{'6','.','.','.','.','.','.','.','7'},
                new char[]{'3','.','.','8','.','6','.','.','9'},
                new char[]{'1','.','.','.','.','.','.','7','.'},
                new char[]{'.','.','.','4','9','.','.','.','6'},
                new char[]{'7','8','.','.','4','.','.','6','3'},
                new char[]{'.','.','3','.','.','.','.','8','1'},
                new char[]{'.','.','.','.','.','.','4','.','.'}
        };

        solution.solveSudoku(map3);

    }

    public static void printMap(char[][] map) {
        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[i].length; j++) {
                if(j == 0) {
                    System.out.print("|");
                }
                System.out.printf("%2c ", map[i][j]);
                System.out.print("|");
            }
            System.out.println();
            for(int j = 0; j< map[i].length; j++) {
                System.out.print("----");
            }
            System.out.println("-");
        }
    }
}
