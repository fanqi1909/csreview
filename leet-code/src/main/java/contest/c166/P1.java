package contest.c166;

public class P1 {

    public int subtractProductAndSum(int n) {
            long product = 1;
            long sum = 0;
            while(n > 0) {
                int digit = n % 10;
                product *= digit;
                sum += digit;
                n = n/10;
            }
            return (int) (product - sum);
    }

    public static void main(String[] args) {
        P1 solution = new P1();
        System.out.println(solution.subtractProductAndSum(234));
        System.out.println(solution.subtractProductAndSum(4421));
    }
}
