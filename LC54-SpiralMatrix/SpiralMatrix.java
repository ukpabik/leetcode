import java.util.ArrayList;
import java.util.List;

class Solution {

    // O(N^2) Solution
    public List<Integer> spiralOrder(int[][] matrix) {
        

        // SOLVED SOLUTION
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }

        // Keep track of all of our boundaries
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while (top <= bottom && left <= right){

            // Go from left to right first
            for (int i = left; i <= right; i++){
                res.add(matrix[top][i]);
            }
            top++;

            // Go from top to bottom next
            for (int j = top; j <= bottom; j++){
                res.add(matrix[j][right]);
            }
            right--;


            // If our top is less than our bottom, meaning we can traverse again going left
            if (top <= bottom) {
                for (int col = right; col >= left; col--) {
                    res.add(matrix[bottom][col]);
                }
                bottom--;
            }
            
            // If our left is less than our right, meaning we can traverse again going bottom up
            if (left <= right) {
                for (int row = bottom; row >= top; row--) {
                    res.add(matrix[row][left]);
                }
                left++;
            }
        }

        return res;

        





        // FIRST ATTEMPT

        // Establish our sign for changing direction, and our decrement to determine how much to move
        // int sign = 1;
        // int decrement = 0;
        // List<Integer> res = new ArrayList<>();

        // int row = 0;
        // int col = 0;

        // while (decrement < matrix.length){
        //     if (sign > 0){
        //         while (col < matrix[0].length - decrement - 1){
        //             res.add(matrix[row][col]);
        //             col++;
        //         }
        //         while (row < matrix.length - decrement - 1){
        //             res.add(matrix[row][col]);
        //             row++;
        //         }
        //         decrement++;
        //     }
        //     else if (sign < 0){
        //         while (col >= decrement){
        //             res.add(matrix[row][col]);
        //             col--;
        //         }
        //         while (row > decrement){
        //             res.add(matrix[row][col]);
        //             row--;
        //         }
        //         decrement++;
        //     }
        //     sign = -sign;
        // }

        // System.out.println(res);
        // return res;
        
    }
}
