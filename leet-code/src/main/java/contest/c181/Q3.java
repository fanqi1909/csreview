package contest.c181;

public class Q3 {

    public boolean hasValidPath(int[][] grid) {
        int[] port1 = new int[]{0, 1, 0, 2, 0, 1};
        int[] port2 = new int[]{2, 3, 3, 3, 1, 2};

        return isValid(grid, 0, 0, port1[grid[0][0] - 1], port1, port2) ||
                isValid(grid, 0, 0, port2[grid[0][0] - 1], port1, port2);
    }


    private boolean isValid(int[][] grid, int posX, int posY, int lastOut, final int[] port1, final int[] port2) {
        if (posX < 0 || posX >= grid.length || posY < 0 || posY >= grid[0].length) {
            return false;
        } else {
            int index = grid[posX][posY];
            int outPort;
            if (port1[index - 1] == lastOut) {
                outPort = port2[index - 1];
            } else if (port2[index - 1] == lastOut) {
                outPort = port1[index - 1];
            } else {
                return false; // cannot link with previous move;
            }

            if (posX == grid.length - 1 && posY == grid[0].length - 1) {
                return true; //arrived
            }

            switch (outPort) {
                case 0:
                    return isValid(grid, posX, posY - 1, 2, port1, port2);
                case 1:
                    return isValid(grid, posX - 1, posY, 3, port1, port2);
                case 2:
                    return isValid(grid, posX, posY + 1, 0, port1, port2);
                case 3:
                    return isValid(grid, posX + 1, posY, 1, port1, port2);
            }
            return false;
        }
    }


    public static void main(String[] args) {
        Q3 q3 = new Q3();
        System.out.println(q3.hasValidPath(
                new int[][]{
                        new int[]{2,4,3},
                        new int[]{6,5,2}
                }
        ));
        System.out.println(q3.hasValidPath(
                new int[][]{
                        new int[]{1,2,1},
                        new int[]{1,2,1}
                }
        ));
        System.out.println(q3.hasValidPath(
                new int[][]{
                        new int[]{1,1,2}
                }
        ));

        System.out.println(q3.hasValidPath(
                new int[][]{
                        new int[]{1,1,1,1,1,1,1,3}
                }
        ));
        System.out.println(q3.hasValidPath(
                new int[][]{
                        new int[]{2},
                        new int[]{2},
                        new int[]{2},new int[]{2},
                        new int[]{2},
                        new int[]{6},
                }
        ));
    }
}
