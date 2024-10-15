import java.util.HashMap;

class Solution {
  
  // DP Solution -> even slower than DP (O(2^n))

  public int findTargetSumWaysDP(int[] nums, int target) {
    // Initialize our nested hashmap in order to keep track of current total and index
    HashMap<Integer, HashMap<Integer, Integer>> dp = new HashMap<>();
    return backtrack(nums, dp, 0, 0, target);
  } 

  private int backtrack(int[] nums, HashMap<Integer, HashMap<Integer, Integer>> dp, int index, int total, int target){
    // If we've reached the end of the array, check if our total is equal
    // to the target, if it is, then we return 1 because this is a valid expression.
    if (index == nums.length){
      return total == target ? 1 : 0;
    }

    // If we have already stored the current subproblem, return it.
    if (dp.containsKey(index) && dp.get(index).containsKey(total)){
      return dp.get(index).get(total);
    }

    // Go both ways, either add or subtract to go towards the target.
    int add = backtrack(nums, dp, index + 1, total + nums[index], target);
    int subtract = backtrack(nums, dp, index + 1, total - nums[index], target);

    // Add the index once we've reached the end of the backtracking.
    // We're putting the amount of ways (add + subtract) into the final index,
    // and then returning this value.
    return add + subtract;
  }




  // Backtracking solution -> O(2^n) very slow
  
  // Start with a counter that counts valid expressions
  int count = 0;
  public int findTargetSumWays(int[] nums, int target) {
    backtrack(nums, target, 0, 0);
    return count;
  } 


  // Create our backtracking recursive function
  public void backtrack(int[] nums, int target, int temp, int start){
    // If we have checked all values in this path,
    // we check to see if the temp sum is equal to the target value.
    // If it is, then this is a valid path.
    if(start == nums.length){
      if(temp == target){
        count++;
      }
      return;
    }

    // Check both paths, if we add the number, or if we subtract it
    backtrack(nums, target, temp + nums[start], start + 1);
    backtrack(nums, target, temp - nums[start], start + 1);

  }
}
