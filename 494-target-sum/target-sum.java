class Solution {
    static int[][]dp;
    public static int Solve (int sum ,int[]arr,int i){
    if(i==arr.length){
        if(sum==0)return 1;
        return 0;
    }
    if(dp[i][sum]!= -1){
            return dp[i][sum];
        }
    int take = 0;
    if(arr[i]<=sum){
        take = Solve(sum - arr[i], arr, i + 1);   
    }
    int notTake=Solve(sum,arr,i+1);
    dp[i][sum] = take + notTake;
        return dp[i][sum];
    }

    public int findTargetSumWays(int[] nums, int target) {
        int TotalSum=0;
        for(int num:nums){
            TotalSum+=num;
        }
        if(Math.abs(target) > TotalSum || (TotalSum + target) % 2 != 0)
            return 0;

        int Sum = (TotalSum + target) / 2;
        dp = new int[nums.length + 1][Sum + 1];
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j <= Sum; j++){
                dp[i][j] = -1;
            }
        }
        //int Sum=(TotalSum+target)/2;
        //if(target>TotalSum)return 0;
        return Solve(Sum,nums,0);
        
    }
}
