class Solution {

  // Using Kadane's Algorithm with DP -> O(N) time and O(1) space
  public int maxSubArray(int[] nums) {
    // Base case
    if (nums.length == 1){
      return nums[0];
    }

    // Initialize our dp array and our max value to keep track of the subarray we want to return.
    int n = nums.length;
    int[] dp = new int[n];
    // These both should be the first element, in case all other subarrays are less than
    // the first element.
    int max = nums[0];
    dp[0] = nums[0];

    // Loop through and check the subarrays by comparing the current value to 
    // the previous max + the current value.
    for (int i = 1; i < n; i++){
      dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);

      // Make sure to update the max after every iteration.
      max = Math.max(max, dp[i]);
    }

    return max;
  }
}
