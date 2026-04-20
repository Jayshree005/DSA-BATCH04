import java.util.*;

class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] jobs = new int[n][3];
        for (int i = 0; i < n; i++) {
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }


        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);

        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return solve(jobs, 0, dp);     
    }

    public static int solve(int[][] jobs, int i, int[] dp) {
        if (i >= jobs.length) return 0;
        if (dp[i] != -1) return dp[i];


        int nextIdx = findNext(jobs, i + 1, jobs[i][1]);

        int take = jobs[i][2] + solve(jobs, nextIdx, dp);
        int skip = solve(jobs, i + 1, dp);

        return dp[i] = Math.max(take, skip);
    }

    public static int findNext(int[][] jobs, int low, int targetEnd) {
        int high = jobs.length - 1;
        int ans = jobs.length;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (jobs[mid][0] >= targetEnd) {
                ans = mid;
                high = mid - 1; 
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}