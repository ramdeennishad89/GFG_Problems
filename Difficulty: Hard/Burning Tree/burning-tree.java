//{ Driver Code Starts
//Initial Template for Java


import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class Node {
	int data;
	Node left;
	Node right;

	Node(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}

class GfG {

	static Node buildTree(String str) {

		if (str.length() == 0 || str.charAt(0) == 'N') {
			return null;
		}

		String ip[] = str.split(" ");
		// Create the root of the tree
		Node root = new Node(Integer.parseInt(ip[0]));
		// Push the root to the queue

		Queue<Node> queue = new LinkedList<>();

		queue.add(root);
		// Starting from the second element

		int i = 1;
		while (queue.size() > 0 && i < ip.length) {

			// Get and remove the front of the queue
			Node currNode = queue.peek();
			queue.remove();

			// Get the current node's value from the string
			String currVal = ip[i];

			// If the left child is not null
			if (!currVal.equals("N")) {

				// Create the left child for the current node
				currNode.left = new Node(Integer.parseInt(currVal));
				// Push it to the queue
				queue.add(currNode.left);
			}

			// For the right child
			i++;
			if (i >= ip.length)
				break;

			currVal = ip[i];

			// If the right child is not null
			if (!currVal.equals("N")) {

				// Create the right child for the current node
				currNode.right = new Node(Integer.parseInt(currVal));

				// Push it to the queue
				queue.add(currNode.right);
			}
			i++;
		}

		return root;
	}

	static void printInorder(Node root) {
		if (root == null)
			return;

		printInorder(root.left);
		System.out.print(root.data + " ");

		printInorder(root.right);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		while (t > 0) {
			String s = br.readLine();
			int target = Integer.parseInt(br.readLine());
			Node root = buildTree(s);

			Solution g = new Solution();
			System.out.println(g.minTime(root, target));
			t--;

		}
	}
}



// } Driver Code Ends


//User function Template for Java

class Solution
{
    /*class Node {
    	int data;
    	Node left;
    	Node right;
    
    	Node(int data) {
    		this.data = data;
    		left = null;
    		right = null;
    	}
    }*/
    
   public static int maxDepth(Node node){
		if (node == null)  return 0;
		return 1 + Math.max(maxDepth(node.left), maxDepth(node.right));
	}

	public static int traverse(Node node, int target) {
		
		// base case
		if (node == null)      return 0;
		
		// target found, hence returning distance from it
		if (node.data == target){
		    ans = Math.max(ans, maxDepth(node.right));
		    ans = Math.max(ans, maxDepth(node.left));
		    return 1;
		}
		
		

		int val = traverse(node.left, target);
		
		// (val != 0) means target was found at distance = val
		if (val != 0){
			
			// finding max Depth on right as target was on left
			ans = Math.max(ans, val + maxDepth(node.right));
			return val + 1;
		}

		val = traverse(node.right, target);
		
		// (val != 0) means target was found at distance = val
		if (val != 0){
		    
		    // finding max Depth on left as target was on right
			ans = Math.max(ans, val + maxDepth(node.left));
			return val + 1;
		}

		return 0;
	}

    static int ans;
	public static int minTime(Node root, int target) {
	    
		ans=0;
		traverse(root, target);
		return ans;
    }
}