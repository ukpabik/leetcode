import java.util.*;

class Solution {

    // O(N^2) Graph solution
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        // Create our set to hold all of our keys we have, and add 0 as our first room to visit
        boolean[] visited = new boolean[n];
        Set<Integer> keys = new HashSet<>();
        keys.add(0);

        // Loop through all values from 0 -> n - 1, and dfs through them if not visited and if we have the key
        for (int i = 0; i < n; i++){
            if (!visited[i] && keys.contains(i)){
                dfs(rooms, i, keys, visited);
            }
        }   
        

        // If we don't have every room key, we didn't visit every room
        if (keys.size() != n){
            return false;
        }


        return true;
    }

    public void dfs(List<List<Integer>> rooms, int node, Set<Integer> keys, boolean[] visited){
        // Check if our node is visited, or we don't have the key
        if (visited[node] || !keys.contains(node)){
            return;
        }

        visited[node] = true;

        // Add our new keys to our set
        List<Integer> currKeys = rooms.get(node);
        for (int n : currKeys){
            keys.add(n);
        }   
        // DFS through each key we just got
        for (int key : currKeys){
            dfs(rooms, key, keys, visited);
        }

    }
}
