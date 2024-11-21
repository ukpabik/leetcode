class Solution {


    // O(M * N) solution
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
       // At each guard, we need to search in each direction until we hit a wall
       // Once we hit a wall, we stop.


       // 1 == guard
       // 2 == wall
       // 3 == guarded
        int[][] grid = new int[m][n];

        // Fill our grid with guards
        for (int[] guard : guards){
            grid[guard[0]][guard[1]] = 1;
        }

        
        // Fill our grid with walls
        for (int[] wall : walls){
            grid[wall[0]][wall[1]] = 2;
        }



        // DFS on all of our guards to make sure we mark all guarded cells
        for (int[] guard : guards){
            markGuarded(grid, guard[0], guard[1], m, n);
        }


        // Go through our grid and find all unguarded cells
        int unguarded = 0;
        for (int[] row : grid){
            for (int node : row){
                if (node == 0){
                    unguarded++;
                }
            }
        }
        return unguarded;

        
    }
    
    // Helper function to find/mark guarded cells
    public void markGuarded(int[][] grid, int row, int col, int m, int n){
        // up
        // down

        for (int r = row + 1; r < m; r++){
            if (grid[r][col] == 2 || grid[r][col] == 1) break;
            grid[r][col] = 3;
        }

        for (int r = row - 1; r >= 0; r--){
            if (grid[r][col] == 2 || grid[r][col] == 1) break;
            grid[r][col] = 3;
        }

        // left
        // right

        for (int c = col + 1; c < n; c++){
            if (grid[row][c] == 2 || grid[row][c] == 1) break;
            grid[row][c] = 3;
        }

        for (int c = col - 1; c >= 0; c--){
            if (grid[row][c] == 2 || grid[row][c] == 1) break;
            grid[row][c] = 3;
        }
    }

}
