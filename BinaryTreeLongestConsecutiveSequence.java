tion for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BinaryTreeLongestConsecutiveSequence {
    int maxLen = 0;
    public int longestConsecutive(TreeNode root) {
        helper(root, 0);
        return maxLen;
    }
    
    public void helper(TreeNode root, int len) {
        if(root == null) {
            maxLen = Math.max(maxLen,len);
            return;
        }
        if (root.left != null && root.left.val - 1 == root.val) {
            helper(root.left, len+1);
        }else {
            maxLen = Math.max(maxLen, len+1);
            helper(root.left, 0);
        }
        
        if (root.right != null && root.right.val - 1 == root.val) {
            helper(root.right, len+1);
        }else {
            maxLen = Math.max(maxLen, len+1);
            helper(root.right, 0);
        }
    }
}
