/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> ans = new ArrayList() ;
        if(root == null){
            return ans ;
        }

        Queue<TreeNode> q = new LinkedList<>() ;
        ArrayList<Integer> ls = new ArrayList<>() ;
        q.add(root) ;
        q.add(null) ;

        //    3
        //9       20
        //    15       7

        while(!q.isEmpty()){

            TreeNode curr = q.poll() ;
            // List<Integer> ls = new ArrayList<>() ;
            if(curr == null){
                ans.add(ls) ;
                if(q.isEmpty()){
                    return ans ;
                }
                q.add(null) ;
                ls = new ArrayList<>() ;
            }
            else{
                ls.add(curr.val) ;
                if(curr.left != null){
                    q.add(curr.left) ;
                }

                if(curr.right != null){
                    q.add(curr.right) ;
                }
            }

            
        }
        return ans ;
    }
}