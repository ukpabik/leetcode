class Solution {

  // O(N^2) brute force approach using cycle detection
  public int[] findRedundantConnection(int[][] edges) {
    int n = edges.length;

    // Check all edges, starting from the last because of this statement in the problem:
    // "If there are multiple answers, return the answer that occurs last in the input."
    for (int i = n - 1; i >= 0; i--){
      if (isTree(edges, i, n)){
        return edges[i];
      }
    }

    return new int[0];

  }


  public boolean isTree(int[][] edges, int skip, int n){
    // Create our adjacency list
    List<List<Integer>> adj = new ArrayList<>();

    for (int i = 0; i <= n; i++){
      adj.add(new ArrayList<>());
    }

    for (int i = 0; i < edges.length; i++){
      // The node that we are removing should be ignored
      if (i == skip) continue;
      int[] edge = edges[i];

      adj.get(edge[0]).add(edge[1]);
      adj.get(edge[1]).add(edge[0]);
    }

    // Check if there is still a cycle, if there is, that was the wrong node to remove
    boolean[] visited = new boolean[n + 1];
    if (hasCycle(adj, visited, 1, -1)){
      return false;
    }

    // Check if nodes in the list are still not visited, this indicates there is a cycle occurring
    for (int i = 1; i <= n; i++){
      if (!visited[i]){
        return false;
      }
    }

    return true;
  }


  // DFS helper function to determine cycle
  public boolean hasCycle(List<List<Integer>> adj, boolean[] visited, int node, int parent){
    visited[node] = true;

    for (int neighbor : adj.get(node)){
      if (!visited[neighbor]){
        // Recursively check all neighbors of current node
        if (hasCycle(adj, visited, neighbor, node)){
          return true;
        }
      }
      // If neighbor = parent, there is a cycle
      else if (neighbor != parent){
        return true;
      }
    }

    return false;
  }
}
