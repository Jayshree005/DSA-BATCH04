class Solution {

    public static boolean Solve(int i , int j , int idx, char[][] board , String word)
    {
        if(idx == word.length()) return true ;

        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || word.charAt(idx) != board[i][j]) return false ;

        char temp = board[i][j] ;
        board[i][j] = '#' ;
        boolean ans = Solve(i+1,j,idx+1,board,word) || Solve(i-1,j,idx+1,board,word) || Solve(i,j+1,idx+1,board,word) || Solve(i,j-1,idx+1,board,word)  ;

        board[i][j] = temp ;
        return ans ;
    }
    public boolean exist(char[][] board, String word) {
        
        int m = board.length ;
        int n = board[0].length ;

        for(int i = 0 ; i < m ; i++)
        {
            for(int j = 0 ; j < n ; j++)
            {
                if(Solve(i,j,0,board,word)) return true ;
            }
        }

        return false ;
    }
}