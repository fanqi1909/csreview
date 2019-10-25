package org.jace.cs.review.lc.search.p36;

public class Tester {

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] map1 = new char[][]{
                new char[]{'.','3','4','.','1','.','.','.','.'},
                new char[]{'.','.','7','.','.','.','2','4','8'},
                new char[]{'6','.','.','.','.','.','.','.','7'},
                new char[]{'3','.','.','8','.','6','.','.','9'},
                new char[]{'1','.','.','.','.','.','.','7','.'},
                new char[]{'.','.','.','4','9','.','.','.','6'},
                new char[]{'7','8','.','.','4','1','.','6','3'},
                new char[]{'.','.','3','.','.','.','.','8','1'},
                new char[]{'.','.','.','.','.','.','4','.','.'}
        };
       System.out.println(solution.isValidSudoku(map1));
    }
}
