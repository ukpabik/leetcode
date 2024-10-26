class Solution {

  // O(N) solution
  public long zeroFilledSubarray(int[] nums) {
    // Keep track of our result and the length of our contiguous set of zeros
    long res = 0;
    long count = 0;


    for (int n : nums){
      // Increase the length of our set of contiguous zeros if the current num
      // is a zero. Also, add our count to res.
      // Number of subarrays in a contiguous set -> n(n+1) / 2
      if (n == 0){
        count++;
        res += count;
      }
      // If the current number is not a zero, we can reset our length to zero
      else{
        count = 0;
      }
    }

    
    return res;
  }
}
