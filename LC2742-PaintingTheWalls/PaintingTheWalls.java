class Solution {

  // This problem was SUPER hard to understand
  // Definitely need to work on my DP skills
  // O(n^2) solution
  public int paintWalls(int[] cost, int[] time) {
    // Tracking min cost to paint up to j walls
    int[] dp = new int[cost.length + 1];
    Arrays.fill(dp, 250000000);

    // Set our base case -> painting 0 walls costs zero$
    dp[0] = 0;


    // Iterating through each wall
    for (int i = 0; i < cost.length; i++){

      // Iterate through the walls we still have to paint (dp array)
      for (int j = cost.length; j > 0; j--){

        // The cost of painting is calculated as the minimum between
        // Our current cost (min cost of painting j walls), and the cost of painting the ith wall plus the minimum cost of painting up to j - time[i] - 1 walls
        dp[j] = Math.min(dp[j], dp[Math.max(j - time[i] - 1, 0)] + cost[i]);
      }

    }

    return dp[cost.length];
  }
}
