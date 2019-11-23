package ps.google.array.string.mono.stack;

import java.util.Deque;
import java.util.LinkedList;

public class TrappingRainWater {

    public int trap(int[] height) {
        return trapStack(height);
    }

    /**
     * Use monotonic stack to find the left,right boundary of each bar
     */
    private int trapStack(int[] height) {
        Deque<Integer> stack = new LinkedList<>();

        int ans = 0;

        for(int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = stack.pop();
                if(!stack.isEmpty()) {
                    System.out.printf("%d %d: left closest smaller=[%d], right closest smaller =[%d] \n",i,  height[top], height[stack.peek()], height[i]);
                    int distance = i - stack.peek() - 1;
                    int bounded_height = Math.min(height[i], height[stack.peek()]) - height[top];
                    ans += distance * bounded_height;
                }
            }
           stack.push(i);
        }
        return ans;
    }


    public static void main(String[] args) {
        TrappingRainWater solution = new TrappingRainWater();
        System.out.println(solution.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}
