class Solution {

    // O(N * M) Solution
    public int minDeletionSize(String[] strs) {
        int sum = 0;
        int idx = 0;

        // Loop through the columns
        while (idx < strs[0].length()){

            // Get the previous char to compare it to the next char in the column
            char prev = strs[0].charAt(idx);
            for (int i = 1; i < strs.length; i++){
                char curr = strs[i].charAt(idx);

                // If it isn't lexicographically sorted, add 1 to sum and break to go to next column
                if (strs[i].charAt(idx) - prev < 0){
                    sum++;
                    break;
                }

                // Update prev
                prev = curr;
            }
            idx++;
        }
        
        // Return the amount of columns we are eliminating
        return sum;
    }
}
