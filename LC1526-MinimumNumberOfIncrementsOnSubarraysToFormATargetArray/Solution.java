class Solution {

    // O(N) solution
    public int minNumberOperations(int[] target) {
        int sum = target[0];

        // If the previous element is less than the current element, we need to increase our sum

        // This means that our "level" changes. The previous element is our current level, and if
        // the next element is greater, we need to add a new level
        for (int i = 1; i < target.length; i++){
            if (target[i] > target[i - 1]){
                sum += Math.max(0, target[i] - target[i - 1]);
            }
        }
        return sum;
    }
}
