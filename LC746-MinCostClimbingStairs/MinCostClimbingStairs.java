class Solution {
  public int minCostClimbingStairs(int[] cost) {

    // Initialize dp array
    int n = cost.length;
    int[] dp = new int[n];

    // Base cases for if n < 3
    // We have to set the n-1 and n-2 steps because we can take either 1 or 2 steps.
    dp[n-1] = cost[n-1];
    dp[n-2] = cost[n-2];


    // Loop through the array from the 3rd to last step, and add
    // the cost of that step + the minimum of taking 1 step or 2 steps.
    for (int i = n-3; i >= 0; i--){
      dp[i] = cost[i] + Math.min(dp[i + 1], dp [i + 2]);
    }

    // You can start from the first or second step, so return the minimum between
    // the two.
    return Math.min(dp[0], dp[1]);
  }
}
