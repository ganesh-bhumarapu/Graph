import java.util.*;
class Node{
    int index;
    int jumps;
    Node(int index, int jumps){
        this.index = index;
        this.jumps = jumps;
    }
}
class MinimumJumpsBFS{
    public static int minJumpsUsingBFS(int[] arr, int n){
        if(n == 1) return 0;
        if(arr[0] == 0) return -1;
        //BFS
        Queue<Node> q = new LinkedList<>();
        boolean[] vis = new boolean[n];
        q.add(new Node(0, 0));
        vis[0] = true;
        while(!q.isEmpty()){
            Node node = q.poll();
            int i = node.index;

            for(int j = 1; j < arr[i]; j++){
                int nextIndex = i + j;
                if(nextIndex >= n - 1){
                    return node.jumps + 1;
                }
                if(!vis[nextIndex]){
                    vis[nextIndex] = true;
                    q.add(new Node(nextIndex, node.jumps + 1));
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(minJumpsUsingBFS(arr, n));
    }
}