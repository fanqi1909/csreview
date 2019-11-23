package ps.google.array.string.two.pointers;

public class ContainerWithMostWater {

    /**
     * Enumerate all [i,j] ranges, to find the max
     * O(n^2) time
     * O(1) time
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int maxarea = 0;
        for (int i = 0; i < height.length; i++)
            for (int j = i + 1; j < height.length; j++)
                maxarea = Math.max(maxarea, Math.min(height[i], height[j]) * (j - i));
        return maxarea;
    }

    /**
     *
     * Twp pointers to meet in the middle.
     * suppose j > i;
     *
     * Area = (j - i) * Math.min(height[j], height[i])
     *
     * The proof is a bit tricky.
     * Suppose height[i] < height[j];
     *
     * Area = (j-i) * height[i];
     *
     * Next, if we move j, then
     * Area_1 = (j-i-1) * height[i] // height[j-1] > height[i]
     * Area_2 = (j-i-1) * height[j-1] // height[j-1] < height[i]
     * Both Area_1 and Area_2 are less than Area
     * So we can only move i.
     *
     * @param height
     * @return
     */
    public int maxArea2(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while(left < right) {
            maxArea = Math.max((right - left) * Math.min(height[right], height[left]), maxArea);
            if(height[right] > height[left]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }


    public static void main(String[] args) {

        ContainerWithMostWater solution = new ContainerWithMostWater();

        int[] test = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(solution.maxArea(test)  + "\t" + solution.maxArea2(test));

        test = new int[]{1,2,3,4,5,6,7,8,9,10,9,8,7,6,5,4,3,2,1};
        System.out.println(solution.maxArea(test)  + "\t" + solution.maxArea2(test));
    }
}
