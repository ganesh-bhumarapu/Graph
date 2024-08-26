import java.util.*;
class Pair{
    int x, y, dist;
    Pair(int x, int y, int dist){
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}
class ShortestDistanceInaBinaryMaze{
    public static int shortestDistance(int[][] grid, int[] source, int[] destination){
        int n = grid.length;
        int m = grid[0].length;
        //direction vectors to move up, doen, right, left
        int[] dx = {-1, 0, +1, 0};
        int[] dy = {0, +1, 0, -1};
        //BFS
        Queue<Pair> q = new LinkedList<>();
        boolean[][] vis = new boolean[n][m];
        q.add(new Pair(source[0], source[1], 0));
        while(!q.isEmpty()){
            Pair node = q.poll();
            int x = node.x;
            int y = node.y;
            int dist = node.dist;

            if(x == destination[0] && y == destination[1]){
                return dist;
            }
            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx >= 0 && nx < n && ny >=0 && ny < m && grid[nx][ny] == 1 && vis[nx][ny] == false){
                    q.add(new Pair(nx, ny, dist + 1));
                    vis[nx][ny] = true;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                grid[i][j] = sc.nextInt();
            }
        }
        int[] source = new int[2];
        int[] destination = new int[2];
        for(int i = 0; i < 2; i++){
            source[i] = sc.nextInt();
        }
        for(int i = 0; i < 2; i++){
            destination[i] = sc.nextInt();
        }
        System.out.println(shortestDistance(grid, source, destination));
    }
}