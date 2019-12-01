package contest.c165;

public class Q1 {


    public String tictactoe(int[][] moves) {
        char[][] board = new char[3][3];

        int turns = 0;
        for (int[] move : moves) {
            board[move[0]][move[1]] = turns == 0 ? 'X' : 'O';
            if (checkboard(board, board[move[0]][move[1]])) {
                return turns == 0 ? "A" : "B";
            }
            turns = 1 - turns;
        }

        return moves.length < 9 ? "PENDING": "DRAW";
    }

    private boolean checkboard(char[][] board, char ch) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == ch
                    && board[i][1] == ch && board[i][2] == ch)
                return true;
            if(board[0][i] == ch&& board[1][i] == ch && board[2][i] == ch)
                return true;
        }
        if(board[0][0] == ch && board[1][1] == ch && board[2][2] == ch) return true;
        if(board[2][0] == ch && board[1][1] == ch && board[0][2] == ch) return true;
        return false;
    }

    public static void main (String[] args) {
        Q1 q = new Q1();
        System.out.println(q.tictactoe(new int[][]{
                new int[]{0,0},
                new int[]{2,0},
                new int[]{1,1},
                new int[]{2,1},
                new int[]{2,2}
        }));

        System.out.println(q.tictactoe(new int[][]{
                new int[]{0,0},
                new int[]{1,1},
                new int[]{0,1},
                new int[]{0,2},
                new int[]{1,0},
                new int[]{2,0},
        }));

        System.out.println(q.tictactoe(new int[][]{
                new int[]{0,0},
                new int[]{1,1},
                new int[]{2,0},
                new int[]{1,0},
                new int[]{1,2},
                new int[]{2,1},
                new int[]{0,1},
                new int[]{0,2},
                new int[]{2,2}
        }));

        System.out.println(q.tictactoe(new int[][]{
                new int[]{0,0},
                new int[]{1,1}
        }));

        System.out.println(q.tictactoe(new int[][]{
        }));
    }
}
