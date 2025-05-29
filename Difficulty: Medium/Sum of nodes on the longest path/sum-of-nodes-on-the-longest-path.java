/*
class Node {
    int data;
    Node left, right;

    public Node(int data){
        this.data = data;
    }
} */
class Solution {
    private void func (Node root, ArrayList<int[]> ans, int len, int sum) {
        
        if (root == null)
            return ;
        sum += root.data;
        if (root.left == null && root.right == null)
            ans.add(new int[] {len, sum});
        
        func(root.left, ans, len + 1, sum);
        func(root.right, ans, len + 1, sum);
    }
    
    public int sumOfLongRootToLeafPath(Node root) {
        // code here
        ArrayList<int[]> ans = new ArrayList<>();
        func (root, ans, 0, 0);
        
        Collections.sort(ans, (a, b) -> {
            if (a[0] == b[0])
                return b[1] - a[1];
            return b[0] - a[0];
            });
            
        return ans.get(0)[1]; 
    }
}