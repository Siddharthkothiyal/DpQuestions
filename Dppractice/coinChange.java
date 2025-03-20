package Dppractice;

import java.util.Arrays;

public class coinChange {
    public static int coinChange2(int[] coins, int amount, int[][] dp, int index) {
        if (index == 0) {
            if (amount % coins[0] == 0)
                return amount / coins[0];
            return (int) 1e9;
        }

        if (dp[index][amount] != -1)
            return dp[index][amount];

        int notTake = 0 + coinChange2(coins, amount, dp, index - 1);

        int take = Integer.MAX_VALUE;
        if (coins[index] <= amount) {
            take = 1 + coinChange2(coins, amount - coins[index], dp, index);
        }

        return dp[index][amount] = Math.min(take ,notTake);

    }

    public static int change(int[] coins, int amount) {
        int[][] dp = new int[coins.length+1][amount+1];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }
        int ans = coinChange2(coins, amount, dp, coins.length - 1);
        if (ans >= (int) 1e9)
            return -1;
        return ans;

    }

    public static void main(String[] args) {
        int[] coins = { 1, 2, 5 };
        int amount = 11;
System.out.println(change(coins, amount));
    }
}
