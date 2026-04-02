class Solution {
    public static boolean isPalindrome(String s)
    {
        int i = 0 , j = s.length()-1 ;
        while(i < j)
        {
            if(s.charAt(i) != s.charAt(j))
            {
                return false ;
            }
            i++ ;
            j-- ;
        }
        return true ;
    }
    public static void Solve(int i , String s , List<List<String>> ans, List<String> temp)
    {
        if(i == s.length())
        {
            ans.add(new ArrayList(temp)) ;
            return ;
        }
        for(int j = i ; j < s.length() ; j++)
        {
             if(isPalindrome(s.substring(i,j+1)))
             {
                temp.add(s.substring(i, j+1)) ;;
                Solve(j+1,s,ans,temp) ;
                temp.remove(temp.size()-1) ;
             }
        }
    }
    public List<List<String>> partition(String s) {
        
        List<List<String>> ans = new ArrayList() ;
        List<String> temp = new ArrayList() ;
     
        Solve(0,s,ans,temp) ;
        return ans ;
    }
}