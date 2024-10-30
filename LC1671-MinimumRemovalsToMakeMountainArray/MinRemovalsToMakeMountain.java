class Solution {


  // O(N^2) solution
  public int minimumMountainRemovals(int[] nums) {
    // Base case for mountain size
    if (nums.length < 3){
      return -1;
    }

    // We are going to need both an LIS and an LDS
    int[] lis = new int[nums.length];
    int[] lds = new int[nums.length];

    int maxMountainSize = -1;

    // Fill our arrays with the value of 1 as a base
    Arrays.fill(lis, 1);
    Arrays.fill(lds, 1);

    // Calculate our LIS first going from left to right
    for (int i = 1; i < nums.length; i++){
      for (int j = 0; j < i; j++){
        if (nums[j] < nums[i]){
          lis[i] = Math.max(lis[i], 1 + lis[j]);
        }
      }
    }


    // Calculate our LDS next, which lds[i] is the longest LDS starting from i
    for (int i = nums.length - 2; i >= 0; i--) {
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[j] < nums[i]) {
          lds[i] = Math.max(1 + lds[j], lds[i]);
        }
      }
    }

    // calculate our max mountain size, and this will be the mountain we are looking for
    for (int i = 0; i < nums.length; i++){

      // Check to see if they are both valid mountains
      if (lis[i] > 1 && lds[i] > 1){
        maxMountainSize = Math.max(maxMountainSize, lis[i] + lds[i] - 1);
      }
    }

    // Return the number of elements - max mountain size as the number of elements we need to remove
    return maxMountainSize > 0 ? nums.length - maxMountainSize : 0;
  }
}
