package cn;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class TaskPriority {

    static class Task implements Comparable<Task> {
        int id;
        int pmid;
        int start;
        int priority;
        int duration;
        int end;

        public Task(int id, int pid, int s, int p, int d) {
            this.id = id;
            this.pmid = pid;
            this.start = s;
            this.priority = p;
            this.duration = d;
        }

        @Override
        public int compareTo(Task o) {
            if (this.start != o.start) {
                return this.start - o.start;
            }
            if (priority != o.priority) {
                return priority - o.priority;
            }
            if (duration != o.duration) {
                return duration - o.duration;
            }
            return pmid - o.pmid;
        }

        @Override
        public String toString() {
            return String.format("[%d: %d %d %d %d %d]", id, pmid, start, priority, duration, end);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int p = scanner.nextInt();
        PriorityQueue<Task> queue = new PriorityQueue<>(p);
        PriorityQueue<Integer> workers = new PriorityQueue<>(m);

        for (int i = 0; i < p; i++) {
            queue.add(new Task(i, scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt()));
        }
        System.out.print(queue);
        for (int i = 0; i < m; i++) {
            workers.add(0);
        }

        int time = 0;
        Task[] tasks = new Task[p];

        while (!queue.isEmpty()) {
            if(queue.peek().start > time || workers.peek() > time) {
                time++;
            } else {
                workers.poll();
                Task t = queue.poll();
                t.end = t.duration + time;
                tasks[t.id] = t;
                workers.add(t.end);
                System.out.println("Processing task " + t + " at time " + time);
               // time++;
            }
        }
        Arrays.stream(tasks).map(t -> t.end).forEach(System.out::println);
    }
}
