import java.util.*;
class Pair{
    int first;
    int node;
    Pair(int first, int node){
        this.first = first;
        this.node = node;
    }
}
class DijkstraAlgorithm{
    public static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S){

        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) -> x.first - y.first);
        int[] dist = new int[V];
        for(int i = 0; i < V; i++){
            dist[i] = (int)(1e9);
        }
        dist[S] = 0;
        pq.add(new Pair(0, S));
        while(pq.size() != 0){
            int dis = pq.peek().first;
            int node = pq.peek().node;
            pq.remove();

            for(int i = 0; i < adj.get(node).size(); i++){
                int edgeWeight = adj.get(node).get(i).get(1);
                int adjNode = adj.get(node).get(i).get(0);

                if(dis + edgeWeight < dist[adjNode]){
                    dist[adjNode] = dis + edgeWeight;
                    pq.add(new Pair(dis + edgeWeight, adjNode));
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Number of vertices
        int V = sc.nextInt();

        // Number of edges
        int E = sc.nextInt();

        // Adjacency list representation
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<ArrayList<Integer>>());
        }

        // Input edges
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();

            // Add edge u -> v with weight w
            ArrayList<Integer> edge = new ArrayList<>();
            edge.add(v);
            edge.add(w);
            adj.get(u).add(edge);

            // If the graph is undirected, also add v -> u
            // Uncomment the following lines if the graph is undirected
            // edge = new ArrayList<>();
            // edge.add(u);
            // edge.add(w);
            // adj.get(v).add(edge);
        }

        // Source vertex
        int S = sc.nextInt();

        // Run Dijkstra's algorithm
        int[] dist = dijkstra(V, adj, S);

        // Output distances
        for (int i = 0; i < V; i++) {
            System.out.print(dist[i] + " ");
        }
    }
}