public class subsetSum {
    public static boolean canPartition(int[] nums) {
        int totalSum = 0;
        for (int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
        }
        if (totalSum % 2 == 1)
            return false;
        int target = totalSum / 2;

        boolean dp[][] = new boolean[nums.length+1][target +1];
        for (int i = 0; i < nums.length; i++) dp[i][0]= true;
          
        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j <= target; j++) {
               boolean notPick  =  dp[i-1][j];
                boolean pick = false;
                        if(nums[i] <= j)  pick = dp[i-1][j- nums[i]];
                        dp[i][j]= pick | notPick;
            }
        }
        return dp[nums.length-1][target];
    }

    public static void main(String[] args) {
int []nums = {1,2,3,5};
boolean ans =  canPartition(nums);
System.out.println(ans);
    }
}
