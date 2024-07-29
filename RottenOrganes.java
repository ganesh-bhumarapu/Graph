import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair {
    int first;
    int second;
    int third;

    Pair(int first, int second, int third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }
}

class RottenOranges {
    public static int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        int[][] visited = new int[n][m];
        int countFresh = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.add(new Pair(i, j, 0));
                    visited[i][j] = 2;
                } else {
                    visited[i][j] = 0;
                }
                if (grid[i][j] == 1) {
                    countFresh++;
                }
            }
        }

        int unit = 0;
        int[] drow = {-1, 0, +1, 0};
        int[] dcol = {0, 1, 0, -1};
        int count = 0;

        while (!q.isEmpty()) {
            int r = q.peek().first;
            int c = q.peek().second;
            int t = q.peek().third;

            unit = Math.max(unit, t);
            q.remove();
            for (int i = 0; i < 4; i++) {
                int nrow = r + drow[i];
                int ncol = c + dcol[i];

                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && visited[nrow][ncol] == 0 && grid[nrow][ncol] == 1) {
                    q.add(new Pair(nrow, ncol, t + 1));
                    visited[nrow][ncol] = 2;
                    count++;
                }
            }
        }

        if (count != countFresh) return -1;

        return unit;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of rows:");
        int n = sc.nextInt();

        System.out.println("Enter the number of columns:");
        int m = sc.nextInt();

        int[][] grid = new int[n][m];

        System.out.println("Enter the grid values (row-wise):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        int result = orangesRotting(grid);
        System.out.println("Minimum time required to rot all oranges: " + result);
    }
}
