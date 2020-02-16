package org.jace.cs.review.lc.interval.p1353;

import org.jace.cs.review.lc.dp.Util;

import java.util.*;

public class MaxNumberOfEventsCanBeAttended {

    public int maxEvents(int[][] events) {

        Arrays.sort(events, (e1, e2) -> {
            if(e1[0] == e2[0]) {
                return e1[1] - e2[1];
            } else {
                return e1[0] - e2[0];
            }
        });

        Util.print2DArray(events);

        TreeMap<int[], Integer> orderedEvents = new TreeMap<>((e1, e2)->{
            if(e1[0] != e2[0]) {
                return e1[0] - e2[0];
            } else {
                return e1[1] - e2[1];
            }
        });

        int lastDay = 0;
        int firstDay = 0;
        for(int[] event : events) {
            lastDay = Math.max(lastDay, event[1]);
            firstDay = Math.min(firstDay, event[0]);
            orderedEvents.put(event, orderedEvents.getOrDefault(event, 0) + 1);
        }

        int maxEvent = 0;

        for(int i = firstDay; i <= lastDay && !orderedEvents.isEmpty(); i++) {
            int minClosing = lastDay + 1;
            int[] selectedEvent = null;

            for(int[] event : orderedEvents.keySet()) {
                if(event[0] <= i && event[1] >= i) {
                    if(event[1] <= minClosing) {
                        minClosing = event[1];
                        selectedEvent = event;
                    }
                } else if(event[0] >=i) {
                    break;
                }
            }

            if(selectedEvent != null) {
                maxEvent++;
                orderedEvents.put(selectedEvent, orderedEvents.get(selectedEvent) - 1);
                if(orderedEvents.get(selectedEvent) == 0) {
                    orderedEvents.remove(selectedEvent);
                }
            }
        }

        return maxEvent;
    }

    public static void main(String[] args) {
        MaxNumberOfEventsCanBeAttended sol = new MaxNumberOfEventsCanBeAttended();

        System.out.println(sol.maxEvents(new int[][]{
                new int[]{1, 5},
                new int[]{1, 5},
                new int[]{1, 5},
                new int[]{2, 3},
                new int[]{2, 3},
        }));
//
        System.out.println(sol.maxEvents(new int[][]{
                new int[]{1, 2},
                new int[]{1, 2},
                new int[]{3, 3},
                new int[]{1, 5},
                new int[]{1, 5},
        }));
//        [[1,2],[1,2],[3,3],[1,5],[1,5]]

        System.out.println(sol.maxEvents(new int[][]{
                new int[]{1, 2},
                new int[]{2, 3},
                new int[]{3, 4}
        }));

        System.out.println(sol.maxEvents(new int[][]{
                new int[]{1,2},
                new int[]{2,3},
                new int[]{3,4},
                new int[]{1,2},
        }));


        System.out.println(sol.maxEvents(new int[][]{
                new int[]{1,4},
                new int[]{4,4},
                new int[]{2,2},
                new int[]{3,4},
                new int[]{1,1},
        }));

        System.out.println(sol.maxEvents(new int[][]{
                new int[]{1,100000}
        }));
        System.out.println(sol.maxEvents(new int[][]{
                new int[]{1,1},
                new int[]{1,2},
                new int[]{1,3},
                new int[]{1,4},
                new int[]{1,5},
                new int[]{1,6},
                new int[]{1,7}
        }));
    }
}