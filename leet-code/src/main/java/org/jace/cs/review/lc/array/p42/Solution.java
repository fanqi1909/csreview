package org.jace.cs.review.lc.array.p42;

/**
 * Divide and conquer.
 *
 * The case is easy to compute when the two ending bars forms a convex. i.e., all bars in-between are shorter than the two sides (See CASE-2).
 * So, given a range [start, end], we wish to divide it into multiple convex ranges, so that each of them can be computed easily. This comes
 * to the divide-and conquer algorithm.
 *
 *
 * For a given range [start, end], find the maximum bar between these two bars (See FIND-MAX). Let's say this max is at position P,
 * and value is height[P]. Two cases we need to further consider:
 *
 *   CASE-1. Height[P] >  min(height[start], height[end]). This means we can further divide the current range [start,end] to
 *           [start, p] + [p, end]. Then sum up the water from the two ranges.
 *           For example, if the range [0,5] contains 3, 1, 5, 2, 4, 3. The max is 5, so we can go ahead to find trab[0,2] and trab[2,5].
 *
 *   CASE-2. If Height[P] is smaller than min of both ending bars, then we can directly compute water trap:
 *          For example, if the range [0,5] contains 6, 1, 5, 2, 4, 5. The the water trab is
 *          min(6,5) * (5 - 0 - 1) - (1 + 5 + 2 + 4) = 8
 *          General equation is:
 *          min(height[start], height[end]) * (end - start -1) - sum(height[start + 1], ..., height[end - 1])
 *
 * Worst case complexity is o(nlog(n)), due to repeated computation of max(height[start,...,end]). A pre-index can bring down
 * the complexity to o(n), but the code would be more complex.
 */
public class Solution {
    public int trap(int[] height) {
        if(height.length == 0) {
            return 0;
        }
        int start = 0;
        while(start < height.length && height[start] == 0) {
            start++;
        }
        return trapSub(height, start, height.length - 1);
    }

    private int trapSub(int[] height, int start, int end) {
        if(end <= start + 1) {
            //nothing in range [start, end]
            return 0;
        }

        //find the max in the range (start, end)
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;
        int blocks = 0;
        for(int i = start + 1; i < end; i++) { //FIND MAX
            if(height[i] >= max) {
                max = height[i];
                maxIndex = i;
            }
            blocks += height[i];
        }

        int minBar = Math.min(height[start], height[end]);

        if(max > minBar) {
            //split
            return trapSub(height, start, maxIndex) + trapSub(height, maxIndex, end); //CASE 1
        } else {
            return minBar * (end - start - 1) - blocks; // CASE2
        }
    }
}
