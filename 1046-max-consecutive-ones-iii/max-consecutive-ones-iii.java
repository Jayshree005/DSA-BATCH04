class Solution {
    public int longestOnes(int[] nums, int k) {
        
        int i = 0 , j = 0 , currSum = 0 , ans = 0 , n = nums.length ;
        int Zero = 0 ;
        for(int a = 0 ; a < n ; a++)
        {
            if(nums[a] == 0)
            {
                Zero++ ;
            }
        }
        if(Zero < k) return n ;
        while(j<n)
        {
            currSum += nums[j] ;
            if(j-i+1 - currSum > k)
            {
                currSum -= nums[i] ;
                i++ ;
            }
            else if(j-i+1 - currSum == k)
            {
                ans = Math.max(ans,j-i+1) ;
            }
            j++ ;
        }
        return ans ;
    }
}