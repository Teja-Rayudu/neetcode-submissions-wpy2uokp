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
    public int goodNodes(TreeNode root) {
        int[] count = {0};
        int[] maxVal = {root.val};

        dfs(root, count, maxVal);

        return count[0];
    }

    public void dfs(TreeNode root, int[] count, int[] maxVal){
        if(root == null) return;

        if(root.val >= maxVal[0]){
            count[0]++;
            maxVal[0] = root.val;
        }

        dfs(root.left, count, maxVal);
        dfs(root.right, count, maxVal);
    }
}
