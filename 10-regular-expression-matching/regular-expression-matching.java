class Solution {
    public boolean isMatch(String s, String p) {
        Boolean[][]dp=new Boolean[s.length()+1][p.length()+1];
        return solve(s,p,0,0,dp);
    }    
    public boolean solve(String s , String p, int i , int j , Boolean[][]dp){
        if(j==p.length()){
            return i==s.length();
        }
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        boolean firstMatch = (i < s.length() && (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.'));       
        boolean ans;
        if (j+1 <p.length()&& p.charAt(j+1)=='*'){
            ans=solve(s,p,i,j+2,dp)||(firstMatch && solve(s,p,i+1,j,dp));
        }else{
            ans=firstMatch && solve(s,p,i+1 , j+1 , dp);
        }
        return dp[i][j]=ans;
    }    
    
}