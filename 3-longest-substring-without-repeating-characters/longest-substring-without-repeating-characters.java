class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap <Character,Integer> map=new HashMap<>();
        int low=0;
        int maxLength=0;
        for(int high=0;high<s.length();high++){
            char current=s.charAt(high);
            if(map.containsKey(current)){
                low=Math.max(low,map.get(current)+1);
            }
            map.put(current,high);
            maxLength=Math.max(maxLength,high-low+1);
        }
        return maxLength;
        
    }
}