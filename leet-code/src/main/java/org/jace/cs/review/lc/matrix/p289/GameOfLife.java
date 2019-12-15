package org.jace.cs.review.lc.matrix.p289;

import org.jace.cs.review.lc.dp.Util;

public class GameOfLife {

    public void gameOfLife(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = next(i, j, board);
            }
        }

        //remove the lowest bit
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = board[i][j] >> 1;
            }
        }
    }

    private int next(int i, int j, int[][] board) {
        int live = 0;
        for (int x = -1; x <= 1; x++) {
            int nx = i + x;
            if (nx >= 0 && nx < board.length) {
                for (int y = -1; y <= 1; y++) {
                    int ny = j + y;
                    if (nx == i && ny == j) {
                        continue; // does not count itself
                    }
                    if (ny >= 0 && ny < board[i].length) {
                        if ((board[nx][ny] & 1) == 1) {
                            live++;
                        }
                    }
                }
            }
        }


        if ((board[i][j] & 1) == 1) {
            if (live < 2 || live > 3) {
                board[i][j] = board[i][j] & 1; // next round is dead
            } else {
                board[i][j] = board[i][j] | 2; // next round is live
            }
        } else {
            if (live == 3) {
                board[i][j] = board[i][j] | 2; // next round is live
            } else {
                board[i][j] = board[i][j] & 1; // next round is dead
            }
        }
        return board[i][j];
    }

    public static void main(String[] args) {
        GameOfLife gol = new GameOfLife();
        int[][] board = new int[][]{
                new int[]{0, 1, 0},
                new int[]{0, 0, 1},
                new int[]{1, 1, 1},
                new int[]{0, 0, 0},
        };
        Util.print2DArray(board);
        gol.gameOfLife(board);
        Util.print2DArray(board);
    }
}
