class Solution {


  // A good O(N log N) solution because we are squaring the values inside the while loop
  public int longestSquareStreak(int[] nums) {

    // Add our input array to a set so we can use contains method
    Set<Integer> set = new HashSet<>();
    for (int n : nums){
      set.add(n);
    }

    int max = 0;

    // Loop through each value in the array
    for (int i = 0; i < nums.length; i++){


      int currMax = 1;
      // Our initial value will be the square of nums[i]
      // and we start the max at 1 to include the current val
      int curr = (int)Math.pow(nums[i], 2);

      // Keep checking if the squared value is found in the set
      while (set.contains(curr)){ 
        currMax++;
        curr = (int)Math.pow(curr, 2);
      }

      // If the currMax is still = 1, we didn't even go in the loop
      if (currMax > 1){
        max = Math.max(currMax, max);
      }
    }

    // Return max only if a subarray was found, if not, return -1
    return max > 0 ? max : -1;
  }
}
