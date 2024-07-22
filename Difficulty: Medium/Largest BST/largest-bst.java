//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currNode = q.remove();
        
              // Get the curr node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the curr node
                  currNode.left = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the right child for the curr node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException {
    
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine();
            Node root = buildTree(s);
            
            Solution T = new Solution();
            System.out.println(T.largestBst(root));
            
            t--;
        }
    }
}


// } Driver Code Ends


//User function Template for Java

// class Node  
// { 
//     int data; 
//     Node left, right; 
   
//     public Node(int d)  
//     { 
//         data = d; 
//         left = right = null; 
//     } 
// }


class Solution{
    
    // Return the size of the largest sub-tree which is also a BST
    static int largestBst(Node root)
    {
        // Write your code here
        if(isBst(root)) return getSize(root);
        return Math.max(largestBst(root.left), largestBst(root.right));
    }
    static int getSize(Node root){
        if(root == null) return 0;
        return 1+getSize(root.left) + getSize(root.right);
    }
    static boolean isBst(Node root){
        if(root == null) return true;
        else if(root.left != null && maxValue(root.left) >= root.data) return false;
        else if(root.right != null && minValue(root.right) <= root.data) return false;
        else if(isBst(root.left) == false || isBst(root.right) == false) return false;
        else return true;
    }
    static int maxValue(Node root){
        int result = Integer.MIN_VALUE;
        if(root.left != null) result = Math.max(result, maxValue(root.left));
        result = Math.max(result, root.data);
        if(root.right != null) result = Math.max(result, maxValue(root.right));
        return result;
    }
    static int minValue(Node root){
        int result = Integer.MAX_VALUE;
        if(root.left != null) result = Math.min(result, minValue(root.left));
        result = Math.min(result, root.data);
        if(root.right != null) result = Math.min(result, minValue(root.right));
        return result;
        
    }
    
}