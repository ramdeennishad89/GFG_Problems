/*
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
} */

class Solution {
    public Node sortedInsert(Node head, int data) {
        // code here
        Node newNode = new Node(data);
        Node temp = head; 
        
       
        if(newNode.data < head.data){
            newNode.next = head; 
            
            while(temp.next != head){
                temp = temp.next; 
            }
            
            temp.next = newNode; 
            
            return newNode; 
        }
        
        Node current = head;
        
        while(temp.next!= head && temp.next.data <=data){
            temp = temp.next; 
        }
        newNode.next = temp.next; 
        temp.next = newNode; 
        
        return head; 
    }
}