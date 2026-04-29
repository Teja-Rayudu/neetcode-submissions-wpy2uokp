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
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        int left = diameterTree(root.left);
        int right = diameterTree(root.right);

        int diameter = left + right;

        int sub = Math.max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right));

        return Math.max(sub, diameter);
    }

    public int diameterTree(TreeNode root){
        if(root == null) return 0;

        return 1 + Math.max(diameterTree(root.left), diameterTree(root.right));
    }
}
