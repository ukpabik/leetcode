class Solution {

    // O(N) DP solution
    public int numDecodings(String s) {
        // Create our encodings for all valid values
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }

        // Initialize dp and our base case
        int[] dp = new int[s.length() + 1];

        // Empty string has one way to decode
        dp[0] = 1;
        // If first char is not 0, dp[1] is valid, else its not valid
        dp[1] = s.charAt(0) != '0' ? 1 : 0;


        // Go through every other 1 and 2 digit number, checking if they are valid
        for (int i = 2; i <= s.length(); i++){
            if (s.charAt(i - 1) != '0'){
                dp[i] += dp[i - 1];
            }


            // Checking our 2 digit number to see if it is within our range
            String sub = s.substring(i - 2, i);
            if (Integer.parseInt(sub) >= 10 && Integer.parseInt(sub) <= 26){
                dp[i] += dp[i - 2];
            }
        }

        return dp[s.length()];
    }
}
