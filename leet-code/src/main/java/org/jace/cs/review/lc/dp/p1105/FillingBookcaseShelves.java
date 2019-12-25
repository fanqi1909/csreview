package org.jace.cs.review.lc.dp.p1105;

/**
 * Dynamic programming to determine how many books are in the last row.
 *
 * H[i] -> the min height of the  first i books [0, i-1]
 *
 * H[i+1] = min(f(i+1, k) + H[i + 1 - k])
 * where f(i+1,k) means to place the last k [i- k + 2, .. ,i+1] books in one row.
 *
 * f(m, n) can be calculated in a rolling manner.
 *
 */
public class FillingBookcaseShelves {
    public int minHeightShelves(int[][] books, int shelf_width) {
        int[] H = new int[books.length + 1]; // H_i is the height of the first i-books
        H[0] = 0;
        for(int i = 1; i < H.length; i++) {
            int lastRowW = 0;
            int lastRowH =  -1;
            H[i] = Integer.MAX_VALUE;
            for(int lastBook = i; lastBook >= 1; lastBook--) {
                lastRowW += books[lastBook - 1][0];
                if(lastRowW <= shelf_width) {
                    lastRowH = Math.max(lastRowH, books[lastBook - 1][1]);
                    H[i] = Math.min(H[lastBook - 1] + lastRowH, H[i]);
                } else {
                    break;
                }
            }
        }
        return H[books.length];
    }

    public static void main(String[] args) {
        FillingBookcaseShelves fbs = new FillingBookcaseShelves();
        System.out.println(fbs.minHeightShelves(new int[][]{
                new int[]{1,1},
                new int[]{2,3},
                new int[]{2,3},
                new int[]{1,1},
                new int[]{1,1},
                new int[]{1,1},
                new int[]{1,2}
        }, 4));
    }
}
