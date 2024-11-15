import java.util.*;

class Solution {

    // O(N * M) solution using DFS and multisource BFS
    public int shortestBridge(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        boolean[][] visited = new boolean[n][m];

        // Queue for saving our visited nodes in first island
        Queue<int[]> que = new LinkedList<>();

        boolean first = false;
        // Find and visit our first island
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (!visited[i][j] && !first && grid[i][j] == 1){
                    dfs(grid, visited, i, j, que);
                    first = true;
                }
            }
        }


        // Multisource bfs
        int distance = 0;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        while (!que.isEmpty()){
            int size = que.size();

            // Go through every node, and get the new node to visit
            for (int i = 0; i < size; i++){
                int[] node = que.poll();

                // Visit in every direction, and check if it is part of the new island
                for (int[] dir : directions){
                    int x = node[0] + dir[0];
                    int y = node[1] + dir[1];   

                    if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && !visited[x][y]){
                        // If it is a 1 and unvisited, this means it is part of the new island
                        if (grid[x][y] == 1){
                            return distance;
                        }

                        // If it is not part of the new island, we can add this new node to our queue
                        visited[x][y] = true;
                        que.add(new int[]{x, y});
                    }
                }
            }

            // Don't forget to increment distance
            distance++;
        }

        return -1;
    }

    // DFS helper function
    public void dfs(int[][] grid, boolean[][] visited, int x, int y, Queue<int[]> q){
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length){
            return;
        }
        if (visited[x][y] || grid[x][y] == 0){
            return;
        }

        visited[x][y] = true;
        q.add(new int[]{x, y});

        dfs(grid, visited, x + 1, y, q);
        dfs(grid, visited, x - 1, y, q);
        dfs(grid, visited, x, y + 1, q);
        dfs(grid, visited, x, y - 1, q);

    }
}
