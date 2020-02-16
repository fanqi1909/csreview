package contest.c172;

public class Q1 {
    public int maximum69Number (int num) {
        char[] nums = String.valueOf(num).toCharArray();
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == '6') {
                nums[i] = '9';
                break;
            }
        }
        return Integer.parseInt(String.valueOf(nums));
    }

    public static void main(String[] args) {
        Q1 q = new Q1();
        System.out.println(q.maximum69Number(9669));
        System.out.println(q.maximum69Number(9996));
        System.out.println(q.maximum69Number(9999));
    }
}
