// if n is multiple of 3 then we can explore the node easily in shortest path
//if it is not multiple of 3 then decrement the n value and make it multiple of 3
import java.util.*;
class ShortestPathFrom0toN{
    public static int shortestPath(int n){
        int ans = 0;
        while(n > 1){
            if(n % 3 == 0){
                n /= 3;
            }else{
                n--;
            }
            ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(shortestPath(n));
    }
}