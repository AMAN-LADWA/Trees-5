/*
Desc : We use inorder traversal and use two pointers to keep track of the first and the 
second fault in the ordedr of traversal, and replace them later to recover the BST.
Space Complexity : O(1)
Time Complexity : O(n)
*/

class Solution {
    TreeNode prev;
    TreeNode last;
        TreeNode first;
        TreeNode second;
        boolean flag;
        public void recoverTree(TreeNode root){
            if(root == null) return;
            inorder(root);
            int temp = first.val;
            first.val = last.val;
            last.val = temp;
        }
    private void inorder(TreeNode root){
        if(root == null) return;
        inorder(root.left);
        if(prev!=null && prev.val>=root.val){
            if(!flag){
                first = prev;
                last = root;
                flag = true;
            }else{
                last = root;
            }
        }
        prev = root;
        if(flag && last!=null){
            
        }else{
            inorder(root.right);
        }
    }
}
