class Solution {
    TreeNode n;
    int k;
    
    
    public void getKthSmallestUsingInorder(TreeNode node) {
        if (node == null)
            return;
        
        
        getKthSmallestUsingInorder(node.left);
        
        
        this.k--;
        
        if (this.k == 0)
            this.n = node;
        
        
        if (this.k > 0)
            getKthSmallestUsingInorder(node.right);
    }
    
    
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        getKthSmallestUsingInorder(root);
        return this.n.val;
    }
}