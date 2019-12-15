package cn;

import java.util.Scanner;

public class SecreteAgent {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int d = scanner.nextInt();
        int[] buildings = new int[n];
        for (int i = 0; i < n; i++) {
            buildings[i] = scanner.nextInt();
            if(!scanner.hasNextInt()) {
                break;
            }
        }
        int count = countLocation(buildings, d);
        System.out.println(count);
    }

    private static int countLocation(int[] buildings, int d) {
        int sum = 0;
        for (int i = 0; i < buildings.length; i++) {
            //binary search
            int l = i;
            int r = buildings.length - 1;
            while (l < r) {
                int m = (l + r + 1) >>> 1;
                if (buildings[m] > d + buildings[i]) {
                    r = m - 1;
                } else {
                    l = m;
                }
            }

            int possible = r - i;
            if(possible >= 2) {
                sum += possible * (possible - 1)/2; //c n 2
            }
            if (sum > 99997867) {
                sum = sum - 99997867;
            }
        }
        return sum;
    }
}
