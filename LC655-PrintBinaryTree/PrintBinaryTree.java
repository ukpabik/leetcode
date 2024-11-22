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
    public List<List<String>> printTree(TreeNode root) {
        if (root == null){
            return new ArrayList<>();
        }
        
        // Calculate dimensions of tree
        int treeHeight = calcHeight(root);
        int m = treeHeight + 1;
        int n = (int)Math.pow(2, treeHeight + 1) - 1;

        String[][] tree = new String[m][n];
        List<List<String>> res = new ArrayList<>();

        // fill our tree with empty strings
        for (String[] row : tree){
            Arrays.fill(row, "");
        }



        // Initialize our queue, we are saving the row and col of our parent as an int[]
        Queue<Pair<TreeNode, int[]>> q = new LinkedList<>();

        // Add our root with the given root row and column
        q.add(new Pair<>(root, new int[]{0, (n - 1) / 2}));

        while (!q.isEmpty()){
            int size = q.size();

            for (int i = 0; i < size; i++){
                // Get our values we need to calculate the child position
                Pair<TreeNode, int[]> curr = q.poll();
                TreeNode node = curr.getKey();
                int[] parent = curr.getValue();
                int row = parent[0];
                int col = parent[1];

                // Adding the current node to our tree
                tree[row][col] = String.valueOf(node.val);
                

                // Check both left and right children to see if they are included in the tree
                if (node.left != null){

                    // Add the left node with its calculated row and column based off of the parent
                    q.add(new Pair<>(node.left, new int[]{row + 1, col - (int)Math.pow(2, treeHeight - row - 1)}));
                }
                if (node.right != null){
                    // Add the right node with its calculated row and column based off of the parent
                    q.add(new Pair<>(node.right, new int[]{row + 1, col + (int)Math.pow(2, treeHeight - row - 1)}));
                }
            }
        }

        // Add our tree to our resulting list
        for (int i = 0; i < tree.length; i++){
            List<String> temp = new ArrayList<>();
            for (int j = 0; j < tree[i].length; j++){
                temp.add(tree[i][j]);
            }
            res.add(temp);
        }

        return res;
    }

    // Helper function to calculate the height of the binary tree
    public int calcHeight(TreeNode root) {
        if (root == null) {
            return -1; 
        }
        return 1 + Math.max(calcHeight(root.left), calcHeight(root.right));
    }
}
