package ps.google.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Build up the number fo less digits. Because of the duality, we need to consider both n-1 and n-2 cases for
 * different parities.
 */
public class StroboNumber2 {
    final List<String> self = Arrays.asList("0", "1", "8");
    final List<String> base2 = Arrays.asList("00", "69", "88", "96", "11");

    public List<String> findStrobogrammatic(int n) {

        if (n == 0) {
            return new LinkedList<>();
        }
        if (n == 1) {
            return self;
        }
        if (n == 2) {
            List<String> result = new LinkedList<>(base2);
            result.remove(0); // 00 is not valid in the head
            return result;
        }

        if ((n & 1) == 1) {
            List<String> less1 = findStrobogrammatic(n - 1);
            List<String> result = new LinkedList<>();
            int half = (n - 1) >>> 1;
            for (String base : self) {
                for (String less : less1) {
                    result.add(less.substring(0, half) + base + less.substring(half, n - 1));
                }
            }
            return result;
        } else {
            List<String> less2 = findStrobogrammatic(n - 2);
            List<String> result = new LinkedList<>();
            int half = (n - 2) >>> 1;
            for (String base : base2) {
                for (String less : less2) {
                    result.add(less.substring(0, half) + base + less.substring(half, n - 2));
                }
            }
            return result;
        }
    }

    public static void main(String[] args) {
        StroboNumber2 stro = new StroboNumber2();
        System.out.println(stro.findStrobogrammatic(1));
        System.out.println(stro.findStrobogrammatic(2));
        System.out.println(stro.findStrobogrammatic(3));
        System.out.println(stro.findStrobogrammatic(4));
        System.out.println(stro.findStrobogrammatic(6));
    }
}