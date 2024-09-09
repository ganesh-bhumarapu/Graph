import java.util.*;
class Pair{
    int x, y, dist, wallsRemoved;
    Pair(int x, int y, int dist, int wallsRemoved){
        this.x = x;
        this.y = y;
        this.dist = dist;
        this.wallsRemoved = wallsRemoved;
    }
}
class ShortestPathbyRemovingKwalls{
    static int shotestPath(int[][] mat, int n, int m, int k) {
        int[] dx = {-1, 0, +1, 0};
        int[] dy = {0, -1, 0, +1};
        boolean[][][] vis = new boolean[n][m][k + 1];
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, 0, 0, 0));
        vis[0][0][0] = true;
        while(!q.isEmpty()){
            Pair it = q.poll();
            int x = it.x;
            int y = it.y;
            int dist = it.dist;
            int wallsRemoved = it.wallsRemoved;

            if(x == n - 1 && y == m - 1){
                return dist;
            }
            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx >= 0 && nx < n && ny >= 0 && ny < n){
                    if(mat[nx][ny] == 0 && !vis[nx][ny][wallsRemoved]){
                        vis[nx][ny][wallsRemoved] = true;
                        q.add(new Pair(nx, ny, dist + 1, wallsRemoved));
                    }
                    if(mat[nx][ny] == 1 && wallsRemoved < k && !vis[nx][ny][wallsRemoved + 1]){
                        vis[nx][ny][wallsRemoved + 1] = true;
                        q.add(new Pair(nx, ny, dist + 1, wallsRemoved + 1));
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] mat = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                mat[i][j] = sc.nextInt();
            }
        }
        int k = sc.nextInt();
        System.out.println(shotestPath(mat, n, m, k));
    }
}