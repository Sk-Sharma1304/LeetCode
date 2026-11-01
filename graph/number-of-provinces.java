class Solution {

    public int findCircleNum(int[][] isConnected) {

        int n = isConnected.length;

        boolean[] visited = new boolean[n];

        int provinces = 0;

        // Traverse all cities
        for (int i = 0; i < n; i++) {

            // If city not visited,
            // start DFS
            if (!visited[i]) {

                dfs(isConnected, visited, i);

                provinces++;
            }
        }

        return provinces;
    }

    // DFS function
    private void dfs(int[][] isConnected,boolean[] visited,int city) {

        visited[city] = true;

        // Visit all connected neighbors
        for (int neighbour = 0;
             neighbour < isConnected.length;
             neighbour++) {

            if (isConnected[city][neighbour] == 1
                    && !visited[neighbour]) {

                dfs(isConnected, visited, neighbour);
            }
        }
    }
}