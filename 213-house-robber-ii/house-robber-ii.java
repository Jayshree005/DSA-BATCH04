class Solution {
    public static int Solve(int[]nums,int i ,int end, int[]dp){
        if (end<i)return 0;
        if (dp[i] !=-1){
            return dp[i];
        }
        int take =nums[i]+Solve(nums,i+2, end,dp);
        int skip = Solve(nums,i+1,end,dp);
        dp[i]=Math.max(take,skip);
        return dp[i];
    }
    public int rob(int[] nums) {
        int n=nums.length;
        if (n == 1) return nums[0]; // Agar ek hi ghar h
// Case 1: 0 se n-2 tak (Last ghar skip kiya)
        int[] dp1 = new int[n];
        for (int i = 0; i < n; i++) dp1[i] = -1;
        int ans1 = Solve(nums, 0, n - 2, dp1);

        // Case 2: 1 se n-1 tak (First ghar skip kiya)
        int[] dp2 = new int[n];
        for (int i = 0; i < n; i++) dp2[i] = -1;
        int ans2 = Solve(nums, 1, n - 1, dp2);

        return Math.max(ans1, ans2);
    }
}