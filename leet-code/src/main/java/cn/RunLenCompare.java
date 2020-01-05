package cn;

public class RunLenCompare {

    class RLEncoder {
        int nextPos = 0;
        int nextCount = 0;
        char nextChar = 0;
        char[] data;
        public RLEncoder(String s) {
            this.data = s.toCharArray();
            refill();
        }

        public boolean hasNext() {
            return nextCount !=0 || nextPos < data.length;
        }

        public void popChar(int num) {
            if(nextCount >= num) {
                nextCount = nextCount - num;
            }
            if(nextCount == 0) {
                refill();
            }
        }

        public void refill() {
            nextCount = 0;
            if(nextPos < data.length) {
                while (nextPos < data.length && Character.isDigit(data[nextPos])) {
                    nextCount = nextCount * 10 + (data[nextPos] - '0');
                    nextPos++;
                }
                nextChar = data[nextPos];
                nextPos++;
            }
        }
    }

    public int compare(String s1, String s2) {
        RLEncoder e1 = new RLEncoder(s1);
        RLEncoder e2 = new RLEncoder(s2);

        while(e1.hasNext() && e2.hasNext()) {
            if(e1.nextChar < e2.nextChar) {
                return -1;
            } else if(e1.nextChar > e2.nextChar) {
                return 1;
            } else {
                int minCount = Math.min(e1.nextCount, e2.nextCount);
                e1.popChar(minCount);
                e2.popChar(minCount);
            }
        }
        if(e1.hasNext()) {
            return 1;
        } else if(e2.hasNext()) {
            return -1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        RunLenCompare rlc = new RunLenCompare();
        System.out.println("0 ==== " + rlc.compare("1a2a3a", "6a"));
        System.out.println("-1 ==== " + rlc.compare("7a", "6a1b"));
        System.out.println("1 ==== " + rlc.compare("3a3a1c", "6a1b"));
        System.out.println("0 ==== " + rlc.compare("31A2A1B", "33A1B"));
        System.out.println("1 ==== " + rlc.compare("1A2B", "1A"));
        System.out.println("-1 ==== " + rlc.compare("1A2A1B", "2B"));
    }
}
