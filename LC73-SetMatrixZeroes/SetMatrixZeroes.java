class Solution {
    // O(N^2) Solution using O(N) space
    public void setZeroes(int[][] matrix) {
        // Initialize list that will hold rows and cols of our zeroes
        List<int[]> coords = new ArrayList<>();

        int rows = matrix.length;
        int cols = matrix[0].length;

        // Find all of our zeroes in the matrix
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                // If we find a zero, save its row and col
                if (matrix[i][j] == 0){
                    coords.add(new int[]{i, j});
                }
            }
        }

        // Loop through all of our saved values and set them = 0
        for (int i = 0; i < coords.size(); i++){
            int row = coords.get(i)[0];
            int col = coords.get(i)[1];

            for (int j = 0; j < rows; j++){
                matrix[j][col] = 0;
            }
            for (int j = 0; j < cols; j++){
                matrix[row][j] = 0;
            }
        }


    }
}
