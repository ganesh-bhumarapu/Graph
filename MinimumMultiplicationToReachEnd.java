import java.util.*;
class Pair{
    int steps;
    int node;
    Pair(int steps, int node){
        this.steps = steps;
        this.node = node;
    }
}
class MinimumMultiplicationToReachEnd{
    public static int minimumNoOfSteps(int[] arr, int start, int end){
        int n = arr.length;
        int[] dist = new int[100000];
        Arrays.fill(dist, (int)(1e9));
        dist[0] = 0;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, start));
        while(!q.isEmpty()){
            Pair it = q.poll();
            int steps = it.steps;
            int node = it.node;
            if(node == end) return steps;
            for(int i = 0; i < n; i++){
                int nbrNode = (node * arr[i]) % 100000;
                if((steps + 1) < dist[nbrNode]){
                    dist[nbrNode] = steps + 1;
                    q.add(new Pair(dist[nbrNode], nbrNode));
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        int start = sc.nextInt();
        int end = sc.nextInt();
        System.out.println(minimumNoOfSteps(arr, start, end));
    }
}