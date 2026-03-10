class Solution {

    public static int FirstOccur(int low , int high , int target, int[] nums)
    {
        int ans = -1 ;
            while(low <= high)
            {
                int mid = low + (high-low)/2 ;
                if(nums[mid] == target)
                {
                    ans = mid ; 
                    high = mid -1 ;
                    // return mid ;
                }
                else if(nums[mid] < target)
                {
                    low = mid + 1 ;
                }
                else
                {
                    high = mid - 1 ;
                }
            }
            return ans ;
    }

    public static int LastOccur(int low , int high , int target, int[] nums)
    {
        int ans = -1 ;
            while(low <= high)
            {
                int mid = low + (high-low)/2 ;
                if(nums[mid] == target)
                {
                    ans = mid ;
                    low = mid + 1 ;
                    // return mid ;
                }
                else if(nums[mid] < target)
                {
                    low = mid + 1 ;
                }
                else
                {
                    high = mid - 1 ;
                }
            }
            return ans ;
    }
    public int[] searchRange(int[] nums, int target) {
        
        int n = nums.length ;
        int[] ans = new int[2] ;
        ans[0] = FirstOccur(0,n-1,target,nums) ;
        ans[1] = LastOccur(0,n-1,target,nums) ;
        return ans ;
    }
}