class Solution {
    public int numSubarraysWithSum(int[] nums, int k) {
        // HashMap<Integer,Integer>map= new HashMap<>();
        // int n=nums.length;
        // int curr_sum=0;
        // int count=0;
        // map.put(0,1);
        // for(int i=0;i<n;i++){
        //     curr_sum+=nums[i];

        //   if (map.containsKey(curr_sum-goal)){
        //     count+=map.get(curr_sum-goal);
        // }
        // map.put(curr_sum,map.getOrDefault(curr_sum,0)+1);
        // }
        // return count; 
        
        int i=0;
        int j=0;
        int count=0;
        int n=nums.length;
        int curr_sum=0;
        int zero_count=0;
        while(j<n){
            curr_sum += nums[j];
            while(i<j && (curr_sum>k || nums[i]==0)){
                if(nums[i]==0){
                    zero_count++;
                }
                else{
                    zero_count=0;
                }
                curr_sum -= nums[i];
                i++;
            }
            if(curr_sum ==k){
                count += 1+zero_count;
            }
            j++;
        }
        return count;
    }
}