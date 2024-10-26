/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
  public int widthOfBinaryTree(TreeNode root) {
    if (root == null) return 0;
    // Create our queue for BFS using a pair
    // The pair will hold the node and its position.
    Queue<Pair<TreeNode, Integer>> que = new LinkedList<>();
    // Add the root at position 0.
    que.add(new Pair<>(root, 0));
    int max = 0;

    // width = posLast - posFirst + 1
    while (!que.isEmpty()){
      int size = que.size();
      // Create a temp width and a temp array for storing our positions for the current level
      int tempWidth = 0;
      int[] temp = new int[size];
      for (int i = 0; i < size; i++){
        Pair<TreeNode, Integer> curr = que.poll();
        TreeNode parent = curr.getKey();

        // Store the positions into the array so we can calculate our width
        if (parent != null){
          temp[i] = curr.getValue();
        }
        // Calculating the position of the left and right child
        // Left: (2 * parent_position) + 1
        // Right: (2 * parent_position) + 2
        if (parent.left != null){
          que.add(new Pair<>(parent.left, (curr.getValue() * 2) + 1));
        }
        if (parent.right != null){
          que.add(new Pair<>(parent.right, (curr.getValue() * 2) + 2));
        }
      }
      // calculate our temporary width and compare it to current max
      tempWidth = (temp[size - 1] - temp[0]) + 1;

      max = Math.max(max, tempWidth);
    }



    return max;
  }
}
