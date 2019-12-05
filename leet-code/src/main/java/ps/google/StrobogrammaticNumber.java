package ps.google;

public class StrobogrammaticNumber {

    public boolean isStrobogrammatic(String num) {
        return helper(num.toCharArray(), 0, num.length()-1);
    }

    private boolean helper(char[] num, int start, int end) {
        if(end < start) return true;
        if(end == start) return num[start] == '0' || num[start] == '1'  || num[start] == '8';
        char lc = num[start];
        char rc = num[end];
        if ((lc == '6' && rc == '9')
                || (lc == '8' && rc == '8')
                || (lc == '9' && rc == '6')
                || (lc == '1' && rc == '1')
                || (lc == '0' && rc == '0')) {
            return helper(num, start + 1, end -1);
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        StrobogrammaticNumber sgn = new StrobogrammaticNumber();

        System.out.println(sgn.isStrobogrammatic("69"));
        System.out.println(sgn.isStrobogrammatic("88"));
        System.out.println(sgn.isStrobogrammatic("962"));
        System.out.println(sgn.isStrobogrammatic("60809"));
    }
}
