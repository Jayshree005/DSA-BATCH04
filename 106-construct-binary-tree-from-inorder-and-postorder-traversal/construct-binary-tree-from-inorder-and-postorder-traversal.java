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
    int postIndex;
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIndex = postorder.length - 1;
        
        // Inorder ki indexing save karo fast search ke liye
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return solve(postorder, 0, inorder.length - 1);
    }

    private TreeNode solve(int[] postorder, int left, int right) {
        // Base Case
        if (left > right) return null;

        // Postorder ke peeche se root uthao
        int rootVal = postorder[postIndex--];
        TreeNode root = new TreeNode(rootVal);

        // Inorder mein root ki position
        int mid = map.get(rootVal);

        // IMPORTANT: Pehle RIGHT build hoga, phir LEFT
        // Kyunki postorder peeche se [Root, Right, Left...] chalta hai
        root.right = solve(postorder, mid + 1, right);
        root.left = solve(postorder, left, mid - 1);

        return root;
    }
}