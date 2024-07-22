import java.util.*;
class DFSOfGraph{
    public static ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj){
        boolean[] visited = new boolean[V + 1];
        visited[0] = true;
        ArrayList<Integer> dfs = new ArrayList<>();
        dfs(0, visited, adj, dfs);

        return dfs;
    }
    public static void dfs(int node, boolean[] visited, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> dfs){
        visited[node] = true;
        dfs.add(node);

        for(Integer it : adj.get(node)){
            if(visited[it] == false){
                dfs(it, visited, adj, dfs);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int i = 0; i < E; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
        }
        ArrayList<Integer> res = dfsOfGraph(V, adj);
        for(int i : res){
            System.out.println(i + " ");
        }
    }
}