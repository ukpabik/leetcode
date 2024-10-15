class Solution {

    // DP Solution
    public int rob(int[] nums) {
        // Take care of base cases here
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];

        // Initialize dp array with dp base cases
        int[] dp = new int[n];
        // The first and the second must be initialized as such because they are adjacent, and these are the starting places.
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);

        // Go from i = 2 to the end, marking dp[i] as the max of two paths.
        // The two paths are either robbing the house, or skipping it.
        for (int i = 2; i < n; i++){
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }

        // Return the max amount of money, which is the last element in the dp array.
        return dp[n - 1];
    }
}