package knapsackProblems;

import java.util.ArrayList;
import java.util.Arrays;

public class zeroOneKnpsck {
    public static int getProfitMaxi(int index, ArrayList<Integer> values, ArrayList<Integer> weights, int w,
            int[][] dp) {
                if (index == 0) {
                    if (weights.get(index) <= w) {
                        // Include the item if its weight is within the capacity
                        return values.get(0);
                    } else {
                        // Otherwise, exclude the item
                        return 0;
                    }
                }
        if (dp[index][w] != -1)
            return dp[index][w];

        int nottake = 0 + getProfitMaxi(index - 1, values, weights, w, dp);

        int take = Integer.MIN_VALUE;
        if (weights.get(index) <= w) {
            take = values.get(index) + getProfitMaxi(index - 1, values, weights,  w - weights.get(index), dp);
        }

        return dp[index][w]=Math.max(nottake, take);

    }

    public static int maxProfit(ArrayList<Integer> values, ArrayList<Integer> weights, int n, int w) {
        int[][] dp = new int[n ][w + 1];
        for (int orw[] : dp) {
            Arrays.fill(orw, -1);
        }
        return getProfitMaxi(n - 1, values, weights, w, dp);
    }

    public static void main(String[] args) {
        int n = 4, w = 10;
        int[] first = { 6, 1, 5, 3 };
        int[] second = { 3, 6, 1, 4 };
        ArrayList<Integer> weights = new ArrayList<>();
        ArrayList<Integer> values = new ArrayList<>();
        for (int i = 0; i < first.length; i++) {
            weights.add(first[i]);
        }
        for (int i = 0; i < second.length; i++) {
            values.add(second[i]);
        }

        System.out.println(maxProfit(values, weights, n, w));

    }
}
