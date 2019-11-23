package ps.google.array.string.two.pointers;

import java.util.*;

public class ThreeSum {
    /**
     * Sort the array, and examine for each nums num[i];
     *
     * find the matching pair in the window of [i+1, nums.length-1]
     * Since the range [i+1, nums.length-1] is sorted, we can use two pointers (left, right) to examine all ranges
     *
     * Duplicate may still happen because nums may contain duplicate
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new LinkedList<>();
        Set<List<Integer>> seenPairs = new HashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            int target = -nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {

                int sum = nums[left] + nums[right];
                if (sum == target) {
                    List<Integer> candidate = Arrays.asList(nums[i], nums[left], nums[right]);
                    if (!seenPairs.contains(candidate)) {
                        result.add(candidate);
                        seenPairs.add(candidate);
                    }
                    left++;
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ThreeSum solution = new ThreeSum();
        System.out.println(solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(solution.threeSum(new int[]{-2, 0, 0, 2, 2}));
    }
}
