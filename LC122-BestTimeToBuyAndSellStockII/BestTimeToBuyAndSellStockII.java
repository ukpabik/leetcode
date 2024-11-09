class Solution {
  // O(N) FAST GREEDY SOLUTION
    public int maxProfit(int[] prices) {
        int prof = 0;

        for (int i = 0; i < prices.length - 1; i++){
            // If we can make profit, add it to our result
            if (prices[i + 1] - prices[i] > 0){
                prof += prices[i + 1] - prices[i];
            }
        }

        // If we are unable to make profit, return 0
        return prof;
    }
}
