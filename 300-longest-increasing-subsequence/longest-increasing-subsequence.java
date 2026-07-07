class Solution {
    public int solve(int[] nums, int i, int prev_i, int[][] dp) {
        if (i == nums.length) return 0;

        // prev_i + 1 is used because prev_i can be -1 (to handle index mapping)
        if (dp[i][prev_i + 1] != -1) return dp[i][prev_i + 1];

        // Option 1: Skip current element
        int length = solve(nums, i + 1, prev_i, dp);

        // Option 2: Take current element (if it's greater than the previous one)
        if (prev_i == -1 || nums[i] > nums[prev_i]) {
            length = Math.max(length, 1 + solve(nums, i + 1, i, dp));
        }

        return dp[i][prev_i + 1] = length;
    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        // dp[index][prev_index + 1]
        int[][] dp = new int[n][n + 1];
        for (int[] row : dp) Arrays.fill(row, -1);

        return solve(nums, 0, -1, dp);
    }
}