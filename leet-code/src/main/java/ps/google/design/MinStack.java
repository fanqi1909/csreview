package ps.google.design;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Use a monotonic stack "mStack" to keep track of all the mins so far. The min stack is updated with aStack.
 *
 * Another optimization would be a run-length encoding to compress mStack. The space would be practically smaller, but
 * asymptotically greater
 */
public class MinStack {

    private Deque<Integer> aStack; // store actual data
    private Deque<Integer> mStack; // store current min

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        aStack = new LinkedList<>();
        mStack = new LinkedList<>();
    }

    public void push(int x) {
        aStack.push(x);
        if (mStack.isEmpty() || mStack.peek() >= x) {
            mStack.push(x);
        } else {
            mStack.push(mStack.peek());
        }
    }

    public void pop() {
        if (!aStack.isEmpty()) {
            aStack.pop();
            mStack.pop();
        }
    }

    public int top() {
        return aStack.isEmpty() ? Integer.MIN_VALUE : aStack.peek();
    }

    public int getMin() {
        return mStack.isEmpty() ? Integer.MIN_VALUE : mStack.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}
