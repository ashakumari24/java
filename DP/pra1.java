import java.sql.Array;
import java.util.Arrays;

public class pra1 {
    // memoization dp
    public static int fib(int n, int[] ways) {
        if (n == 1 || n == 0) {
            return n;
        }
        if (ways[n] != 0) {
            return ways[n];
        }
        ways[n] = fib(n - 1, ways) + fib(n - 2, ways);
        return ways[n];
    }

    // tabulation dp
    public static int fib2(int n) {
        int dp[] = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    // count ways to reach the nth stair. The person can climb either 1 stair or
    // 2strairs at a time
    // normal recursion------
    public static int countWays(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == -1) {
            return 0;
        }
        return countWays(n - 1) + countWays(n - 2);
    }

    // memoization------
    public static int countWays1(int n, int w[]) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }
        if (w[n] != -1) {
            return w[n];
        }
        w[n] = countWays1(n - 1, w) + countWays1(n - 2, w);
        return w[n];
    }

    // tabulation dp-----
    public static int countWays2(int n) {
        int dp[] = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                dp[i] = dp[i - 1];
            } else {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 5;
        int ways[] = new int[n + 1];
        Arrays.fill(ways, -1);
        // System.out.println(fib(5, ways));
        // System.out.println(fib2(n));

        System.out.println(countWays(n));
        System.out.println(countWays1(n, ways));
        System.out.println(countWays2(n));
    }
}