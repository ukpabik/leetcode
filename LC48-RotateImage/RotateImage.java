class Solution {
  public void rotate(int[][] matrix) {
    int rows = matrix.length, cols = matrix[0].length;

    // First you want to transpose the matrix, turning the rows
    // into cols, and the cols into rows.
    for (int i = 0; i < rows; i++){
      // Starting at i + 1 is very important, don't forget that
      for (int j = i + 1; j < cols; j++){
        // Swap i,j with j,i
        int temp = matrix[j][i];
        matrix[j][i] = matrix[i][j];
        matrix[i][j] = temp;
      }
    }
    
    // Next, we want to reverse the rows to complete the rotation.
    // Only go over half of the row, because if we go through the entire row,
    // we will negate our reversion and put the row back to normal.
    for (int i = 0; i < rows; i++){
      // COLS / 2 IS VERY IMPORTANT
      for (int j = 0; j < cols / 2; j++){
        int temp = matrix[i][cols - j - 1];
        matrix[i][cols - j - 1] = matrix[i][j];
        matrix[i][j] = temp;
      }
    }

  }
}
