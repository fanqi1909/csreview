package contest.c164;

import java.util.*;

public class P3 {

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        System.out.println(Arrays.toString(products));

        List<List<String>> results = new LinkedList<>();
        for (int i = 1; i <= searchWord.length(); i++) {
            List<String> result = search(products, searchWord.substring(0, i));
            results.add(result);
        }
        return results;
    }

    private List<String> search(String[] products, String substring) {
        int l = 0;
        int r = products.length - 1;
        while (l < r) {
            int m = (l + r) >>> 1;
            String mid = products[m].substring(0, Math.min(products[m].length(), substring.length()));
            if (mid.compareTo(substring) < 0) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        if (products[l].startsWith(substring)) {
            List<String> results = new LinkedList<>();
            for (int i = 0; i < 3 && l + i < products.length; i++) {
                if (products[l + i].startsWith(substring)) {
                    results.add(products[l + i]);
                }
            }
            return results;
        } else {
            return Collections.emptyList();
        }
    }

    public static void main(String[] args) {
        P3 solution = new P3();
        System.out.println(solution.suggestedProducts(new String[]{"mobile", "mouse", "moneypot", "monitor", "mousepad"}, "mouse"));

        System.out.println(solution.suggestedProducts(new String[]{"havana"}, "havana"));

        System.out.println(solution.suggestedProducts(new String[]{"bags", "baggage", "banner", "box", "cloths"}, "bags"));
        System.out.println(solution.suggestedProducts(new String[]{"havana"}, "tatiana"));
        System.out.println(solution.suggestedProducts(new String[]{"code", "codephone", "coddle", "coddles", "codes"}, "coddle"));

    }
}
