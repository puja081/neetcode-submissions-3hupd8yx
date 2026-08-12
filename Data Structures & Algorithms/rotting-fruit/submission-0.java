class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols= grid[0].length;
        Queue<int[]> q = new ArrayDeque<>();
        int fresh = 0;
        int time = 0;
        for(int r = 0 ; r < rows ; r++){
            for(int c = 0; c < cols ; c++) {
                if(grid[r][c] == 1){
                    fresh++;
                }
                if(grid[r][c] == 2) {
                    q.offer(new int[]{r,c});
                }
            }
        }
        int[][] directions = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
        while(fresh > 0 && !q.isEmpty()){
            int length = q.size();
            for(int i = 0 ; i < length ; i++){
                int[] curr = q.poll();
                int row = curr[0] , col = curr[1];
                for(int[] dir : directions){
                    int nr = row + dir[0], nc = col + dir[1];
                    if(nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == 1){
                        grid[nr][nc] = 2;
                        q.offer(new int[]{nr, nc});
                        fresh--;
                    }
                }
            }
            time++;
        }
        return fresh == 0 ? time : -1;
        
    }
}
