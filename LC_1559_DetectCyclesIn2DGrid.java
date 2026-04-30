class Solution {
    public boolean containsCycle(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        boolean[][] visited = new boolean[n][m];
        
        int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j]) {
                    if (bfs(grid, visited, i, j, directions)) {
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
