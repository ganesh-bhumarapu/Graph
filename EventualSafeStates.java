import java.util.*;
class EventualSafeStates{
    public static boolean dfs(int node, List<List<Integer>> adj, int[] vis, int[] pathVis, int[] check){
        vis[node] = 1;
        pathVis[node] = 1;
        check[node] = 0;

        for(int it : adj.get(node)){
            if(vis[it] == 0){
                if(dfs(it, adj, vis, pathVis, check) == true){
                    return true;
                }
            }
            if(pathVis[it] == 1){
                return true;
            }
        }
        pathVis[node] = 0;
        check[node] = 1;
        return false;
    }
    public static List<Integer> safeStates(int V, List<List<Integer>> adj){
        int[] vis = new int[V];
        int[] pathVis = new int[V];
        int[] check = new int[V];

        for(int i = 0; i < V; i++){
            if(vis[i] == 0){
                dfs(i, adj, vis, pathVis, check);
            }
        }
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < V; i++){
            if(check[i] == 1){
                ans.add(i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < V; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        List<Integer> res = safeStates(V, adj);
        for(int i = 0; i < V; i++){
            System.out.print(res.add(i));
        }
    }
}