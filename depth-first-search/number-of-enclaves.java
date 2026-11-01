class Solution {

    int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

    public int numEnclaves(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        for(int i = 0; i < m; i++){

            if(grid[i][0] == 1)
                dfs(grid,i,0);

            if(grid[i][n-1] == 1)
                dfs(grid,i,n-1);
        }

        for(int j = 0; j < n; j++){

            if(grid[0][j] == 1)
                dfs(grid,0,j);

            if(grid[m-1][j] == 1)
                dfs(grid,m-1,j);
        }

        int count = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){

                if(grid[i][j] == 1)
                    count++;
            }
        }

        return count;
    }

    private void dfs(int[][] grid,int r,int c){

        int m = grid.length;
        int n = grid[0].length;

        if(r<0 || c<0 || r>=m || c>=n || grid[r][c]==0)
            return;

        grid[r][c] = 0;

        for(int[] d : dir){
            dfs(grid,r+d[0],c+d[1]);
        }
    }
}