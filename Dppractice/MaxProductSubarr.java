package Dppractice;

public class MaxProductSubarr {
    public static int maxProduct(int[] nums) {
        int suffix = 1;
        int prefix = 1;
        int ans = Integer.MIN_VALUE;
        int n = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (prefix == 0)
                prefix = 1;
            if (suffix == 0)
                suffix = 1;

            prefix *= nums[i];
            suffix *= nums[n - i - 1];

            ans = Math.max(ans, Math.max(prefix, suffix));
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { -2, 0, -1 };
        System.out.println(maxProduct(nums));
    }
}
