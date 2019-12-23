package contest.c168;

public class Q1 {
    public int findNumbers(int[] nums) {
        int count = 0 ;
        for(int num : nums) {
            if(evenDigit(num)) {
                count++;
            }
        }
        return count;
    }

    private boolean evenDigit(int num) {
        String n = num +"";
        return n.length()  % 2 == 0;
    }

    public static void main(String[] args) {
        Q1 sol = new Q1();
        System.out.println(sol.findNumbers(new int[]{12, 345, 2, 6, 7896}));
        System.out.println(sol.findNumbers(new int[]{555, 901, 482,1771}));
    }
}
