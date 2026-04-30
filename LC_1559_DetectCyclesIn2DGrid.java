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

     private boolean bfs(char[][] grid, boolean[][] visited, int startX, int startY, int[][] directions) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startX, startY, -1, -1});
        visited[startX][startY] = true;
        
        char ch = grid[startX][startY];
        
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0], y = curr[1];
            int parentX = curr[2], parentY = curr[3];
            
            for (int[] dir : directions) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                
                if (nx >= 0 && ny >= 0 && nx < grid.length && ny < grid[0].length
                    && grid[nx][ny] == ch) {
                    
                    if (!visited[nx][ny]) {
                        queue.offer(new int[]{nx, ny, x, y});
                        visited[nx][ny] = true;
                    } 
                    else if (nx != parentX || ny != parentY) {
                        // 🔥 Cycle detected
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
}
