import java.util.*;
class Pair{
    int first;
    int second;
    public Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}
class FindTheNumberOfIslands{
    public static void bfs(int ro, int co, int[][] visited, char[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(ro, co));
        while(!q.isEmpty()){
            int row = q.peek().first;
            int col = q.peek().second;
            q.remove();
            for(int delrow = -1; delrow <= 1; delrow++){
                for(int delcol = -1; delcol <= 1; delcol++){
                    int nrow = row + delrow;
                    int ncol = col + delcol;
                    if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m &&
                       grid[nrow][ncol] == '1' && visited[nrow][ncol] == 0){
                        visited[nrow][ncol] = 1;
                        q.add(new Pair(nrow, ncol));
                    }
                }
            }
        }
    }
    public static int numIslands(char[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        int[][] visited = new int[n][m];
        for(int row = 0; row < n; row++){
            for(int col = 0; col < m; col++) {
                if (grid[row][col] == 1 && visited[row][col] == 0) {
                    count++;
                    bfs(row, col, visited, grid);
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of rows:");
        int n = sc.nextInt();
        System.out.println("Enter number of columns:");
        int m = sc.nextInt();

        char[][] grid = new char[n][m];
        System.out.println("Enter the grid:");
        for(int i = 0; i < n; i++) {
            String row = sc.next();
            for(int j = 0; j < m; j++) {
                grid[i][j] = row.charAt(j);
            }
        }
        int numOfIslands = numIslands(grid);
        System.out.println("Number of islands: " + numOfIslands);
    }
}
