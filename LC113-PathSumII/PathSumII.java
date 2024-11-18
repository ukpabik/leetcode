class Solution {


    // Backtracking solution
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        // some sort of backtracking

        // Create our result list and start backtracking
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, res, new ArrayList<>(), 0, targetSum);

        return res;
    }


    public void dfs(TreeNode node, List<List<Integer>> res, List<Integer> temp, int currSum, int targetSum){
        // If our node is null, don't consider it
        if (node == null){
            return;
        }

        // Add our current node to our sum and path list
        temp.add(node.val);
        currSum += node.val;

        // THIS IS AN IMPORTANT CHECK: Make sure the node we are currently on is a leaf, (root to leaf path) and that the sum = target
        if (currSum == targetSum && node.left == null && node.right == null){
            res.add(new ArrayList<>(temp));
        }
        else{
            // If it doesn't we want to check other directions for new paths
            dfs(node.left, res, temp, currSum, targetSum);
            dfs(node.right, res, temp, currSum, targetSum);
        }

        // End our backtracking by removing the node from path
        temp.remove(temp.size() - 1);
        currSum -= node.val;
    }
}
