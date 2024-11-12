class Solution {

    // O(N^2) solution
    public int uniquePaths(int m, int n) {

        // Initialize our dp array
        int[][] dp = new int[m][n]; 
        
        // Fill our base case, the entire first row will only have 1 unique path, going right only ->
        for (int i = 0; i < n; i++){
            dp[0][i] = 1;
        }

        // Making our choices in this loop
        for (int i = 1; i < m; i++){
            for (int j = 0; j < n; j++){
                // Always include the value above it
                dp[i][j] = dp[i - 1][j];
                if (j > 0){
                    // If we can include the value to the left, add it to the current dp[i][j] value
                    dp[i][j] += dp[i][j - 1];
                }    
            }
        }


        // Testing
        // for (int i = 0; i < m; i++){
        //     for (int j = 0; j < n; j++){
        //         System.out.print(dp[i][j] + " ");
        //     }
        //     System.out.println();
        // }


        // The final spot in the array will print the number of unique paths
        return dp[m - 1][n - 1];
    }
}
