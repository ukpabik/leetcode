class Solution {


  // Greedy Solution -> O(n) time complexity
  public boolean canJump(int[] nums) {
    // Start the goal as the end of the array
    int goal = nums.length - 1;


    // Start at the second to last index and see if you can reach the goal
    // Keep going backwards and see if you're able to reach the goal
    for (int i = goal - 1; i >= 0; i--){

      // If this condition is true, that means you can reach the goal from this position
      // Now, the new goal is that current position
      if (i + nums[i] >= goal){
        goal = i;
      }
    } 


    // This return statement is important.
    // You should only return true if you were able to reach the goal,
    // which in our case, goal should equal to the starting index.
    // This is correct because if the goal = 0, then that means from the 0th index
    // you are able to reach the nth index.
    return goal == 0 ? true : false;
  }


  // DP Solution -> O(n^2) time complexity
  public boolean canJumpDP(int[] nums){
    int n = nums.length;
    boolean[] dp = new boolean[n];

    // The last index can always reach itself.
    dp[n-1] = true;

    // Start at the second to last index and iterate backwards
    for (int i = n - 2; i >= 0; i--){
      // Calculate our current jump
      int jump = Math.min(i + nums[i], n - 1);

      // Loop from i to the jump
      for (int j = i + 1; j <= jump; j++){
        // If we can reach that spot, meaning dp[j] = true, then we can mark dp[i] as true
        if (dp[j]){
          dp[i] = true;
          break;
        }
      }
    }


    // If dp[0] is true, this means that we were able to reach this spot
    // from the goal.
    return dp[0];
  }
}
