import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair {
    int first;
    int second;

    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class UndirectedGraphCycle {
    // Function to detect cycle in an undirected graph.
    public boolean detectCycle(int src, int V, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        visited[src] = true;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(src, -1));

        while (!q.isEmpty()) {
            int node = q.peek().first;
            int parent = q.peek().second;
            q.remove();

            for (int adjacentNode : adj.get(node)) {
                if (!visited[adjacentNode]) {
                    visited[adjacentNode] = true;
                    q.add(new Pair(adjacentNode, node));
                } else if (parent != adjacentNode) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (detectCycle(i, V, adj, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of vertices:");
        int V = sc.nextInt();

        System.out.println("Enter the number of edges:");
        int E = sc.nextInt();

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        System.out.println("Enter the edges (u v) where u and v are vertices of the edge:");
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u); // As the graph is undirected
        }

        UndirectedGraphCycle cycleDetector = new UndirectedGraphCycle();
        boolean hasCycle = cycleDetector.isCycle(V, adj);

        if (hasCycle) {
            System.out.println("Graph contains cycle");
        } else {
            System.out.println("Graph doesn't contain cycle");
        }

        sc.close();
    }
}
