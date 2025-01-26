class Solution {
    boolean isvalid = true;
    public boolean isBalanced(TreeNode root) {
        postorder(root);
        return isvalid;
    }
    private int postorder(TreeNode root) {

        if ( root == null) { // base condition
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 0;
        }          
        int lefth = postorder(root.left); 
        if (root.left != null) {
            lefth=lefth+1;
        }
        int righth = postorder(root.right); //  root = 3 1+2; = 3  3-1 2
        if (root.right != null) {
            righth = righth+1;
        }
        int diff = Math.abs(lefth - righth); //  2-1 = 1
        System.out.println(diff);
        if (diff > 1) {
            isvalid = false;
        }
        return Math.max(lefth, righth); // 3>1 3
    }
}