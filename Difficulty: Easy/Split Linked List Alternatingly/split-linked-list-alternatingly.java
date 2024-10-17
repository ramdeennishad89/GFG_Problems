//{ Driver Code Starts
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

public class Main {
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();

        while (t-- > 0) {
            List<Integer> arr = new ArrayList<>();
            String input = sc.nextLine();
            Scanner ss = new Scanner(input);

            while (ss.hasNextInt()) {
                arr.add(ss.nextInt());
            }

            Node head = new Node(arr.get(0));
            Node tail = head;

            for (int i = 1; i < arr.size(); ++i) {
                tail.next = new Node(arr.get(i));
                tail = tail.next;
            }

            Solution ob = new Solution();
            Node[] result = ob.alternatingSplitList(head);
            printList(result[0]);
            printList(result[1]);
        }

        sc.close();
    }
}

// } Driver Code Ends


// User function Template for Java
/*
struct Node
{
    int data;
    struct Node* next;

    Node(int x){
        data = x;
        next = NULL;
    }

};
*/

class Solution {
    // Function to append a new node with newData at the end of a linked list
   Node[] alternatingSplitList(Node head) {
        Node node1 = head;
        Node node2 = head.next;
        
        Node sol1 = head;
        Node sol2 = head.next;
        
        head = head.next;
        if (head == null) {
            return new Node[]{node1, node2};
        }
        
        head = head.next;
        while (head != null) {
            node1.next = head;
            node1 = node1.next;
            head = head.next;
            if (head != null) {
                node2.next = head;
                node2 = node2.next;
                head = head.next;
            }
        }
        
        node1.next = null;
        node2.next = null;
        
        return new Node[]{sol1, sol2};
    }
}
