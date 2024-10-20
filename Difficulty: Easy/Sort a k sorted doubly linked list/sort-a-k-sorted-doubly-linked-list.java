//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class DLLNode {
    int data;
    DLLNode next;
    DLLNode prev;

    DLLNode(int val) {
        data = val;
        next = null;
        prev = null;
    }
}

public class Main {
    public static void push(DLLNode tail, int new_data) {
        DLLNode newNode = new DLLNode(new_data);
        newNode.next = null;
        newNode.prev = tail;

        if (tail != null) {
            tail.next = newNode;
        }
    }

    public static void printList(DLLNode head) {
        if (head == null) {
            return;
        }

        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String[] arr = br.readLine().trim().split(" ");
            int k = Integer.parseInt(br.readLine().trim());

            DLLNode head = new DLLNode(Integer.parseInt(arr[0]));
            DLLNode tail = head;

            for (int i = 1; i < arr.length; i++) {
                push(tail, Integer.parseInt(arr[i]));
                tail = tail.next;
            }

            Solution obj = new Solution();
            DLLNode sorted_head = obj.sortAKSortedDLL(head, k);
            printList(sorted_head);
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    public DLLNode sortAKSortedDLL(DLLNode head, int k) {
        // Code here
        if (head == null) return null;  // Handle edge case of empty list

        // Min-Heap to store the first k+1 nodes
        PriorityQueue<DLLNode> pq = new PriorityQueue<>((a, b) -> a.data - b.data);

        // Add the first k+1 elements to the priority queue
        DLLNode current = head;
        for (int i = 0; i <= k && current != null; i++) {
            pq.offer(current);
            current = current.next;
        }

        // Initialize the new sorted DLL with a dummy node
        DLLNode dummy = new DLLNode(0);
        DLLNode tail = dummy;

        // Process the remaining nodes and build the sorted list
        while (!pq.isEmpty()) {
            DLLNode smallest = pq.poll();
            tail.next = smallest;
            smallest.prev = tail;
            tail = tail.next;

            // Add the next element from the original list (if any)
            if (current != null) {
                pq.offer(current);
                current = current.next;
            }
        }

        // Ensure the last node's `next` is set to null
        tail.next = null;

        // Return the new head, skipping the dummy node
        DLLNode sortedHead = dummy.next;
        if (sortedHead != null) sortedHead.prev = null;
        return sortedHead;
    }
}