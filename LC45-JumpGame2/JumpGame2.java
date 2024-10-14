class Solution {

  // DP Solution -> O(n^2) time complexity
  public int jump(int[] nums) {
    // This is all similar to Jump Game 1
    int n = nums.length;
    int[] dp = new int[n];
    Arrays.fill(dp, n);

    // Last index is always 0 because if we are at the last index,
    // it requires no jumps to reach it.
    dp[n-1] = 0;


    // Same as Jump Game 1, loop through the array backwards starting from
    // the second to last position.
    for (int i = n - 2; i >= 0; i--){
      // Calculate our current jump, which is either the current max jump,
      // or the length of the entire array.
      int jump = Math.min(i + nums[i], n - 1);
      
      // Here, we go from the goal to where we can jump to and check to see if
      // we can make that jump. If we can, set the # of jumps for the ith position
      // in the dp array to the minimum between the current amount of jumps to reach
      // the ith position, or 1 jump + the amount of jumps to reach the prev goal
      for (int j = i + 1; j <= jump; j++){
        if (j <= i + jump){
          dp[i] = Math.min(1 + dp[j], dp[i]);
        }
      }
    }


    return dp[0];
  }
}
