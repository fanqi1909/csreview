package cn;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Majiang {

    public static void main(String[] args) {
        int[] numbers = new int[13];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 13; i++) {
            numbers[i] = scanner.nextInt();
        }
        List<Integer> nexts = findNext(numbers);
        System.out.println(nexts);
    }

    private static List<Integer> findNext(int[] numbers) {
        List<Integer> ans = new LinkedList<>();
        int[] stats = new int[10];
        for (int num : numbers) {
            stats[num]++;
        }

        for (int i = 1; i <= 9; i++) {
            if (stats[i] <= 3) {
                System.out.println(Arrays.toString(stats));
                stats[i]++;
                if (isValid(1, stats, false)) {
                    ans.add(i);
                }
                stats[i]--;
                System.out.println(Arrays.toString(stats));
            }
        }
        return ans;
    }

    private static boolean isValid(int start, int[] stats, boolean hasPair) {
        if (start > 9) return hasPair;

        if (stats[start] == 0) {
            return isValid(start + 1, stats, hasPair);
        } else if (stats[start] == 1) {
            if (start > 7) return false;
            if (stats[start + 1] < 1 || stats[start + 2] < 1) {
                return false; // no enough cons
            }
            stats[start + 1]--;
            stats[start + 2]--;
            boolean ans = isValid(start + 1, stats, hasPair);
            stats[start + 1]++;
            stats[start + 2]++;
            return ans;
        } else if (stats[start] == 2) {
            boolean ans = false;
            if (!hasPair) {
                ans = isValid(start + 1, stats, true);
                if (ans) {
                    return true;
                }
            }

            if(start <= 7) {
                stats[start] -= 1; // two group of 3
                if (stats[start + 1] < 1 || stats[start + 2] < 1) {
                    stats[start] += 1;
                    return false; // no enough cons
                }
                stats[start + 1]--; stats[start + 2]--;
                ans = isValid(start, stats, hasPair);
                stats[start + 1]++; stats[start + 2]++;
                stats[start] += 1;
            }
            return ans;

        } else if (stats[start] == 3) {
            boolean ans = isValid(start + 1, stats, hasPair); // group of 3
            if (ans) {
                return ans;
            } else {
                stats[start] -= 2;
                ans = isValid(start, stats, true);
                stats[start] += 2;
                return ans;
            }
        } else if (stats[start] == 4) {
            //group of 3 and a dangling
            stats[start] -= 3;
            boolean ans = isValid(start, stats, hasPair);
            stats[start] += 3;
            if (ans) {
                return ans;
            } else {
                stats[start] -= 2;
                ans = isValid(start, stats, true);
                stats[start] += 2;
            }
            return ans;
        } else {
            return false; //has a number with more than 4...
        }
    }
}
