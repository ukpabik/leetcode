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

    // O(N) solution
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        // Base case
        if (root == null){
            return new ArrayList<>();
        }

        // Initialize our result list and our queue for BFS
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<>();

        que.add(root);

        // Run through bfs, making a temp list to store each level's values
        while (!que.isEmpty()){
            int size = que.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < size; i++){
                TreeNode curr = que.poll();
                if (curr != null){
                    temp.add(curr.val);
                }

                if (curr.left != null){
                    que.add(curr.left);
                }
                if (curr.right != null){
                    que.add(curr.right);
                }
            }
            res.add(temp);
        }

        // Reverse the list to have the values in bottom up order
        Collections.reverse(res);

        return res;
    }
}
