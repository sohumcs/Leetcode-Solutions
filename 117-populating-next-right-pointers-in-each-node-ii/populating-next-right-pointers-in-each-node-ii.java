/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
// Algo Used: BFS / Level Oreder Traversal
class Solution {
    public Node connect(Node root) {
        if(root == null) return null;

        Queue<Node> q= new LinkedList<>();
        q.offer(root); // starting with 0 level

        while(!q.isEmpty()){ // bfs traversal
            int size= q.size();
            Node prev= null;
            for(int i=0; i< size; i++){ // level by level point the links as per requirement
                Node curr= q.poll();
                if(prev != null){ // linking nodes
                    prev.next= curr;
                }
                
                prev= curr; // moving prev to curr

                if(curr.left != null){ // adding left node in queue
                    q.offer(curr.left);
                }

                if(curr.right != null){ // adding right node in queue
                    q.offer(curr.right);
                }
            }  
        }
        return root; 
    }
}