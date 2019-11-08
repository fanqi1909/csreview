package org.jace.cs.review.lc.search.p55;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public boolean canJump(int[] nums) {

        int start = 0;
        int target = nums.length - 1;

        if(target == start) {
            return true;
        }

        boolean[] visited = new boolean[nums.length];
        Queue<Integer> bfsQueue = new LinkedList<>();

        bfsQueue.add(0);

        while(!bfsQueue.isEmpty()) {
            int current = bfsQueue.poll();
            if(visited[current]) {
                continue;
            }
            for(int i = nums[current]; i >=1 ; i--) {
                int next = i + current;
                if(next < nums.length) {
                    if(next == target) {
                        return true;
                    }
                    if(!visited[next]) {
                        bfsQueue.add(next);
                    }
                }
            }
            visited[current] = true;
        }

        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] test;

        test = new int[]{2,3,1,1,4};
        System.out.println(Arrays.toString(test) + "\t" + solution.canJump(test));

        test = new int[]{3,2,1,0,4};
        System.out.println(Arrays.toString(test) + "\t" + !solution.canJump(test));
    }
}