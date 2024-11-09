import java.util.Arrays;
class Solution {
    // Good O(N) solution
    public int candy(int[] ratings) {
        int n = ratings.length;
        // Initialize children array and fill with ones
        int[] children = new int[n];
        Arrays.fill(children, 1);
        // If our first child has a higher rating than second, we can set our initial base case
        

        // First pass: Left to right
        for (int i = 1; i < n; i++){
            // Check to see if the current child has a higher rating than its left neighbor
            // If it does, increase the candy for the current child
            int left = ratings[i - 1];
            int curr = ratings[i];

            if (curr > left){
                children[i] = 1 + children[i - 1];
            }
        }

        // Second pass: right to left
        for (int i = n - 2; i >= 0; i--){
            // Check to see if the current child has a higher rating than its right neighbor
            // If it does, set the current child's candy to the max of its current candy and 1 + the right child's candy
            int right = ratings[i + 1];
            int curr = ratings[i];

            if (curr > right){
                children[i] = Math.max(children[i], 1 + children[i + 1]);
            }
        }

        

        // Get the sum of all candies distributed
        int res = 0;
        for (int s : children){
            res += s;
        }

        return res;
    }
}
