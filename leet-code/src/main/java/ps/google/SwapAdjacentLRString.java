package ps.google;

import java.util.Deque;
import java.util.LinkedList;

public class SwapAdjacentLRString {

    /**
     * Better solution. Check for all L in start appears after its matching Ls in end. All R in the start appears before R's in End
     */
    public boolean canTransform2(String start, String end) {
        if (!start.replace("X", "").equals(end.replace("X", "")))
            return false;

        int t = 0;
        for (int i = 0; i < start.length(); ++i)
            if (start.charAt(i) == 'L') {
                while (end.charAt(t) != 'L') t++;
                if (i < t++) return false;
            }

        t = 0;
        for (int i = 0; i < start.length(); ++i)
            if (start.charAt(i) == 'R') {
                while (end.charAt(t) != 'R') t++;
                if (i > t++) return false;
            }

        return true;
    }


    public boolean canTransform(String start, String end) {
        if(start.length() != end.length()) return false;

        if(start.length() == 0) return true;

        return helper(start.toCharArray(), end.toCharArray(), 0);

    }

    private boolean helper(char[] s, char[] e, int pos) {
        if(pos >= s.length) return true;
        char sc = s[pos];
        char ec = e[pos];

        if (sc == ec) return helper(s, e, pos+1);

        if(sc == 'L') return false;
        else if(sc == 'R') {
            if(ec == 'L') return false;
            //ec = 'X'
            int next = pos + 1;
            while(next < s.length) {
                if(s[next] == 'R')
                    next++;
                else if(s[next] == 'X')
                    break;
                else
                    return false; // hit L
            }
            if(next == s.length) return false;
            s[next]= 'R';
            s[pos] = 'X';
            return helper(s, e, pos + 1);
        } else {
            //(sc == 'X')
            if(ec == 'L') {
                int next = pos + 1;
                while(next < s.length) {
                    if(s[next] == 'X') {
                        next++;
                    } else if(s[next] == 'L') {
                        break;
                    } else {
                        return false; //hit R
                    }
                }
                if(next == s.length) return false;
                s[next] = 'X';
                s[pos] = 'L';
                return helper(s, e, pos + 1);

            } else {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        SwapAdjacentLRString salr = new SwapAdjacentLRString();

        System.out.println(salr.canTransform("RXXLRXRXL", "XRLXXRRLX"));
        System.out.println(salr.canTransform("XXRXXLXXXX", "XXXXRXXLXX"));

        System.out.println(salr.canTransform("XXXLXXXXXX", "XXXLXXXXXX"));
        System.out.println(salr.canTransform("XXXXRXXXLX", "XXXXRLXXXX"));
    }

}
