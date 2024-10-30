class Solution {

  // O(N * sum(nums)) solution
  // For smaller sums, it is faster than a O(2^n) approach
  public boolean canPartition(int[] nums) {

    // Base case: check if sum is even
    // if sum is odd, we cant partition it
    int sum = 0;
    for (int n : nums){
      sum += n;
    }
    if (sum % 2 != 0) return false;

    // Our target value will be half of the sum
    int target = sum / 2;

    // Create our dp set to hold all of our potential sums
    Set<Integer> dp = new HashSet<>();
    dp.add(0);

    // Loop through in reverse order, considering every value in the array
    for (int i = nums.length - 1; i >= 0; i--){
      Set<Integer> tempDP = new HashSet<>();

      // For all potential sums in dp, add the current nums[i] + that sum, because that is a new potential sum
      for (int n : dp){
        // If we already find our target, return true
        if (n + nums[i] == target) return true;
        tempDP.add(n + nums[i]);
        tempDP.add(n);
      }

      // Update our dp set
      dp = tempDP;
    }   
    // If we have found our target value, return true!
    return dp.contains(target);
  }
}
