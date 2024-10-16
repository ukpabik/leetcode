class Solution{


  // Brute force solution -> O(N^3) very slow
  public String longestPalindrome(String s) {
        int n = s.length();

        String maxSub = "";
        int currMax = Integer.MIN_VALUE;

        if (n == 0) return "";
        if (n == 1) return s;

        for (int i = 0; i < n; i++){
            for (int j = i + 1; j < n; j++){
                // Check if the substrings are palindromes, and that the current 
                // substring is larger than the previous max.
                if (isPalindrome(s.substring(i, j + 1)) && (j - i) > currMax){
                    maxSub = s.substring(i, j + 1);
                    currMax = j - i;
                }
            }
        }

        // Return the current max if we found one, else return the first char of s.
        return maxSub != "" ? maxSub : "" + s.charAt(0);
    }


  // Helper function to determine whether we have a palindrome or not.
  public boolean isPalindrome(String s){
    int one = 0, two = s.length() - 1;
    while (one < two){
      if (s.charAt(one) != s.charAt(two)){
        return false;
      }
      one++;
      two--;
    }
    return true;
  }
}
