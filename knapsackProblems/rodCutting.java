package knapsackProblems;

 public class rodCutting {

    // recursion 


//     public static int cutTherod(int index, int n, int[] price) {
//         if (index == 0)
//             return n * price[0];

//         int notTake = 0 + cutTherod(index - 1, n, price);
//         int take = Integer.MIN_VALUE;
//         int rodLength = index + 1;

//         if (index < price.length && rodLength <= n) {
//             take = price[index] + cutTherod(index, n - rodLength, price);
//         }
//         return Math.max(take, notTake);
//     }


   // using memoizations
//     public static int cutTherod(int index, int n, int[] price , int [][] dp) {
//         if (index == 0)
//             return n * price[0];

// if(dp[index][n] != -1) return dp[index][n];

//         int notTake = 0 + cutTherod(index - 1, n, price , dp);
//         int take = Integer.MIN_VALUE;
//         int rodLength = index + 1;

//         if (index < price.length && rodLength <= n) {
//             take = price[index] + cutTherod(index, n - rodLength, price, dp);
//         }
//         return  dp[index][n]= Math.max(take, notTake);
//     }

    public static int minCost(int[] price) {

       int n = price.length;
          int dp[][] = new int[n][n + 1];

        for (int i = 0; i <=n; i++) {
            dp[0][i] = i* price[0];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= n; j++) {
                int notTake = dp[i - 1][j];
                int take = Integer.MIN_VALUE;
                int rodLength = i + 1;

                if (rodLength <= j) {
                    take = price[i] + dp[i][j - rodLength];
                }
            
            dp[i][j]= Math.max(take, notTake);
            }
        }
        return dp[n - 1][n];
    }

    public static void main(String[] args) {
        int price[] = { 1, 5, 8, 9, 10, 17, 17, 20 };
      
        System.out.println(minCost(price));
        ;
    }
}
