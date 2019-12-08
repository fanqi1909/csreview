package ps.google;

import java.util.ArrayList;
import java.util.List;

public class MyCalendarII {
    List<int[]> booking;
    List<int[]> overlap;

    public MyCalendarII() {
        booking = new ArrayList<>();
        overlap = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        for(int[] intv : overlap) {
            if(intv[0] < end && start < intv[1]) {
                return false;
            }
        }
        for(int[] intv : booking) {
            if(intv[0] < end && start < intv[1]) {
                overlap.add(new int[]{Math.max(start, intv[0]), Math.min(end, intv[1])});
            }
        }
        booking.add(new int[]{start ,end});
        return true;
    }
}
