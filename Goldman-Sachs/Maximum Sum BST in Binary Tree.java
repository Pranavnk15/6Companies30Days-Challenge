Maximum Sum BST in Binary Tree

Given a binary tree root, return the maximum sum of all keys of any sub-tree which is also a Binary Search Tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.

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
    int result = Integer.MIN_VALUE;

    public int maxSumBST(TreeNode root) {
        helper(root);
        return result < 0 ? 0 : result;    
    }

    public int[] helper(TreeNode root) {
        if(root == null) {
            return new int[] {Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        }

        int[] left = helper(root.left);
        int[] right = helper(root.right);
        if(left[1] >= root.val || right[0] <= root.val) {
            return new int[] {Integer.MIN_VALUE, Integer.MAX_VALUE, 0};
        }
        int sum = left[2] + root.val + right[2];
        System.out.println("Sum: "+ sum);
        result = Math.max(result, sum);
        return new int[] {Math.min(root.val, left[0]), Math.max(root.val, right[1]), sum};
    }
}