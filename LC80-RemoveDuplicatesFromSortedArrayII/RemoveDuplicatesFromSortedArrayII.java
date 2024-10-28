class Solution {


  // O(N) solution modifying the array in place
  public int removeDuplicates(int[] nums) {

    // Check our base case
    if (nums.length <= 2) return nums.length;

    // Start at spot 2 to make sure we have only at maximum 2 duplicates
    int idx = 2;

    // If the value 2 spots before the idx is != i, this means there is a duplicate we need to remove 
    for (int i = 2; i < nums.length; i++){
      if (nums[i] != nums[idx - 2]){
        nums[idx] = nums[i];
        idx++;
      }
    }

    return idx;
  }
}
