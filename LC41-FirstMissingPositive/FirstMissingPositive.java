class Solution {

  // O(N) solution using a HashSet
  public int firstMissingPositive(int[] nums) {

    // Set our result to 1, as that is the smallest positive number
    int res = 1;
    // Initialize our max for our top bound in loop
    int max = 0;

    // Create a set to hold all of the values in the array
    Set<Integer> set = new HashSet<>();

    // Add all values to set, and find our top bound
    for (int n : nums){
      if (n != Integer.MAX_VALUE && n != Integer.MIN_VALUE){
        max = Math.max(n, max);
        set.add(n);
      }
    }

    // Going up from 1, we want to find the smallest value
    // that is not in the set
    for (int i = 1; i <= max + 1; i++){
      if (!set.contains(i)){
        // Once found, break and return this value
        res = i;
        break;
      }
    }

    return res;

  }
}
