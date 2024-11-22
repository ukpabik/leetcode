class Solution {
    
  // O(N * M) solution
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        // Base number = 1, always 1 row that is equal to itself
        int max = 1;

        Map<String, Integer> patternFreq = new HashMap<>();

        // Loop through every row and get the pattern for that row
        for (int[] row : matrix){
            StringBuilder sb = new StringBuilder("");
            sb.append("*");
            for (int i = 1; i < row.length; i++){
                if (row[i] != row[i - 1]){
                    // If we switch values, add a breaker in between
                    sb.append("|");
                }
                sb.append("*");
            }

            // Put our current pattern into our map
            patternFreq.put(sb.toString(), patternFreq.getOrDefault(sb.toString(), 0) + 1);
        }


        // Get our max frequency from our pattern map
        for (int val : patternFreq.values()){
            if (val > max){
                max = Math.max(max, val);
            }
        }

        return max;
    }
}
