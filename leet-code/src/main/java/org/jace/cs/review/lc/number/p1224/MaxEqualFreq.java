package org.jace.cs.review.lc.number.p1224;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaxEqualFreq {

    public int maxEqualFreq(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        Map<Integer, Integer> freqCount = new HashMap<>();

        int len = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int oldFreq = freq.getOrDefault(num, 0);
            int newFeq = oldFreq + 1;
            freq.put(num, newFeq);
            freqCount.put(newFeq, freqCount.getOrDefault(newFeq, 0) + 1);
            freqCount.put(oldFreq, freqCount.getOrDefault(oldFreq, 0) - 1);
            if (freqCount.get(oldFreq) <= 0) {
                freqCount.remove(oldFreq);
            }

            if (valid(freq, freqCount)) {
                len = i;
            }
        }

        return len + 1;
    }

    private boolean valid(Map<Integer, Integer> freq, Map<Integer, Integer> freqCount) {

        if (freq.keySet().size() == 0 || freq.keySet().size() == 1) {
            //only 0 or 1 element
            return true;
        }

        List<Integer> freqs = new ArrayList<>(freqCount.keySet());
        if (freqs.size() == 1) {
            return freqs.get(0) == 1;
        } else if (freqs.size() == 2) {
            if (freqCount.get(freqs.get(0)) == 1) {
                if (freqs.get(0) == 1 || freqs.get(0) - freqs.get(1) == 1)
                    return true;
            }
            if (freqCount.get(freqs.get(1)) == 1) {
                return freqs.get(1) == 1 || freqs.get(1) - freqs.get(0) == 1;
            }
            return false;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        MaxEqualFreq mef = new MaxEqualFreq();
        System.out.println(mef.maxEqualFreq(new int[]{2, 2, 1, 1, 5, 3, 3, 5}));
        System.out.println(mef.maxEqualFreq(new int[]{1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5}));
        System.out.println(mef.maxEqualFreq(new int[]{1, 1, 1, 1}));
        System.out.println(mef.maxEqualFreq(new int[]{1, 1, 1, 2, 2, 2}));
        System.out.println(mef.maxEqualFreq(new int[]{10, 2, 8, 9, 3, 8, 1, 5, 2, 3, 7, 6}));
    }
}
