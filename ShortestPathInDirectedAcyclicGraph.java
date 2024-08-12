import java.util.*;
class Pair{
    int first;
    int second;
    Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}
class ShortestPathInDirectedAcyclicGraph{
    public static int[] shortestPath(int N, int M, int[][] edges) {
        // form a graph
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            ArrayList<Pair> temp = new ArrayList<>();
            adj.add(temp);
        }
        for (int i = 0; i < M; i++) {
            int u = edges[i][0]; // getting 1st element
            int v = edges[i][1]; // getting 2nd element
            int wt = edges[i][2]; // getting 3rd element
            adj.get(u).add(new Pair(v, wt));
        }
        // get the topoSort order
        int[] vis = new int[N];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < N; i++) {
            if (vis[i] == 0) {
                topoSort(i, adj, vis, st);
            }
        }
        // calculate the distance from source to the nodes
        int[] dist = new int[N];
        for (int i = 0; i < N; i++) {
            dist[i] = (int) (1e9);
        }
        //self node have zero distance
        dist[0] = 0;
        while (!st.isEmpty()) {
            int node = st.peek();
            st.pop();
            if (dist[node] != (int) (1e9)) {
                for (int i = 0; i < adj.get(node).size(); i++) {
                    int v = adj.get(node).get(i).first;
                    int wt = adj.get(node).get(i).second;

                    if (dist[node] + wt < dist[v]) {
                        dist[v] = wt + dist[node];
                    }
                }
            }
        }
        for (int i = 0; i < N; i++) {
            if (dist[i] == (int) (1e9)) {
                dist[i] = -1;
            }
        }
        return dist;

    }
    public static void topoSort(int node, ArrayList<ArrayList<Pair>> adj, int[] vis, Stack<Integer> st){
        vis[node] = 1;
        for(int i = 0; i < adj.get(node).size(); i++){
            int v = adj.get(node).get(i).first;
            if(vis[v] == 0){
                topoSort(v, adj, vis, st);
            }
        }
        st.push(node);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] edges = new int[N][M];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                edges[i][j] = sc.nextInt();
            }
        }
        int[] res = shortestPath(N, M, edges);
        for(int i : res){
            System.out.print(i);
        }
    }
}