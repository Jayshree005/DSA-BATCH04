class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        
        for(int i = 0 ; i < nums.length ; i++)
        {
            if(nums[i] % 2 == 0)
            {
                nums[i] = 0 ;
            }
            else
            {
                nums[i] = 1 ;
            }
        }

        int i = 0 , j = 0 , curr_Sum = 0 , Zero_Count = 0 , count = 0 ;
        int n = nums.length ;
        while(j < n)
        {
            curr_Sum += nums[j] ;
            while(i < j && (curr_Sum > k || nums[i] == 0))
            {
                if(nums[i] == 0)
                {
                    Zero_Count += 1 ;
                }
                else
                {
                    Zero_Count = 0 ;
                }
                curr_Sum -= nums[i] ;
                i++ ;
            }

            if(curr_Sum == k)
            {
                count += 1 + Zero_Count ;
            }
            j++ ;
        }

        return count  ;

    }
}