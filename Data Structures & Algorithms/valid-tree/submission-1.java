class Solution {

    class DSU{
        int[] parent, rank;
        int nodes;

        public DSU(int n){
            nodes = n;
            parent = new int[n + 1];
            rank = new int[n + 1];
            for(int i = 0; i <= n; i++){
                parent[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int node){
            if(parent[node] != node){
                return find(parent[node]);
            }

            return node;
        }

        public boolean union(int u, int v){
            int pu = find(u), pv = find(v);
            if(pu == pv) return false;
            if(rank[pu] < rank[pv]){
                int temp = pu;
                pu = pv;
                pv = temp;
            }
            nodes--;
            rank[pu] += rank[pv];
            parent[pv] = pu;
            return true;
        }

        public int components(){
            return nodes;
        }
    }


    
    public boolean validTree(int n, int[][] edges) {
        if(edges.length > n - 1) return false;
        DSU ds = new DSU(n);

        for(int[] edge : edges){
            if(!ds.union(edge[0], edge[1])) return false;
        }

        return ds.components() == 1;
    }
}
