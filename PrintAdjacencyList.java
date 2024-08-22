import java.util.*;
class PrintAdjacencyList{
    public static List<List<Integer>> adjacencyList(int V, int[][] edges){
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
            adj.get(v).get(u);
        }
        return adj;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        int[][] edges = new int[E][2];
        for(int i = 0; i < E; i++){
            for(int j = 0; j < 2; j++){
                edges[i][j] = sc.nextInt();
            }
        }
        List<List<Integer>> res = adjacencyList(V, edges);
        for(int i = 0; i < res.size(); i++){
            System.out.print(i + ": ");
            for(int j : res.get(i)){
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}