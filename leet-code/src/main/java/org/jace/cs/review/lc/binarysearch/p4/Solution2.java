package org.jace.cs.review.lc.binarysearch.p4;

public class Solution2 {
    public double findMedianSortedArrays(int[] A, int[] B) {
        if(A.length == 0) {
            return median(B);
        }
        if(B.length == 0) {
            return median(A);
        }

        if((A.length + B.length) % 2 == 0) {
            for(int i = 0; i < A.length; i++) {
                int j = (A.length + B.length) / 2 - i - 2;
                System.out.println(i+"\t" + j);
                if(j+1 >= B.length) {
                    continue;
                }

                if(A[i] < B[j+1] && B[j] < A[i+1]) {
                    //found;
                    return (max(A[i], B[j]) + min(A[i+1], B[j+1])) / 2.0;
                }

            }
        } else {
            for(int i = 0; i < A.length; i++) {
                int j = (A.length + B.length) / 2 - i - 1;
                if(j+1 >= B.length) {
                    continue;
                }
                System.out.println(i+"\t" + j);
                if(A[i] < B[j+1] && B[j] < A[i+1]) {
                    //found;
                    return max(A[i], B[j]);
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();

        System.out.println(solution2.findMedianSortedArrays(new int[]{0,1,4,6,9}, new int[]{2,3,5,7}) + " == " + 4);
        System.out.println(solution2.findMedianSortedArrays(new int[]{0,6,9}, new int[]{1,2,3}) + " == " + 2.5);
    }

    private double median(int[] nums) {
        int left = nums.length >> 1;
        int right = (nums.length - 1) >>  1;
        return (nums[left] + nums[right]) / 2.0;
    }

    private int max(int a, int b) {
        return a > b ? a : b;
    }

    private int min(int a, int b) {
        return a < b ? a : b;
    }
}
