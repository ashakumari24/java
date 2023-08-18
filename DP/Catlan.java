import java.util.Arrays;

import javax.imageio.spi.ImageWriterSpi;

public class Catlan {
    public static int catlan1(int n) {
        if (n == 0 | n == 1) {
            return 1;
        }
        int ans = 0;
        for (int i = 0; i <= n - 1; i++) {
            ans += catlan1(i) * catlan1(n - i - 1);
        }
        return ans;
    }

    // memoazation
    public static int catlan2(int n, int dp[]) {
        if (n == 0 | n == 1) {
            return 1;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        int ans = 0;
        for (int i = 0; i <= n - 1; i++) {
            ans += catlan2(i, dp) * catlan2(n - i - 1, dp);
        }
        return dp[n] = ans;
    }

    // tabulation
    public static int catlan3(int n) {
        int dp[] = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(catlan1(n));
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println(catlan2(n, dp));
        System.out.println(catlan3(n));
    }

}
