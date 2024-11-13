import java.util.Arrays;

class Solution {

    // O(N^2) solution -> Watched Neetcode Solution
    public int minDistance(String word1, String word2) {
        /**
        
            word1
            word2

            Find min number of operations to:
                Convert word1 to word2

            Three operations:
                Insert a character
                Delete a character
                Replace a character

            Example:

                1) "horse"
                2) "ros"
        
        */

        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        // Filling with max value
        for (int i = 0; i < dp.length; i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        // Base case: If one string is empty, fill with length of other word -> that is the min amount of operations
        // Fill the last row
        for (int i = 0; i <= word2.length(); i++){
            dp[word1.length()][i] = word2.length() - i;
        }
        // Fill the last column
        for (int i = 0; i <= word1.length(); i++){
            dp[i][word2.length()] = word1.length() - i;
        }

        // Go through our bottom up solution
        for (int i = word1.length() - 1; i >= 0; i--){
            for (int j = word2.length() - 1; j >= 0; j--){
                // If the characters are the same, just increment diagonally (i + 1, j + 1)
                if (word1.charAt(i) == word2.charAt(j)){
                    dp[i][j] = dp[i + 1][j + 1];
                }
                else {
                    // If they aren't equal, we need to get the minimum from either replacing, inserting, or deleting
                    // and add 1 to it as we are doing 1 operation
                    dp[i][j] = 1 + Math.min(dp[i + 1][j], Math.min(dp[i + 1][j + 1], dp[i][j + 1]));
                }
            }
        }
        
        // Testing
        // for (int i = 0; i < dp.length; i++){
        //     for (int j = 0; j < dp[0].length; j++){
        //         System.out.print(dp[i][j] + " ");
        //     }
        //     System.out.println();
        // }


        // Return the first value
        return dp[0][0];
    }
}
