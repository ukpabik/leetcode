class Solution {


  // DP Solution -> O(N^3) time complexity
  public int countSubstrings(String s) {
    
    // Establish our base cases
    int n = s.length();
    if (n == 0) return 0;
    if (n == 1) return 1;



    // Initialize our dp array  
    int[] dp = new int[n];
    Arrays.fill(dp, 1);

    // Go through the string, and check all possible substrings that we can make.
    for (int i = 0; i < n; i++){
      for (int j = i + 1; j < n; j++){
        // If there is a valid substring, add 1 to the current dp[i], meaning that
        // we can make more than 1 substring starting from that index.
        if (isPalindrome(s.substring(i, j + 1))){
          dp[i] = dp[i] + 1;
        }
      }
    }

    // Sum up all of the values, the values in the dp array represent
    // the number of substrings you can create starting from that index.
    int sum = 0;
    for (int p : dp){
      sum += p;
    }

    return sum;
  }



  // Palindrome helper function
  public boolean isPalindrome(String s){
    int one = 0, two = s.length() - 1;

    while (one < two){
      if (s.charAt(one) != s.charAt(two)) return false;
      one++;
      two--;
    }

    return true;
  }
}
