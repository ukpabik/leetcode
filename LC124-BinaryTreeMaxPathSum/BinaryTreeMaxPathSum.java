class Solution {

  // Recursive Solution O(N)
  
  // Initialize our global max variable
  int max = Integer.MIN_VALUE;
  public int maxPathSum(TreeNode root) {
    // Call dfs on the root and return the global max, updated after the dfs calls.
    dfs(root);
    return max;

  }


  // DFS helper function
  public int dfs(TreeNode node){

    // Base case
    if (node == null) return 0;

    // Get the values of the left and right paths.
    int left = dfs(node.left);
    int right = dfs(node.right);

    // If they are negative, we want to skip them.
    if (left < 0) left = 0;
    if (right < 0) right = 0;


    // Our current max will be the current node + left and right path values.
    int currMax = node.val + left + right;

    // Compare this to our global max, and set it to the current max 
    // if our current is larger.
    max = Math.max(currMax, max);

    // Return the current node + the max of the left and right paths.
    return node.val + Math.max(left, right);

  } 
}
