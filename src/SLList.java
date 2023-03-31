public class SLList<T> {
    Node head; // head of list

    /* Linked list Node*/
    private class Node {
        T item;
        Node next;

        // Constructor to create a new node
        // Next is by default initialized
        // as null
        Node(T i) {
            item = i;
            next = null;
        }
    }
}