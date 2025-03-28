package DponStocks;

import java.util.Arrays;

public class buySell_2 {
    public static int help(int[] prices, int index, int buy, int[][] dp) {
        if (index == prices.length)
            return 0;
        int profit = 0;

        if (buy == 0) {
            profit = Math.max(0 + help(prices, index + 1, 0, dp), -prices[index] + help(prices, index + 1, 1, dp));
        }
        if (buy == 1) {
            profit = Math.max(0 + help(prices, index + 1, 1, dp), prices[index] + help(prices, index + 1, 0, dp));
        }
        return profit;
    }

    public static int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }

        return help(prices, 0, 0, dp);
    }

    public static void main(String[] args) {
        int []prices = {7,1,5,3,6,4};
       System.out.println( maxProfit(prices));
    }
}
