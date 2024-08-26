// we can solve it by using the bfs which traverses in level wise
import java.util.*;
class LevelOfNodes{
    public static int levelOfNode(int V, ArrayList<ArrayList<Integer>> adj, int X){
        boolean[] vis = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        vis[0] = true;
        int level = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int current = q.poll();
                if(current == X){
                    return level;
                }
                for(int it : adj.get(current)){
                    if(!vis[it]){
                        vis[it] = true;
                        q.add(it);
                    }
                }
            }
            level++;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < V; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int X = sc.nextInt();
        System.out.println(levelOfNode(V, adj, X));
    }
}