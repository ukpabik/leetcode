class Solution {
  public int lengthOfLIS(int[] nums) {

    // Base cases
    if (nums.length == 1){
      return 1;
    }

    if (nums.length == 0){
      return 0;
    }

    // Fill the dp array with 1s because each element can be a subsequence
    int[] dp = new int[nums.length];
    Arrays.fill(dp, 1);




    // Loop through starting at the second index, and check the previous elements
    // to see if they can be included in the subsequence
    for (int i = 1; i < dp.length; i++){
      for (int j = 0; j < i; j++){
        // If the prev element is less than the current element,
        // we can include it in our subsequence, thus increasing our current length.
        if (nums[j] < nums[i]){
          dp[i] = Math.max(1 + dp[j], dp[i]);
        }
      }
    }


    int max = 0;

    // After we get all of the subsequence sizes, we loop through the dp array and
    // find the max value.
    for (int size : dp){
      max = Math.max(size, max);
    }


    return max;
  }
}
