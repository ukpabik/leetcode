class Solution {

    // Simple O(N^2) solution, finding connected components
    public int findCircleNum(int[][] isConnected) {
        
        // Initialize our boolean array and our counter for connected components
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int connected = 0;


        // Loop through all nodes, and call dfs on the ones that aren't visited
        // Increment our counter each time we find a new connected component
        for (int i = 0; i < n; i++){
            if (!visited[i]){
                connected++;
                dfs(isConnected, i, visited);
            }
        }  


        return connected;
    }


    public void dfs(int[][] isConnected, int node, boolean[] visited){
        if (visited[node]){
            return;
        }

        visited[node] = true;

        // Only visit a node if it is unvisited and the parent node is connected to it
        for (int i = 0; i < isConnected.length; i++){
            if (!visited[i] && isConnected[node][i] == 1){
                dfs(isConnected, i, visited);
            }
        }
    }
}
