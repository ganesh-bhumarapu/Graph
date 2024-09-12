import java.util.*;
class TransitiveClosureGraph{
    static ArrayList<ArrayList<Integer>> transitiveClosure(int N, int graph[][]){
        boolean[][] mat = new boolean[N][N];

        for(int i = 0; i < N; i++){
            dfs(i, i, graph, new boolean[N], mat);
        }
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < N; i++){
            ans.add(new ArrayList<>());
            for(int j = 0; j < N; j++){
                if(mat[i][j]){
                    ans.get(i).add(1);
                }else{
                    ans.get(i).add(0);
                }
            }
        }
        return ans;
    }
    private static void dfs(int start, int cur, int[][] graph, boolean[] vis, boolean[][] mat){
        vis[cur] = true;
        mat[start][cur] = true;

        for(int i = 0; i < graph.length; i++){
            if(!vis[i] && graph[start][i] == 1){
                dfs(start, i, graph, vis, mat);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] graph = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                graph[i][j] = sc.nextInt();
            }
        }
        System.out.println(transitiveClosure(n, graph));
    }
}