package ps.google.dp;

public class BestTimeToBSStock {

    /**
     *
     * for each day, find the maximum prices that in the future it can sell.
     * let r[i] be the maximum prices in the future of point i, e.g, max(prices[i+1 : n])
     * the the maximum profit = for all i, max (r[i] - prices[i])
     *
     * @param prices
     */
    public int maxProfit(int[] prices) {
        if(prices.length == 0) return 0;


//        int[] r = new int[prices.length];
//        r[r.length - 1] = prices[r.length - 1];
        int rMax = prices[prices.length - 1];
        int max = 0;
        for(int j = prices.length - 2; j >=0; j--) {
            rMax = Math.max(rMax, prices[j+1]);
            max = Math.max(max, rMax - prices[j]); // buy at time j, sell at price r[j]
        }
        return max;
    }

    public static void main(String[] args) {
        BestTimeToBSStock bst = new BestTimeToBSStock();
        System.out.println(bst.maxProfit(new int[]{7,1,5,3,6,4}));

        System.out.println(bst.maxProfit(new int[]{7,6,4,3,1}));

        System.out.println(bst.maxProfit(new int[]{1}));
    }
}
