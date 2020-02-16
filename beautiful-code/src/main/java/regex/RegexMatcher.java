package regex;

/**
 *  This is a piece of code with ~ 100 lines that supports regex matching.
 *  Following chars in regex are allowed
 * <p>
 * 1. c : match any literal character c
 * 2. . : match any single character
 * 3. ^ : match the beginning of the input
 * 4. $ : match the end of the input
 * 5. * : match zero or more occurrences of the previous character
 * 6. + : match one or more occurrences of the previous character
 * 7. ? : match zero or one occurrence of the previous character
 *
 * Assume the regex is always proper, i.e. no symbol after $, always one symbol (.,c) before *. No symbol before '^';
 */
public class RegexMatcher {

    final char[] regExp;
    final char[] text;

    public RegexMatcher(String regx, String text) {
        assert regx != null && !regx.isEmpty();
        assert text != null;
        this.regExp = regx.toCharArray();
        this.text = text.toCharArray();
    }

    public boolean match() {
        if (regExp[0] == '^') {
            return matchHere(1, 0);
        }
        int textPtr = 0;
        do {
            if (matchHere(0, textPtr)) {
                return true;
            }
        } while (textPtr++ < text.length);

        return false;
    }

    /**
     * Match a sub regex regExp[regexPtr ... n) with sub string text[textPtr, ..., m);
     * where, n is the size of regExp, m is the size of text
     */
    private boolean matchHere(int regexPtr, int textPtr) {
        if (regexPtr >= regExp.length) {
            return true;
        }

        if (regExp[regexPtr] == '$') {
            return textPtr == text.length;
        }

        if(regexPtr < regExp.length - 1) {
            if(regExp[regexPtr + 1] == '*') {
                return matchStar(regExp[regexPtr], regexPtr + 2, textPtr);
            }
            if(regExp[regexPtr + 1] == '+') {
                return matchPlus(regExp[regexPtr], regexPtr + 2, textPtr);
            }
            if(regExp[regexPtr + 1] == '?') {
                return matchQuestionMark(regExp[regexPtr], regexPtr + 2, textPtr);
            }
        }

        if (textPtr < text.length && (regExp[regexPtr] == '.' || regExp[regexPtr] == text[textPtr])) {
            return matchHere(regexPtr + 1, textPtr + 1);
        }

        return false;
    }

    private boolean matchQuestionMark(char c, int regexPtr, int textPtr) {
        if(c == text[textPtr]) {
            return matchHere(regexPtr, textPtr + 1);
        } else {
            return matchHere(regexPtr, textPtr);
        }
    }

    //This is a greedy match, match for the shortest
    private boolean matchStar(char c, int regPtr, int textPtr) {
        do {
            // because we need to test for empty text, so we use do-while here
            if (matchHere(regPtr, textPtr)) {
                return true;
            }
        } while (textPtr < text.length && (text[textPtr++] == c || c == '.')); // notice the textPtr++ and the short-cut of ||

        return false;
    }

    /**
     * '+' requires at least one occurrence of a char, so we just need to match the char, and call matchStar
     */
    private boolean matchPlus(char c, int regPtr, int textPtr) {
        if(c == text[textPtr]) {
            return matchStar(c, regPtr, textPtr + 1);
        }
        return false;
    }

    //This is a longest match, trying to find the longest match, and reduce the matching length one by one
    private boolean matchLongestStart(char c, int regPtr, int textPtr) {
        int t = textPtr;

        while(t < text.length && (text[t] == c || c == '.')) {
            t++;
        }

        do {
            if(matchHere(regPtr, t)) {
                return true;
            }
        } while(t-- >= textPtr);

        return false;
    }
}
