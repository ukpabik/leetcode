import java.util.Arrays;

class Solution {

  
    int[][] directions = {
        {0, 1},  // right
        {1, 0},  // down
        {0, -1}, // left
        {-1, 0}  // up
    };


    // O(M * N) solution using dfs and dp
    public int longestIncreasingPath(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];

        // Fill our base case of -1s
        for (int[] col : dp){
            Arrays.fill(col, -1);
        }

        // Perform dfs and get the largest value
        int longest = 0;
        for (int i = 0; i < dp.length; i++){
            for (int j = 0; j < dp[0].length; j++){
                longest = Math.max(longest, dfs(matrix, dp, i, j, Integer.MIN_VALUE));
            }
        }
        
        return longest;


    }

    public int dfs(int[][] matrix, int[][] dp, int row, int col, int prev){
        // Check our base cases: Out of bounds, or curr val is less than or equal to prev
        if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length || matrix[row][col] <= prev){
            return 0;
        }

        // If we've already met our subproblem, just return it
        if (dp[row][col] != -1){
            return dp[row][col];
        }
        
        // Get the current max length from this position
        int maxLength = 0;
        for (int[] dir : directions){
            maxLength = Math.max(maxLength, dfs(matrix, dp, row + dir[0], col + dir[1], matrix[row][col]));
        }

        // Add one to the max length and store it
        dp[row][col] = 1 + maxLength;
        return dp[row][col];
    }
}
