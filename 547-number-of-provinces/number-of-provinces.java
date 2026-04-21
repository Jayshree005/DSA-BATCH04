class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int provinces = 0;

        for (int i = 0; i < n; i++) {
            // Agar city visited nahi hai, matlab naya group (province) mila
            if (!visited[i]) {
                provinces++;
                // DFS se us city ke saare padosiyon ko mark karo
                dfs(i, isConnected, visited);
            }
        }
        return provinces;
    }

    private void dfs(int node, int[][] isConnected, boolean[] visited) {
        visited[node] = true;

        // Adjacency Matrix ki poori row scan karni padti hai neighbors ke liye
        for (int neighbor = 0; neighbor < isConnected.length; neighbor++) {
            // Agar rasta hai (==1) aur neighbor visited nahi hai
            if (isConnected[node][neighbor] == 1 && !visited[neighbor]) {
                dfs(neighbor, isConnected, visited);
            }
        }
    }
}