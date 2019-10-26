package org.jace.cs.review.lc.dp.p300;

/**
 * This binary search solution is based on a greedy thinking process.
 *
 * Suppose the current LIS  is
 *     l[0],...,l[m]
 *
 * So there are two cases when visiting next element a[i],
 *
 * 1. a[i] is greater than l[m], we can extend the current LIS as l[m+1] = a[i]
 *
 * 2. l[s] < a[i] < l[s+1], in this case, we may split existing LIS into two branches:
 *     l[0],...,l[s],l[s+1],..., l[m]
 *              and
 *     l[0],...,a[i],l[s+1],..., l[m]
 *
 * For example, suppose the input is [2, 5, 7, 4, 8]. When visiting [4], the existing LIS is [2,5,7].
 * Adding [4] will leads to a split of LIS into:
 *     [2,5,7] and [2,4,7]
 *
 * If we allow this split, it will generate too many LIS, which increase the complexity.
 *
 * The trick here is to combine all partial-LIS into one, by taking the minimum of value at each position. This means
 * we can just store [2,4,7] instead of keeping both.
 *
 * The reason behind is that, for LIS [2,5,7], 2 and 5 are not useful any more, since extending that LIS requires the next number greater than 7.
 * Therefore, we can reuse the position of [2,5] to store the next potential LIS, which is [2,4].
 *
 * Notice that, after merge this 'LIS' is not LIS any more. But it has the same max length.
 *
 * Now we can re-write the case 2 as:
 *
 * 2. l[s] < a[i] < l[s+1], in this case, we may use the following as new LIS:
 *     l[0],...,a[i],l[s+1],..., l[m]
 *
 *
 * To implement this idea, we just needs to find the changing point in LIS to match case 2, where binary search can help.
 *
 *
 */
public class SolutionBS implements Solution {

    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0) return 0;
        
        int[] result = new int[nums.length];
        int size = 0;
        for(int i = 0; i < nums.length; i++) {
            //find the changing point
            int j = findInsertionPoint(result, 0, size, nums[i]);
            if(j == size) { //CASE1: APPEND
                result[size++] = nums[i];
            } else {    //CASE2: REPLACE
                result[j] = nums[i];
            }
            //System.out.println(Arrays.toString(result));
        }
        return size;
    }

    /**
     * find insertion point between the range [start, end], for num
     *
     */
    private int findInsertionPoint(int[] result, int start, int end, int num) {
        int l = start;
        int r = end;
        while(l < r) {
            int mid = (l + r) >>> 1;
            if(result[mid] < num) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}
