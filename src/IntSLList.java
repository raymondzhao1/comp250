public class IntSLList {
    Node head; // head of list

    /* Linked list Node*/
    private class Node {
        int data;
        Node next;

        // Constructor to create a new node
        // Next is by default initialized
        // as null
        Node(int d) {
            data = d;
            next = null;
        }
    }
}