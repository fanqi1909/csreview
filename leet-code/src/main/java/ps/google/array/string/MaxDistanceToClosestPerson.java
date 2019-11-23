package ps.google.array.string;

public class MaxDistanceToClosestPerson {

    public int maxDistToClosest(int[] seats) {
        int prev1 = -1;
        int maxDis = 0;
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] != 0) {
                if (prev1 == -1) {
                    maxDis = Math.max(maxDis, i);
                } else {
                    maxDis = Math.max(maxDis, (i - prev1) / 2);
                }
                prev1 = i;
            } else if (i == seats.length - 1) {
                maxDis = Math.max(maxDis, i - prev1);
            }
        }
        return maxDis;
    }

    public static void main(String[] args) {
        MaxDistanceToClosestPerson solution = new MaxDistanceToClosestPerson();
        System.out.println(solution.maxDistToClosest(new int[]{1, 0, 0, 0, 1, 0, 1}) + "=== 2");
        System.out.println(solution.maxDistToClosest(new int[]{1, 0, 0, 0}) + "=== 3");
        System.out.println(solution.maxDistToClosest(new int[]{1, 0, 0, 0, 0, 0, 0, 0, 1}) + "=== 4");
        System.out.println(solution.maxDistToClosest(new int[]{1, 1, 1, 1, 0, 1, 1, 1, 1}) + "=== 1");
    }
}
