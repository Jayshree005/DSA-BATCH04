class Solution {
    public static int Solve(int[] arr, int sum, int i, int[][]dp){
        
        if(sum == 0){
            return 0;
        }
        
        if(sum < 0 || i == arr.length){
            return 99999;
        }

        if(dp[i][sum] != -1 ){
            return dp[i][sum];
        }
        int take = 1 +  Solve(arr,sum-arr[i],i,dp);
        
        int not_take = Solve(arr,sum,i+1,dp);
        dp[i][sum] = Math.min(take,not_take);
        return dp[i][sum];
    }
    public int coinChange(int[] coins, int amount) {

        int[][] dp = new int[coins.length][amount+1];
        for(int i=0;i<coins.length;i++){
            for(int j=0 ; j<amount+1;j++){
                dp[i][j]=-1;
            }
        }
        int ans = Solve(coins, amount, 0, dp);
        if(ans >= 99999) return -1;
        return ans;
    }
}