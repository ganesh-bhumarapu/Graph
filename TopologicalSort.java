import java.util.*;
class TopologicalSort{
    public static void dfs(int node, int[] vis, ArrayList<ArrayList<Integer>> adj, Stack<Integer> st){
        vis[node] = 1;
        for(int it : adj.get(node)){
            if(vis[it] == 0){
                dfs(it, vis, adj, st);
            }
        }
        st.push(node);
    }
    public static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj){
        int[] vis = new int[V];
        Stack<Integer> st = new Stack();
        for(int i = 0; i < V; i++){
            if(vis[i] == 0){
                dfs(i, vis, adj, st);
            }
        }
        int[] res = new int[V];
        int i = 0;
        while(!st.isEmpty()){
            res[i++] = st.peek();
            st.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<>>();
        for(int i = 0; i< V; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < V; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
        }
        int[] res = topoSort(V, adj);
        for(int i : res){
            System.out.print(i);
        }
    }
}
