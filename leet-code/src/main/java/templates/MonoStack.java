package templates;

import java.util.Deque;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class MonoStack {

    /**
     * find the closest greater number;
     * @param numbers
     */
    public void monoDecrease(int[] numbers) {
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < numbers.length; i++) {
            while (!stack.isEmpty() && numbers[i] >= numbers[stack.peek()]) {
                int current = stack.pop();
//                System.out.println("Left largest value of [" + numbers[current] + "] is " + stack.peek());
                if(!stack.isEmpty()) {
                    System.out.printf("%d: left closest greater = [%d], right closest greater =[%d] \n", numbers[current], numbers[stack.peek()], numbers[i]);
                }
            }
            stack.push(i);
        }
        System.out.println(stack.stream().map(i -> numbers[i]).collect(Collectors.toList()));
    }

    /**
     * find the closest smaller number;
     * @param numbers
     */
    public void monoIncrease(int[] numbers) {
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < numbers.length; i++) {
            while (!stack.isEmpty() && numbers[i] <= numbers[stack.peek()]) {
                int current = stack.pop();
//                System.out.println("Left largest value of [" + numbers[current] + "] is " + stack.peek());
                if(!stack.isEmpty()) {
                    System.out.printf("%d: left closest smaller=[%d], right closest smaller =[%d] \n", numbers[current], numbers[stack.peek()], numbers[i]);
                } else {
                    System.out.printf("%d: left closest smaller=[null], right closest smaller =[%d] \n", numbers[current], numbers[i]);
                }
            }
            stack.push(i);
        }
        System.out.println(stack.stream().map(i -> numbers[i]).collect(Collectors.toList()));
    }

    public static void main(String[] args) {
        int[] test = new int[]{11, 2, 4, 3, 10, 1, 7, 8, 6, 9, 5};
        MonoStack monoStack = new MonoStack();
        System.out.println("Increasing Stack");
        monoStack.monoDecrease(test);

        System.out.println("Decreasing Stack");
        monoStack.monoIncrease(test);

        int[] test2 = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println("Increasing Stack");
        monoStack.monoDecrease(test2);

        System.out.println("Decreasing Stack");
        monoStack.monoIncrease(test2);
    }
}
