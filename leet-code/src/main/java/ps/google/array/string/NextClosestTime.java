package ps.google.array.string;

public class NextClosestTime {

    /**
     * Enumerate all possible combinations.
     *
     * @param time
     * @return
     */
    public String nextClosestTime(String time) {
        int[] numbers = new int[4];

        int hour = Integer.parseInt(time.substring(0,2));
        int minute = Integer.parseInt(time.substring(3));
        int current = hour * 60 + minute;

        int next = 0;
        int min = 10;
        for(char c : time.toCharArray()) {
            if(c != ':') {
                numbers[next++] = c - '0';
                if(c-'0' < min) {
                    min = c - '0';
                }
            }
        }


        int bestH = min * 10 + min;
        int bestM = min * 10 + min;
        int earliest = 9999;
        for(int h : numbers) {
            for(int h2 : numbers) {
                if(h * 10 + h2 < 24) {
                    for(int m : numbers) {
                        for(int m2: numbers) {
                            if(m*10 + m2 < 60) {
                                int cand = (h * 10 + h2 ) * 60 + m*10 + m2;
                                if(cand  - current > 0 && cand - current < earliest) {
                                    bestH = h*10 + h2;
                                    bestM = m*10 + m2;
                                    earliest = cand - current;
                                }
                            }
                        }
                    }
                }
            }
        }
        return String.format("%02d:%02d", bestH, bestM);
    }

    public static void main(String[] args) {
        NextClosestTime solution = new NextClosestTime();
        System.out.println(solution.nextClosestTime("23:59"));
        System.out.println(solution.nextClosestTime("19:34"));
        System.out.println(solution.nextClosestTime("01:32"));
    }
}
