package Dppractice;

public class coinChange {
    public static int coinChange2(int[] coins, int amount) {

        int dp[][] = new int[coins.length ][amount + 1];
        for (int i = 0; i <= amount; i++) {
            if(i % coins[0] ==0)
            dp[0][i] = 1;

        }
        for (int ind = 1; ind < coins.length; ind++) {
            for (int target = 0; target <= amount; target++) {
                int notTake = dp[ind - 1][target];
                int take = 0;
                if (coins[ind] <= target)   take = dp[ind][target - coins[ind]];
                
                dp[ind][target] = take + notTake;
            }
        }

        return dp[coins.length-1][amount];
    }

    public static void main(String[] args) {
       int[] coins = {1,2,5};
       int amount = 11;
System.out.println(coinChange2(coins, amount));
       
    }
}
