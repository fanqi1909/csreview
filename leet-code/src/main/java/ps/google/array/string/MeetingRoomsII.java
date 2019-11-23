package ps.google.array.string;

import java.util.Arrays;

public class MeetingRoomsII {


    public int minMeetingRooms(int[][] intervals) {
        int[][] endPoints = new int[intervals.length * 2][2];
        int next = 0;
        for (int[] interval : intervals) {
            endPoints[next][0] = interval[0];
            endPoints[next][1] = 1;
            next++;
            endPoints[next][0] = interval[1];
            endPoints[next][1] = -1;
            next++;
        }

        Arrays.sort(endPoints, (o1, o2) -> {
            if(o1[0] != o2[0]) {
                return o1[0] - o2[0];
            } else {
                return o1[1] - o2[1];
            }
        });
//        Util.print2DArray(endPoints);
        int ans = 0;
        int max = 0;
        for (int[] endPoint : endPoints) {
            ans += endPoint[1];
            max = Math.max(max, ans);
        }
        return max;
    }

    public static void main(String[] args) {
        MeetingRoomsII solution = new MeetingRoomsII();
        System.out.println(solution.minMeetingRooms(new int[][]{
                new int[]{0, 30},
                new int[]{5, 10},
                new int[]{15, 20}
        }));

        System.out.println(solution.minMeetingRooms(new int[][]{
                new int[]{7, 10},
                new int[]{2, 3}
        }));

        System.out.println(solution.minMeetingRooms(new int[][]{
                new int[]{13, 15},
                new int[]{1, 13}
        }));


        System.out.println(solution.minMeetingRooms(new int[][]{
                new int[]{13, 15},
                new int[]{13, 17},
                new int[]{1, 13},
                new int[]{5, 13}
        }));
    }
}
