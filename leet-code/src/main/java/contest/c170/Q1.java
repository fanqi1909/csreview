package contest.c170;

import java.util.Arrays;

public class Q1 {

    public String freqAlphabets(String s) {
        char[] cipher = s.toCharArray();
        for(int i = 0; i < cipher.length; i++) {
            if(cipher[i] == '#') {
                char letter = (char) (((cipher[i-2] - '0') * 10 + (cipher[i-1] - '0') - 1) + 'a');
                cipher[i-1] = 0;
                cipher[i-2] = 0;
                cipher[i] = letter;
            }
        }

//        System.out.println(Arrays.toString(cipher));

        StringBuilder ans = new StringBuilder();
        for(int i = 0; i < cipher.length; i++) {
            if(Character.isDigit(cipher[i])) {
                ans.append((char)(cipher[i] - '0' - 1 + 'a'));
            } else if(Character.isLowerCase(cipher[i])){
                ans.append(cipher[i]);
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        Q1 sol = new Q1();

        System.out.println(sol.freqAlphabets("10#11#12"));
        System.out.println(sol.freqAlphabets("1326#"));
        System.out.println(sol.freqAlphabets("25#"));
        System.out.println(sol.freqAlphabets("12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#"));

    }
}
