class Solution {


  // O(N^2) 2-D Dynamic Programming solution
  public int minPathSum(int[][] grid) {
    int rows = grid.length;
    int cols = grid[0].length;

    // Initialize our dp array and set our base case
    int[][] dp = new int[rows][cols];
    dp[0][0] = grid[0][0];

    // These two loops are also base cases, setting the values along the top and left side of the matrix
    for (int i = 1; i < rows; i++){
      dp[i][0] = dp[i - 1][0] + grid[i][0];
    }        
    for (int j = 1; j < cols; j++){
      dp[0][j] = dp[0][j - 1] + grid[0][j];
    }     


    // Loop through the grid starting from (1, 1) and the value at
    // [i][j] will be the minimum of the value above it and the value to the left, and then add the current grid value
    for (int i = 1; i < grid.length; i++){
      for (int j = 1; j < grid[0].length; j++){
        dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
      }
    }

    return dp[rows-1][cols-1];
  }

}
