package org.jace.cs.review.lc.array.p41;

import java.util.*;

public class Solution {
    Random random = new Random();

    public int firstMissingPositive(int[] nums) {
        if(nums.length == 0) {
            return 1;
        }

        Set<Integer> sets = new HashSet();
        for(int num : nums) {
            if(num > 0) {
                sets.add(num);
            }
        }
        int last = 0;
        Iterator<Integer> iterator = sets.iterator();
        while(iterator.hasNext()) {
            nums[last++] = iterator.next();
        }

//        int l = 0, r = nums.length - 1;
//        while (l < r) {
//            while (l < r && nums[r] <= 0) r--;
//            while (l < r && nums[l] > 0) l++;
//            swap(nums, l, r);
//        }

//        System.out.println(Arrays.toString(nums) + "\t" + l + "\t" + r);

        if (last == 0) {
            return 1;
        }
        if(last == 1) {
            if(nums[last - 1] != 1) {
                return 1;
            } else {
                return 2;
            }
        }


        return pivotNums(nums, 0, last - 1, 0);

    }

    private void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }

    private int pivotNums(int[] nums, int start, int end, int leftBound) {
//        System.out.printf("Starting with range:[%d,%d], leftBound=[%d], Array=[%s]\n", start, end, leftBound, Arrays.toString(nums));
        if (end == start) {
            if (nums[start] - leftBound != 1) {
                return leftBound + 1;
            } else {
                return nums[start] + 1;
            }
        }


        int splitPoint = partition(nums, start, end);
//        System.out.println("After Pivoting for range[" + start + "," + end + "]\t" + Arrays.toString(nums) + "\t with pivot: " + nums[splitPoint] + "\t split point index:" + splitPoint);

        //check left right
        if(splitPoint + 1 == nums[splitPoint]) {
            //go to right
            return  pivotNums(nums, Math.min(splitPoint + 1, end), end, nums[splitPoint]);
        } else {
            //go to left
            return  pivotNums(nums, start, Math.max(splitPoint - 1, start), leftBound);
        }

    }

    private int partition(int[] nums, int start, int end) {
        //pivoting with nums[start]
        int pivot = random.nextInt(end - start) + start;
//        int pivot = start;
        swap(nums, pivot, end);


        int l = start;
        int r = end;
        while(l < r) {
            while(l < end && nums[l] < nums[end]) l++;
            while(r > start && nums[r] >= nums[end]) r--;
            if(l < r) {
                swap(nums, l, r);
            }
        }
        swap(nums, end, l);
        return l;
    }
}