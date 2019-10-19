package org.jace.cs.review.lc.binarysearch.p35;


/**
 * This is a usage of the error free binary search template
 *
 *
 * l -> left inclusive bound
 * r -> right inclusive bound
 *
 * there are two version of mid
 *  left-mid = (l + r) >>> 1
 *  right-mid = (l + r + 1) >>> 1
 * these avoid overflows
 *
 *  The goal of search is to squeeze the range [l,r].
 *
 *  In this case, we cannot use if(nums[mid] > target) as testing. Because even it is true, we are not sure if
 *   the insertion point would be included as mid or not, so the r needs to be mid but not mid - 1; Similarly, l needs to be
 *   mid, not mid + 1. In this way, if l = mid initially, we would end up with infinite loop.
 *
 * In our case, we are able to use l = mid + 1 to completely prune out all indexes from [l, mid], so the range shrinks. Since
 * we shrink l every time, we use left-mid .
 *
 * If we are able to shrink right, like in other cases, where r = mid -1, then we can use right-mid (l+r+1) >>> 1
 *
 * The benefit is obvious, there is no need to do post checks for l for boundary conditions.
 *
 *
 */

public class Solution {
    public int searchInsert(int[] nums, int target) {
        int l = 0;
        int r = nums.length;

        while(l < r) {
            int mid = (l+r) >>> 1;

            if(nums[mid] < target) {
                l= mid + 1;
            } else {
                r = mid;
            }
        }

        return l;
    }
}
