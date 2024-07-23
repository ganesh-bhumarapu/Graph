import java.util.*;

class NumberOfProvinces {

    public static void dfs(int node, ArrayList<ArrayList<Integer>> adjList, int[] visited) {
        visited[node] = 1;
        for (Integer it : adjList.get(node)) {
            if (visited[it] == 0) {
                dfs(it, adjList, visited);
            }
        }
    }

    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (adj.get(i).get(j) == 1 && i != j) {
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }

        int[] visited = new int[V];
        int count = 0;
        for (int i = 0; i < V; i++) {
            if (visited[i] == 0) {
                count++;
                dfs(i, adjList, visited);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int V = scanner.nextInt();

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        System.out.println("Enter the adjacency matrix:");

        for (int i = 0; i < V; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < V; j++) {
                row.add(scanner.nextInt());
            }
            adj.add(row);
        }

        System.out.println("Number of Provinces: " + numProvinces(adj, V));

        scanner.close();
    }
}
