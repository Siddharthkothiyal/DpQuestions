import java.util.Arrays;

class Solution {
    private static int subsetSumHelper(int[] arr, int n, int target, int[][] dp) {
       // Base cases
       if (target == 0) return 1;
       if (n == 0) return 0;
       
       // Check if already computed
       if (dp[n][target] != -1) {
           return dp[n][target];
       }
       
       // Not pick the current element
       int notPick = subsetSumHelper(arr, n - 1, target, dp);
       
       // Pick the current element if it does not exceed target
       int pick = 0;
       if (arr[n - 1] <= target) {
           pick = subsetSumHelper(arr, n - 1, target - arr[n - 1], dp);
       }
       
       // Store the result in the dp array
       dp[n][target] = (pick == 1 || notPick == 1) ? 1 : 0;
       return dp[n][target];
   }

   static int perfectSum(int arr[], int target) {
       int n = arr.length;
       int[][] dp = new int[n + 1][target + 1];
       for (int[] row : dp) {
           Arrays.fill(row, -1);
       }
       return subsetSumHelper(arr, n, target, dp);
   }


    public static void main(String[] args) {
      
        int[] nums = {28, 4, 3, 27, 0, 24, 26};
        int target = 24;
        System.out.println(perfectSum(nums, target));;
    }
}