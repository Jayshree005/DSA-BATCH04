class Solution {
    public int numberOfSubstrings(String s) {
        
        int i = 0 , j = 0 , n = s.length() ;
        int[] ans = new int[3] ;
        if(n < 3) return 0;
        int count = 0 ;
        while(j < n)
        {
            //putting element
            // 0 + 1 = 1
            ans[s.charAt(j)-'a']++ ; // ans['a'-'a']-> ans[97-97] = ans[0]
            while(ans[0] >= 1 && ans[1] >= 1 && ans[2] >= 1)
            {
                // element remove
                count += n - j ;
                ans[s.charAt(i)-'a']-- ;
                i++ ;
            }
            j++ ;
        }
        return count ;

    }
}