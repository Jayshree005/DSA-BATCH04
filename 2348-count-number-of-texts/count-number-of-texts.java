class Solution {
    private static final int MOD = 1000000007;

    public int countTexts(String pressedKeys) {
        int n = pressedKeys.length();
        long[] dp = new long[n + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            char currentChar = pressedKeys.charAt(i - 1);
            int maxPresses = (currentChar == '7' || currentChar == '9') ? 4 : 3;

            for (int k = 1; k <= maxPresses && i - k >= 0; k++) {
                if (pressedKeys.charAt(i - k) == currentChar) {
                    dp[i] = (dp[i] + dp[i - k]) % MOD;
                } else {
                    break;
                }
            }
        }

        return (int) dp[n];
    }
}