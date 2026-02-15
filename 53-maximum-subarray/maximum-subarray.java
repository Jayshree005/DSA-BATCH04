class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int max_sum = Integer.MIN_VALUE;
        int current_sum = 0 ;

        for (int i=0 ; i<n ; i++)
        {
            current_sum = Math.max(nums[i], current_sum + nums[i]);
            max_sum = Math.max(max_sum , current_sum);
        
            if(current_sum < 0)
        {
            current_sum=0;
        }
     }
        return max_sum;
    }
}