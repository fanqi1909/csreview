package ps.google.dp;

/**
 * Observe that the maximum product ending at [i] can be deduced from three values:
 *     minimum product ending at [i-1] (mins[i-1]) * num[i]
 *     maximum product ending at [i-1] (maxes[i-1]) * num[i]
 *     and
 *     num[i] itself.
 *
 *     mins[i] and maxes[i] can also be derived from mins[i-1] and maxes[i-1]
 *
 *
 *     an O(1) space solution can be easily obtained by taking only variable to store mins[i-1] and maxes[i-1];
 */
public class MaxProductSubArray {

    public int maxProduct(int[] nums) {
        int[] mins = new int[nums.length];
        int[] maxes = new int[nums.length];

        mins[0] = nums[0];
        maxes[0] = nums[0];

        long greatest = maxes[0];

        for(int i = 1; i < nums.length; i++) {
            int p1 = nums[i];
            int p2 = mins[i-1] * nums[i];
            int p3 = maxes[i-1] * nums[i];
            mins[i] = Math.min(Math.min(p3, p2), p1);
            maxes[i] = Math.max(Math.max(p3, p2), p1);
            if(maxes[i] > greatest) {
                greatest = maxes[i];
            }
        }
        return (int) greatest;
        //O(1) space solution
//        int greatest = nums[0];
//        int prevMin = nums[0];
//        int prevMax = nums[0];
//        for(int i = 1; i < nums.length; i++) {
//            int p1 = nums[i];
//            int p2 = prevMin * nums[i];
//            int p3 = prevMax * nums[i];
//            prevMin = Math.min(Math.min(p3, p2), p1);
//            prevMax = Math.max(Math.max(p3, p2), p1);
//            greatest = Math.max(greatest, prevMax);
//        }
//        return greatest;
    }


    public static void main(String[] args) {
        MaxProductSubArray masa = new MaxProductSubArray();
        System.out.println(masa.maxProduct(new int[]{2, 3, -2, 4}));
        System.out.println(masa.maxProduct(new int[]{-2, 0, -1}));
        System.out.println(masa.maxProduct(new int[]{-2, 0, -1, -2, -3, 2}));
    }
}
