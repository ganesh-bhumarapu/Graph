import java.util.*;
class ConstructBinarypalindromeByRepeatedAppendingAndTrimming{
    public static String solve(int n, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append('0');
        }
        int i = 0;
        while (i < n) {
            sb.setCharAt(i, '1');
            sb.setCharAt(n - i - 1, '1');
            i += k;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        System.out.println(solve(n, k));
    }
}