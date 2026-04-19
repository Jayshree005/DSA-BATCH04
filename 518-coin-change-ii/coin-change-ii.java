class Solution {
    public int solve(int i, int amount, int[] coins, int[][] dp) {
        // Base Case 1: Agar amount 0 ho gaya, matlab 1 tarika mil gaya
        if (amount == 0) return 1;
        
        // Base Case 2: Agar coins khatam ho gaye ya amount negative ho gaya
        if (i == coins.length || amount < 0) return 0;

        // Memoization check
        if (dp[i][amount] != -1) return dp[i][amount];

        // Choice 1: Take the coin (stay on same index 'i')
        int take = solve(i, amount - coins[i], coins, dp);

        // Choice 2: Skip the coin (move to next index 'i+1')
        int skip = solve(i + 1, amount, coins, dp);

        // Dono tareeko ko add kar do (kyunki total combinations chahiye)
        return dp[i][amount] = take + skip;
    }

    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for (int[] row : dp) {
            java.util.Arrays.fill(row, -1);
        }
        return solve(0, amount, coins, dp);
    }
}