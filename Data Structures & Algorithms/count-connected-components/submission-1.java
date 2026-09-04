class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        boolean[] visited = new boolean[n];
        for(int i = 0 ; i < n ; i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int res = 0;
        for(int i =0 ; i< n ; i++){
            if(!visited[i]){
                dfs(i, adj, visited);
                res++;
            }
        }
        return res;
    }

    public void dfs(int src, List<List<Integer>> adj, boolean[] visited){
        visited[src] = true;
        for(int neighbour : adj.get(src)){
            if(!visited[neighbour]){
                dfs(neighbour, adj, visited);
            }
        }
    }
}
