package contest.c180;

public class CustomStack {

    int[] stack;
    int head;

    public CustomStack(int maxSize) {
        stack = new int[maxSize];
        head = 0;
    }

    public void push(int x) {
        if(head < stack.length) {
            stack[head++] = x;
        }
    }

    public int pop() {
        if(head == 0) {
            return -1;
        } else {
            return stack[--head];
        }
    }

    public void increment(int k, int val) {
        int upper = Math.min(k, head - 1);
        for(int i = 0; i <= upper; i++) {
            stack[i] += val;
        }
    }

    public static void main(String[] args) {
        CustomStack sol = new CustomStack(3);
        sol.push(1);
        sol.push(2);
        sol.pop();
        sol.push(2);
        sol.push(3);
        sol.push(4);
        sol.increment(5, 100);
        sol.increment(2, 100);
        sol.pop();
        sol.pop();
        sol.pop();
        sol.pop();


    }

}
