package org.jace.cs.review.lc.array.p41;


/**
 * This algorithm uses the input array to do counting sort.
 * During counting, we propagate the process to the numbers that is being replaced. See *reorg* method.
 *
 * Two tricks to bring down the complexity:
 *     1.  Any num that is <0 or greater than nums.length can be safely pruned. Thus we do not need to care about overflowing big numbers.
 *
 *     2. Check if any update happens for a position, if there is no update, means this cell is already correct, thus we can safely stop the propagation.
 *
 */
public class Solution2 {

    public int firstMissingPositive(int[] nums) {
        if(nums.length == 0) {
            return 1;
        }
        int p = 0;

        while (p < nums.length) {
            if(nums[p] != p + 1) {
                reorg(nums, nums[p]);
            }
            p++;
        }

        p = 0;
        while(p < nums.length) {
            if(nums[p] != p + 1) {
                return p + 1;
            }
            p++;
        }
        return nums[p-1] + 1;
    }

    private void reorg(int[] nums, int target) {
        if(target > 0 && target <= nums.length) { // TRICK 1
            int old = nums[target - 1];
            nums[target - 1] = target;
            if(old != target) { // TRICK 2
                reorg(nums, old);
            }
        }
    }
}
