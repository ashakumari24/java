public class KnapSack {
    public static int knapSack(int val[], int wt[], int W, int n, int dp[][]) {
        if (W == 0 || n == 0) {
            return 0;
        }

        if (dp[n][W] != -1) {
            return dp[n][W];
        }
        if (wt[n - 1] <= W) {
            int ans1 = val[n - 1] + knapSack(val, wt, W - wt[n - 1], n - 1, dp);
            int ans2 = knapSack(val, wt, W, n - 1, dp);
            dp[n][W] = Math.max(ans1, ans2);
            return dp[n][W];
        } else {
            dp[n][W] = knapSack(val, wt, W, n - 1, dp);
            return dp[n][W];
        }
    }

    // tabulation
    public static int knapSackTab(int val[], int wt[], int W) {
        int n = val.length;
        int dp[][] = new int[n + 1][W + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < dp.length; i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < W + 1; j++) {
                int v = val[i - 1];
                int w = wt[i - 1];
                if (w <= j) {
                    int incProfit = v + dp[i - 1][j - w];
                    int excProfit = dp[i - 1][j];
                    /*
                     * dp[i][j]---
                     * i=no of item
                     * j=maximum profit
                     */
                    dp[i][j] = Math.max(incProfit, excProfit);

                } else {
                    int excProfit = dp[i - 1][j];
                    dp[i][j] = excProfit;
                }
            }
        }
        return dp[n][W];
    }

    public static int UnboundedKnapSack(int val[], int wt[], int W) {
        int n = val.length;
        int dp[][] = new int[n + 1][W + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < dp.length; i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < W + 1; j++) {
                int v = val[i - 1];
                int w = wt[i - 1];
                if (w <= j) {
                    int incProfit = v + dp[i][j - w];
                    int excProfit = dp[i - 1][j];
                    /*
                     * dp[i][j]---
                     * i=no of item
                     * j=maximum profit
                     */
                    dp[i][j] = Math.max(incProfit, excProfit);

                } else {
                    int excProfit = dp[i - 1][j];
                    dp[i][j] = excProfit;
                }
            }
        }
        return dp[n][W];
    }

    // target sum subsets
    public static boolean targetSumSubset(int arr[], int sum) {// O(n*sum)
        int n = arr.length;
        boolean dp[][] = new boolean[n + 1][sum + 1];
        // i=items & j=target sum
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                int v = arr[i - 1];
                // include
                if (v <= j && dp[i - 1][j - v] == true) {
                    dp[i][j] = true;
                }
                // exclude
                else if (dp[i - 1][j] == true) {
                    dp[i][j] = true;
                }
            }
        }
        return dp[n][sum];
    }

    // coins change problem
    public static int coinChange(int coins[], int sum) {
        int n = coins.length;
        int dp[][] = new int[n + 1][sum + 1];
        // initialize- sum is 0
        // i->coins, j->sum/change
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < dp.length; i++) {
            dp[0][i] = 0;
        }
        // O(N*Sum)
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (coins[i - 1] <= j) {// invalid
                    dp[i][j] = dp[i][j - coins[i - 1]] + dp[i - 1][j];

                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][sum];
    }

    public static int rodCutting(int length[], int price[], int totRod) {
        int n = price.length;
        int dp[][] = new int[n + 1][totRod + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < totRod + 1; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }

        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < totRod + 1; j++) {
                // valid
                if (length[i - 1] <= j) {
                    dp[i][j] = Math.max(price[i - 1] + dp[i][j - length[i - 1]], dp[i - 1][j]);
                } else {
                    // invalid
                    dp[i][j] = dp[i - 1][j];
                }

            }
        }
        return dp[n][totRod];
    }

    public static void main(String[] args) {
        int val[] = { 15, 14, 10, 45, 30 };
        int wt[] = { 2, 5, 1, 3, 4 };
        int W = 7;
        int dp[][] = new int[val.length + 1][W + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++)
                dp[i][j] = -1;
        }
        // System.out.println(knapSack(val, wt, W, val.length, dp));
        System.out.println(knapSackTab(val, wt, W));

        int arr[] = { 4, 2, 7, 1, 3 };
        int target = 10;
        System.out.println(targetSumSubset(arr, target));

        System.out.println(UnboundedKnapSack(val, wt, W));

        int coins[] = { 2, 5, 3, 6 };
        int sum = 10;
        System.out.println(coinChange(coins, sum));
        /*
         * given a rod of length n inches and an array of prices that includes prices of
         * all pieces of size smaller
         * tha 'n'. Determine the maximum value obtainable by cutting up the rod and
         * selling the pieces
         * 
         */
        int length[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
        int price[] = { 1, 5, 8, 9, 10, 17, 17, 20 };
        int totRod = 8;
        System.out.println(rodCutting(length, price, totRod));
    }

}
