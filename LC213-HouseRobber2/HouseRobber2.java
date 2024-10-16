class Solution{



  // O(N) DP Solution
  // Very similar to HouseRobber 1
  public int rob(int[] nums){
    int n = nums.length;

    // Base cases: If there are no houses, return 0. If there's one house, return its value.
    if (n == 0) return 0;
    if (n == 1) return nums[0];


    // Call robHelper twice: 
    // 1. Exclude the last house and include the first (houses from index 0 to n-2).
    // 2. Exclude the first house and include the last (houses from index 1 to n-1).
    int includeFirst = robHelper(nums, 0, n - 2);
    int excludeFirst = robHelper(nums, 1, n - 1);


    return Math.max(excludeFirst, includeFirst);

  }

  // This helper function basically follows the same algorithm as 
  // House Robber 1, but it allows us to manipulate the starting and ending indices.
  public int robHelper(int[] nums, int start, int end){

    // Calculate size of the current subarray.
    int size = end - start + 1;
    // Base case
    if (size == 1) return nums[start];

    // Initialize our dp array with same base cases as parent function
    int[] dp = new int[size];
    dp[0] = nums[start];
    dp[1] = Math.max(dp[0], nums[start + 1]);

    // Loop through the rest of the subarray starting from the third house:
    // At each house, decide whether to rob it (and add its value to dp[i-2]) or skip it.
    for (int i = 2; i < size; i++){
      dp[i] = Math.max(dp[i - 2] + nums[start + i], dp[i - 1]);
    }

    // Return the maximum money you can rob, which will be stored in dp[size - 1].
    return dp[size - 1];
  }
}
