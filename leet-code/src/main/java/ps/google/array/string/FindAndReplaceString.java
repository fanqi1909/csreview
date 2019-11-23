package ps.google.array.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindAndReplaceString {
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        StringBuilder result = new StringBuilder();
        int j = 0;
        int i = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int k = 0; k < indexes.length; k++) {
            map.put(indexes[k], k);
        }
        Arrays.sort(indexes);

        while(i < S.length() && j < indexes.length) {
            if(i < indexes[j]) {
                result.append(S.charAt(i));
                i++;
            } else if(i > indexes[j]) {
                j++;
            }else {
                //i == index[j]
                int length = sources[map.get(indexes[j])].length();
                if(S.substring(i, i + length).equals(sources[map.get(indexes[j])])) {
                    //replace
                    result.append(targets[map.get(indexes[j])]);
                    i = i + length;
                } else {
                    result.append(S.charAt(i++));
                }
            }
        }

        while(i < S.length()) {
            result.append(S.charAt(i++));
        }

        return result.toString();
    }

    public static void main(String[] args) {
        FindAndReplaceString solution = new FindAndReplaceString();
        System.out.println(solution.findReplaceString("abcd", new int[]{0, 2}, new String[]{"a", "cd"}, new String[]{"eee", "fff"}));
        System.out.println(solution.findReplaceString("abcd", new int[]{0, 2}, new String[]{"ab", "ec"}, new String[]{"eee", "fff"}));
        System.out.println(solution.findReplaceString("vmokgggqzp", new int[]{3, 1, 5}, new String[]{ "kg", "mo","ggq"}, new String[]{ "s", "bfr", "so"}));
    }
}
