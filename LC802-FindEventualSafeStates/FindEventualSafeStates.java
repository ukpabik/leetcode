class Solution {
    
    // O(N^2) Graph solution, cycle detection
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> res = new ArrayList<>();
        int n = graph.length;

        // Create our map for holding safe values for nodes
        Map<Integer, Boolean> safe = new HashMap<>();

        // Recursively dfs through every node to determine if it is safe
        for (int i = 0; i < n; i++){
            // If safe, add to result
            if (dfs(graph, i, safe)){
                res.add(i);
            }
        }

        return res;
    }


    public boolean dfs(int[][] graph, int node, Map<Integer, Boolean> safe){
        // If we have already visited that node, just return its value
        if (safe.containsKey(node)){
            return safe.get(node);
        }

        // Initially put false, assuming that the node is not safe
        safe.put(node, false);

        // Loop through the neighbors, if the neighbors are safe, then the current node must also be safe
        for (int neighbor : graph[node]){
            if (!dfs(graph, neighbor, safe)){
                return false;
            }
        }

        // Change its value to true in the map and return true
        safe.put(node, true);
        return true;
    }
}
