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
    public void flatten(TreeNode root) {
        TreeNode curr = root;
        
        while (curr != null) {
            // Agar left child hai, toh hi adjustment chahiye
            if (curr.left != null) {
                TreeNode prev = curr.left;
                
                // Left subtree ka right-most node dhoondo
                while (prev.right != null) {
                    prev = prev.right;
                }
                
                // Connection: Left subtree ke end mein purana right subtree jodo
                prev.right = curr.right;
                
                // Shift: Left child ko right child bana do
                curr.right = curr.left;
                curr.left = null;
            }
            
            // Agle node par jao (Jo pehle left tha, ab right ban chuka hai)
            curr = curr.right;
        }
    }
}