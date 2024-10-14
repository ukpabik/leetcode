package leetcode;


public class Solution {
  public int coinChange(int[] coins, int amount){
    // Initialize dp array and fill it with a large placeholder
    int[] dp = new int[amount + 1];
    Arrays.fill(dp, amount + 1);

    // Set the first val of the array to 0, because there are 0 ways to get the value 0 with the given coins
    dp[0] = 0;


    // Loop through the dp array, solving the subproblems as we go through
    // Start at the second value because the first value is always 0
    for (int i = 1; i < dp.length; i++){

      // i is equal to the current amount we are trying to solve
      // ex) i = 1 means that amount = 1, we are trying to see if we can make 1 with whatever coins we have
      for (int coin : coins){

        // If we are able to make the amount, then i - coin will be greater than or equal to 0
        if (i - coin >= 0){


          // This is where we calculate the min amount of coins to make the target amount
          // The amount of ways to make the ith amount is equal to the min of the
          // previous subproblem + 1 way, or the current placeholder amount
          dp[i] = Math.min(1 + dp[i - coin], dp[i]);
        }
      }
    }


    // If the amount at dp[amount] is less than or equal to the amount
    // this means that we can get that amount of change with the coins given
    //
    // If we cannot make it, then the value at dp[amount] will be = to the placeholder,
    // which is greater than amount, thus returning -1.
    return dp[amount] <= amount ? dp[amount] : -1;
  }
}
