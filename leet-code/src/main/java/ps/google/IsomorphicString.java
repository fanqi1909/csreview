package ps.google;

import java.util.HashSet;
import java.util.Set;

public class IsomorphicString {
    public boolean isIsomorphic(String s, String t) {
        String[] sIndexMap = new String[128];
        String[] tIndexMap = new String[128];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            sIndexMap[c] = (sIndexMap[c] == null) ? "" + i : sIndexMap[c] + "," + i;

            c = t.charAt(i);
            tIndexMap[c] = (tIndexMap[c] == null) ? "" + i : tIndexMap[c] + "," + i;
        }

        Set<String> sSet = new HashSet<>();
        for (String s1 : sIndexMap) {
            if (s1 != null) {
                sSet.add(s1);
            }
        }

        for (String s2 : tIndexMap) {
            if (s2 != null && !sSet.contains(s2)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        IsomorphicString iss = new IsomorphicString();
        System.out.println(iss.isIsomorphic("egg", "add"));
        System.out.println(iss.isIsomorphic("foo", "bar"));
        System.out.println(iss.isIsomorphic("paper", "title"));
    }
}
