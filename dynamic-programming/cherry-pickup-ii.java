class Solution {

    public int cherryPickup(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        int[][] dp = new int[m][m];

        for (int col1 = 0; col1 < m; col1++) {

            for (int col2 = 0; col2 < m; col2++) {

                if (col1 == col2) 
                    dp[col1][col2] = grid[n - 1][col1];
                else 
                    dp[col1][col2] =grid[n - 1][col1]+ grid[n - 1][col2];
                
            }
        }

        for (int row = n - 2; row >= 0; row--) {

            int[][] current = new int[m][m];

            for (int col1 = 0; col1 < m; col1++) {

                for (int col2 = 0; col2 < m; col2++) {

                    int chocolates;

                    if (col1 == col2) 
                        chocolates = grid[row][col1];
                    else 
                        chocolates =grid[row][col1]+ grid[row][col2];

                    int max = 0;

                    for (int d1 = -1; d1 <= 1; d1++) {

                        for (int d2 = -1; d2 <= 1; d2++) {

                            int nextcol1 = col1 + d1;
                            int nextcol2 = col2 + d2;

                            if (nextcol1 >= 0 && nextcol1 < m && nextcol2 >= 0 && nextcol2 < m) 
                                max = Math.max( max, dp[nextcol1][nextcol2]);
                            
                        }
                    }

                    current[col1][col2] =chocolates + max;
                }
            }
            dp = current;
        }
        return dp[0][m - 1];
    }
}