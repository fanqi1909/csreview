package ps.google.array.string.heap;

public class KthLargestElement {
    public int findKthLargest(int[] nums, int k) {
        return findK(nums, 0, nums.length - 1, k);
    }

    private int findK(int[] nums, int begin, int end, int k) {
        if(begin == end) return nums[begin];

        int position = partition(nums, begin, end);
        if(position == k - 1) {
            return nums[position];
        } else if(position > k - 1) {
            return findK(nums, begin, position - 1, k);
        } else {
            return findK(nums, position + 1, end, k);
        }
    }

    //always take end as the pivot
    private int partition(int[] nums, int begin, int end) {
        int i = begin, j = end;
        while (i < j) {
            while (i < j && nums[i] >= nums[end]) { i++; }
            while (i < j && nums[j] <= nums[end]) { j--; }
            if(i < j) {
                swap(nums, i, j);
            }
        }
        swap(nums, end, j);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        KthLargestElement solution = new KthLargestElement();


        System.out.println(solution.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2) + " === 5");
        System.out.println(solution.findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4) + " === 4");
        System.out.println(solution.findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 1) + " === 6");
        System.out.println(solution.findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 2) + " === 5");
        System.out.println(solution.findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 3) + " === 5");

    }
}
