package ps.google.array.string;

public class BackspaceStringCompare {

    /**
     * Use to pointers to scan two strings reversely. When meet a '#', then we skip the next non '#' character
     * @param S
     * @param T
     * @return
     */
    public boolean twoPointersApproach(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;
        int skipS = 0, skipT = 0;

        while (i >= 0 || j >= 0) { // While there may be chars in build(S) or build (T)
            while (i >= 0) { // Find position of next possible char in build(S)
                if (S.charAt(i) == '#') {
                    skipS++;
                    i--;
                } else if (skipS > 0) {
                    skipS--;
                    i--;
                } else break;
            }
            while (j >= 0) { // Find position of next possible char in build(T)
                if (T.charAt(j) == '#') {
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    skipT--;
                    j--;
                } else break;
            }
            // If two actual characters are different
            if (i >= 0 && j >= 0 && S.charAt(i) != T.charAt(j))
                return false;
            // If expecting to compare char vs nothing
            if ((i >= 0) != (j >= 0))
                return false;
            i--;
            j--;
        }
        return true;
    }


    /**
     * Use two stack to simulate the # process to get the final result. Compare the final result
     * @param S
     * @param T
     * @return
     */
    public boolean stackApproach(String S, String T) {
        int[] stackS = new int[S.length()];
        int[] stackT = new int[T.length()];

        int ps = simulate(stackS, S);
        int pt = simulate(stackT, T);

        if (ps != pt) return false;
        for (int i = 0; i < ps; i++) {
            if (stackS[i] != stackT[i]) {
                return false;
            }
        }
        return true;
    }

    private int simulate(int[] stack, String s) {
        int p = 0;
        for (char c : s.toCharArray()) {
            if (c != '#') {
                stack[p++] = c;
            } else {
                p = Math.max(0, p - 1);
            }
        }
        return p;
    }

    public static void main(String[] args) {
        BackspaceStringCompare solution = new BackspaceStringCompare();

        System.out.println(solution.stackApproach("ab#c", "ad#c"));
        System.out.println(solution.stackApproach("ab##", "c#d#"));
        System.out.println(solution.stackApproach("a##c", "#a#c"));
        System.out.println(!solution.stackApproach("a##c", "#a#b"));

        System.out.println(solution.twoPointersApproach("ab#c", "ad#c"));
        System.out.println(solution.twoPointersApproach("ab##", "c#d#"));
        System.out.println(solution.twoPointersApproach("a##c", "#a#c"));
        System.out.println(!solution.twoPointersApproach("a##c", "#a#b"));
    }
}
