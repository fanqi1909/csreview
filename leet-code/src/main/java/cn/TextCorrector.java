package cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TextCorrector {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int cases = scanner.nextInt();
        for (int i = 0; i < cases; i++) {
            String test = scanner.next();
            String result = correct(test);
            System.out.println(result);
        }
    }

    private static String correct(String test) {
        char[] input = test.toCharArray();
        List<Character> counts = new ArrayList<>();
        int i = 0;
        int count = 1;
        while (i < input.length - 1) {
            if (input[i] != input[i + 1]) {
                counts.add(input[i]);
                counts.add((char) (count + '0'));
                count = 1;
            } else {
                count++;
            }
            i++;
        }
        counts.add(input[input.length - 1]);
        counts.add((char) (count + '0'));

        StringBuilder builder = new StringBuilder();
        for (int index = 0, len = counts.size(); index < len; index += 2) {
            char c = counts.get(index);
            char n = counts.get(index + 1);
            if(n >= '2') {
                if(index != 0 && counts.get(index - 1) >= '2') {
                    counts.set(index + 1, '1');
                    n = '1';
                } else {
                    counts.set(index + 1, '2');
                    n = '2';
                }
            }
            for(int x = 0; x < n - '0'; x++) {
                builder.append(c);
            }
        }

        return builder.toString();
    }
}
