import java.util.*;
class Prerequisites{
    public static boolean isPossible(int N,int P, int[][] prerequisites)
    {
        // Your Code goes here
        //form graph
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < N; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < P; i++){
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        //count indegree
        int[] indegree = new int[N];
        for(int i = 0; i < N; i++){
            for(int it : adj.get(i)){
                indegree[it]++;
            }
        }
        // push the elements to thw queue whose indegree is 0
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < N; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        int count = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            count++;
            for(int it : adj.get(node)){
                indegree[it]--;
                if(indegree[it] == 0){
                    q.add(it);
                }
            }
        }
        if(count == N){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int P = sc.nextInt();
        int[][] prerequisites = new int[N][N];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                prerequisites[i][j] = sc.nextInt();
            }
        }
        boolean res = isPossible(N, P, prerequisites);
        System.out.println(res);
    }
}