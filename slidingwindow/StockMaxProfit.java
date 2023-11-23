package neetcode.slidingwindow;

public class StockMaxProfit {

    public static int maxProfit(int[] prices) {

        int i = 0;
        int j = i + 1;
        int profit = 0;
        while (j < prices.length) {
            int costPrice = prices[i];
            int sellPrice = prices[j];

            if(sellPrice >= costPrice) {
                profit = Math.max(profit,sellPrice - costPrice);
                j++;
            } else {
                i++;
            }
            if(j == prices.length) {
                i++;
            }
        }


        return profit;

    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 2, 5, 3, 6, 40}));
        System.out.println(maxProfit(new int[]{7,6,4,3,1}));
    }
}
