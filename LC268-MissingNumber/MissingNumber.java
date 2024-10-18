import java.util.HashSet;

class Solution {
  public int missingNumber(int[] nums) {
    int res = 0;
    HashSet<Integer> set = new HashSet<>();

    // Add all numbers into a set so we can find the value that isn't included
    for (int i = 0; i < nums.length; i++){
      set.add(nums[i]);
    }

    // Go through the entire range from 0 to the length of the array
    // Check to see if the set contains i, if it doesn't, then that is our value
    // to return.
    for (int i = 0; i <= nums.length; i++){
      if (!set.contains(i)){
        res = i;
        break;
      }
    }

    return res;
  }
}
