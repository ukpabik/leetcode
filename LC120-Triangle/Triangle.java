class Solution {
    // O(N^2) Solution
    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        int[][] dp = new int[size][triangle.get(size - 1).size()];

        // Fill our base case
        for (int i = 0; i < triangle.get(size - 1).size(); i++) {
            dp[size - 1][i] = triangle.get(size - 1).get(i);
        }
        
        // Bottom up solution 
        for (int currRow = size - 2; currRow >= 0; currRow--){
            // Get our current row
            List<Integer> current = triangle.get(currRow);
            for (int j = 0; j < current.size(); j++) {
                // We need to check both decisions, either i or i + 1 on the previous row
                dp[currRow][j] = Math.min(dp[currRow + 1][j], dp[currRow + 1][j + 1]) + current.get(j);
            }
        }
        // Used for printing the dp matrix

        // for (int i = 0; i < dp.length; i++){
        //     for (int j = 0; j < dp[i].length; j++){
        //         System.out.print(dp[i][j] + " ");
        //     }
        //     System.out.println();
        // }


        return dp[0][0];


    }
}
