import java.util.*;
class MaximumWeightNode{
    public static int maxWtNode(int[] edges, int n){
        int[] wt = new int[n];
        for(int i = 0; i < n; i++){
            if(edges[i] != -1) {
                wt[edges[i]] += i;
            }
        }
        int maxWt = -1;
        int maxWtIndex = -1;
        for(int i = 0; i < n; i++){
            if(wt[i] >= maxWt){
                maxWt = wt[i];
                maxWtIndex = i;
            }
        }
        return maxWtIndex;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] edges = new int[n];
        for(int i = 0; i < n; i++){
            edges[i] = sc.nextInt();
        }
        System.out.println(maxWtNode(edges, n));
    }
}