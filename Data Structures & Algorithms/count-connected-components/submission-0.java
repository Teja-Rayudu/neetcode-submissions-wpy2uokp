class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> edgesList = new ArrayList<>(n);

        for(int i = 0; i < n; i++){
            edgesList.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            edgesList.get(edge[0]).add(edge[1]);
            edgesList.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        int count = 0;

        for(int i = 0; i < n; i++){
            if(!visited[i]){
                count++;
                dfs(i, edgesList, visited);
            }
        }
        return count;
    }

    private void dfs(int node, List<List<Integer>> edges, boolean[] visited){

        visited[node] = true;

        for(int i : edges.get(node)){
            if(!visited[i]){
                dfs(i, edges, visited);
            }
        }
    }
}
