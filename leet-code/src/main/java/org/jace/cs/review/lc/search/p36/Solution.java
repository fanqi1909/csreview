package org.jace.cs.review.lc.search.p36;

public class Solution {
    public boolean isValidSudoku(char[][] board) {

        if (board.length != 9) return false;
        if (board[0].length != 9) return false;

        //row
        for (int i = 0; i < 9; i++) {
            int[] distincts = new int[9];
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int number = board[i][j] - '1';
                if (distincts[number] > 0) {
                    return false;
                }
                distincts[number]++;
            }
        }

        //column

        for (int i = 0; i < 9; i++) {
            int[] distincts = new int[9];
            for (int j = 0; j < 9; j++) {
                if (board[j][i] == '.') {
                    continue;
                }
                int number = board[j][i] - '1';
                if (distincts[number] > 0) {
                    return false;
                }
                distincts[number]++;
            }
        }

        //square
        for (int i = 0; i < 9; i++) {
            int[] distincts = new int[9];
            int rowBase = i / 3 * 3;
            int colBase = i % 3 * 3;
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    int row = rowBase + j;
                    int col = colBase + k;
                    if (board[row][col] == '.') {
                        continue;
                    }
                    int number = board[row][col] - '1';
                    if (distincts[number] > 0) {
                        return false;
                    }
                    distincts[number]++;
                }
            }
        }
        return true;
    }
}