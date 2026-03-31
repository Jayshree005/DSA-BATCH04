class Solution {

    public static void Solve(int i , int[] arr, int target ,  List<List<Integer>> ans , ArrayList<Integer> temp)
    {
        if(target == 0)
        {
            ans.add(new ArrayList<>(temp)) ;
            return ;
        }
        if(target < 0 || i == arr.length)
        {
            // ans.add(temp) ;
            return ;
        }

        if(target >= arr[i])
        {
            temp.add(arr[i]) ;
            Solve(i+1,arr,target-arr[i],ans,temp) ;
            temp.remove(temp.size()-1) ;
        }

        int j = i;
        while(j + 1 < arr.length && arr[j] == arr[j+1]) j++;
        Solve(j+1,arr,target,ans,temp) ;

    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        List<List<Integer>> ans = new ArrayList() ;
        Arrays.sort(candidates) ;
        Solve(0,candidates,target,ans,new ArrayList<Integer>()) ;
        return ans ;
    }
}