class Solution {
  public boolean wordBreak(String s, List<String> wordDict) {

    // Initialize our boolean DP array to keep track of our previous subproblems
    boolean[] dp = new boolean[s.length() + 1];
    dp[0] = true;

    // Loop through the given word s
    for (int i = 1; i <= s.length(); i++){

      // For every word in the dictionary, we need to check
      // to see if that word is contained in s
      for (String word : wordDict){

        // Calculate the start of our substring
        int start = i - word.length();

        // If start not out of bounds, and the prev word can be segmented, and our substring matches in the word
        if (start >= 0 && dp[start] && s.substring(start, i).equals(word)){
          dp[i] = true;
          break;
        }
      }
    }

    return dp[s.length()];

  }
}
