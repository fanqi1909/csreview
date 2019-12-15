package ps.google.array.string;

public class ExpressiveWords {
    public int expressiveWords(String S, String[] words) {
        String sCode = runLength(S);
        int matches = 0;
        for (String word : words) {
            String wCode = runLength(word);
            if (match(sCode, wCode)) {
                matches++;
//                System.out.println(sCode + "\t" + wCode);
            }
        }
        return matches;
    }

    private boolean match(String sCode, String wCode) {
        if (sCode.length() != wCode.length()) return false;
        for (int i = 0; i < sCode.length(); i++) {
            boolean matches = sCode.charAt(i) == wCode.charAt(i);
            if ((i & 1) == 0 && !matches) {
                return false;
            }
            if ((i & 1) == 1 && !matches) {
                if(sCode.charAt(i) < '3') {
                    return false;
                } else if(sCode.charAt(i) < wCode.charAt(i)) {
                    return false;
                }
            }
        }
        return true;
    }

    private String runLength(String input) {
        if (input.length() <= 1) {
            return input;
        } else {
            StringBuilder builder = new StringBuilder();
            int count = 1;
            char last = input.charAt(0);
            for (int i = 1; i < input.length(); i++) {
                if (input.charAt(i) == input.charAt(i - 1)) {
                    count++;
                } else {
                    builder.append(last);
                    builder.append(count);
                    count = 1;
                    last = input.charAt(i);
                }
            }
            builder.append(last);
            builder.append(count);
            return builder.toString();
        }

    }

    public static void main(String[] args) {
        ExpressiveWords solution = new ExpressiveWords();
        System.out.println(solution.expressiveWords("heeellooo", new String[]{"hello", "hi", "helo"}));
        System.out.println(solution.expressiveWords("dddiiiinnssssssoooo", new String[]{"dinnssoo","ddinso","ddiinnso","ddiinnssoo","ddiinso","dinsoo","ddiinsso","dinssoo","dinso"}));

    }
}
