class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(n == 0) return true;

        int[] parent = new int[n];
        Arrays.fill(parent, -1);
        for(int i = 0; i < edges.length; i++){
            int x = edges[i][0];
            int y = edges[i][1];

            if(parent[y] != -1) return false;

            parent[y] = x;
        }

        return true;
    }
}
