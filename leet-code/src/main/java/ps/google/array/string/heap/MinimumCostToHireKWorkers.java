package ps.google.array.string.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimumCostToHireKWorkers {

    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        if (K == 0) return 0.0;

        Worker[] workers = new Worker[quality.length];
        for (int i = 0; i < workers.length; i++) {
            workers[i] = new Worker(quality[i], wage[i]);
        }

        Arrays.sort(workers, Comparator.comparingInt(w -> w.quality));

        PriorityQueue<Worker> currentBest = new PriorityQueue<>(K, Comparator.comparing(w -> -w.ratio));
        int currentSum = 0;
        double currentCost = 0;

        for (Worker worker : workers) {
            if (currentBest.size() < K) {
                currentBest.add(worker);
                currentSum += worker.quality;
                currentCost = currentSum * currentBest.peek().ratio;
            } else {
                if(worker.ratio < currentBest.peek().ratio) {
                    Worker currentWorst = currentBest.poll();
                    currentBest.add(worker);
                    currentSum = currentSum - currentWorst.quality + worker.quality;
                    double nCost = currentSum * currentBest.peek().ratio;
                    if (nCost < currentCost) {
                        currentCost = nCost;
                    }
                }
            }
           // System.out.println(currentBest + "\t" + worker +"\t" + currentSum + "\t" + currentCost);
        }
        return currentCost;
    }

    class Worker {
        int quality;
        int wage;
        double ratio;

        public Worker(int quality, int wage) {
            this.quality = quality;
            this.wage = wage;
            this.ratio = wage * 1.0 / quality;
        }

        @Override
        public String toString() {
            return String.format("[%d,%d,%f]", quality, wage, ratio);
        }
    }

    public static void main(String[] args) {
        MinimumCostToHireKWorkers solution = new MinimumCostToHireKWorkers();

        System.out.println(
                solution.mincostToHireWorkers(new int[]{10, 20, 5}, new int[]{70, 50, 30}, 2)
        );

        System.out.println(
                solution.mincostToHireWorkers(new int[]{3, 1, 10, 10, 1}, new int[]{4, 8, 2, 2, 7}, 3)
        );
    }
}
