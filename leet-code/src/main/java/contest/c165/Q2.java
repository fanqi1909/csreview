package contest.c165;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Q2 {
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        if(tomatoSlices % 2 == 1) {
            return Collections.emptyList();
        }

        if(tomatoSlices < 2 * cheeseSlices || tomatoSlices > 4 * cheeseSlices) {
            return Collections.emptyList();
        }

        int halfTomato = tomatoSlices / 2;
        return Arrays.asList(halfTomato -cheeseSlices, 2 * cheeseSlices - halfTomato);
    }

    public static void main(String[] args) {
        Q2 q = new Q2();
        System.out.println(q.numOfBurgers(16, 7));
        System.out.println(q.numOfBurgers(17, 4));
        System.out.println(q.numOfBurgers(4, 17));
        System.out.println(q.numOfBurgers(0, 0));
        System.out.println(q.numOfBurgers(2, 1));
    }

}
