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
    int preIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return solve(preorder, inorder, 0, inorder.length - 1);
    }

    private TreeNode solve(int[] preorder, int[] inorder, int left, int right) {
        // Base case
        if (left > right) return null;

        // Current root preorder se uthao
        int rootVal = preorder[preIndex++];
        TreeNode root = new TreeNode(rootVal);

        // Inorder mein rootVal ki index dhoondne ke liye manually loop chalao
        int mid = 0;
        for (int i = left; i <= right; i++) {
            if (inorder[i] == rootVal) {
                mid = i;
                break;
            }
        }

        // Subtrees build karo
        root.left = solve(preorder, inorder, left, mid - 1);
        root.right = solve(preorder, inorder, mid + 1, right);

        return root;
    }
}