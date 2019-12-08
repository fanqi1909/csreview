package contest.c166;


public class P3 {

    public int smallestDivisor(int[] nums, int threshold) {
        int l = 1, r = 1000001;
        while (l < r) {
            int mid = (l + r) >>> 1;
            int sum = compute(nums, mid);
            if (sum > threshold) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }

    private int compute(int[] nums, int mid) {
        int sum = 0;
        for (int num : nums) {
            sum += Math.ceil(num * 1.0 / mid);
        }
        return sum;
    }

    public static void main(String[] args) {
        P3 solution = new P3();
        System.out.println(solution.smallestDivisor(new int[]{1, 2, 5, 9}, 6));
        System.out.println(solution.smallestDivisor(new int[]{2, 3, 5, 7, 11}, 11));
        System.out.println(solution.smallestDivisor(new int[]{19}, 5));
    }
}
