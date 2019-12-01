package contest.c165;

public class Q4 {

    public int palindromePartition(String s, int k) {
        int len = s.length();
        Integer[][][] lookup = new Integer[len][len][k + 1];

        return helper(s.toCharArray(), 0, len-1, k, lookup);
    }

    private int helper(char[] charArray, int start, int end, int k, Integer[][][] lookup) {
        if(lookup[start][end][k] != null) {
            return lookup[start][end][k];
        }
        if(k == 1) {
            lookup[start][end][k] = toPalindrome(charArray, start, end);
            return lookup[start][end][k];
        }
        if(start == end) {
            lookup[start][end][k] = 0;
            return lookup[start][end][k];
        }
        int min = Integer.MAX_VALUE;
        for(int i = start + k - 2; i < end; i++) {
            int cCost = helper(charArray, start, i, k -1, lookup)
                    + helper(charArray, i + 1, end, 1, lookup);
            min = Math.min(min, cCost);
        }
        lookup[start][end][k] = min;
        return lookup[start][end][k];
    }

    private int toPalindrome(char[] charArray, int start, int end) {
        int convert = 0;
        while(start < end) {
            if(charArray[start] != charArray[end]) {
                convert++;
            }
            start++;
            end--;
        }
        return convert;
    }


    public static void main(String[] args) {
        Q4 q4 = new Q4();
        System.out.println(q4.palindromePartition("abc", 2));
        System.out.println(q4.palindromePartition("aabbc", 3));
        System.out.println(q4.palindromePartition("leetcode", 8));
        System.out.println(q4.palindromePartition("faaglagedtwnejzpuarkgwgoefwra", 27));
        System.out.println(q4.palindromePartition("fyhowoxzyrincxivwarjuwxrwealesxsimsepjdqsstfggjnjhilvrwwytbgsqbpnwjaojfnmiqiqnyzijfmvekgakefjaxryyml", 32));
    }
}
