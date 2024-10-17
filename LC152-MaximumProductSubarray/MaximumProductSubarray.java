class Solution {
  public int maxProduct(int[] nums) {
    int n = nums.length;

    // Check base cases
    if (n == 1) {
      return nums[0];
    }

    // Use two DP arrays to store the max and min products
    int[] maxDP = new int[n];
    int[] minDP = new int[n];

    // Initialize the starter elements
    maxDP[0] = nums[0];
    minDP[0] = nums[0];
    int res = nums[0];  // Start with the first element as the result

    // Iterate through the array and get the maxes and mins of the current products
    for (int i = 1; i < n; i++) {

      // Update max and min
      maxDP[i] = Math.max(nums[i], Math.max(maxDP[i-1] * nums[i], minDP[i-1] * nums[i]));
      minDP[i] = Math.min(nums[i], Math.min(maxDP[i-1] * nums[i], minDP[i-1] * nums[i]));

      // Update the res to the current max product
      res = Math.max(res, maxDP[i]);
    }

    return res;
  }
}

