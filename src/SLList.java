import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class SLList<T> {
    public Node<T> head;

    public static class Node<T> {
        T item;
        Node<T> next;

        public Node(T i) {
            item = i;
            next = null;
        }
    }

    public void add(T i) {
        if (head == null) {
            head = new Node<>(i);
            return;
        }
        Node<T> p = head;
        while (p.next != null) {
            p = p.next;
        }
        p.next = new Node<>(i);
    }

    public void add(Node<T> n) {
        if (head == null) {
            head = n;
            return;
        }
        Node<T> p = head;
        while (p.next != null) {
            p = p.next;
        }
        p.next = n;
    }

    public List<T> toList() {
        Node<T> s = head;
        List<T> res = new ArrayList<>();
        while (s != null) {
            res.add(s.item);
            s = s.next;
        }
        return res;
    }

    /** Exercise 16:
     * Mutate this integer Linked List such that all items
     * less than x are in the front of the list and all items
     * greater than x are in the back of the list in O(N).
     * This implementation mutates in place (constant memory).
    */
    public void make_partition(int x) {
        return;
    }

    /** Exercise 17:
     * Return the Linked List at the intersection
     * of two Linked Lists by reference.
     * @param s first linked list
     * @param t second linked list
     * @return a reference to the node (if any) where
     * {@code s} and {@code t} contain the same node
     * by reference.
    */
    public static <T> SLList<T> intersect(SLList<T> s, SLList<T> t) {
        HashSet<Node<T>> seen1 = new HashSet<>();
        HashSet<Node<T>> seen2 = new HashSet<>();

        SLList<T> res = new SLList<>();

        Node<T> sCopy = s.head;
        Node<T> tCopy = t.head;

        while (sCopy != null || tCopy != null) {
            seen1.add(sCopy);
            seen2.add(tCopy);

            if (seen1.contains(tCopy)) {
                res.head = tCopy;
                newSLL(tCopy);
                break;
            }

            if (seen2.contains(sCopy)) {
                res.head = sCopy;
                newSLL(sCopy);
                break;
            }

            if (sCopy == null) {
                tCopy = tCopy.next;
            }

            else if (tCopy == null) {
                sCopy = sCopy.next;
            }

            else {
                tCopy = tCopy.next;
                sCopy = sCopy.next;
            }
        }
        return res;
    }
    private static <T> void newSLL(Node<T> n) {
        Node<T> p = n;
        while (n != null) {
            p.next = n.next;
            n = n.next;
            p = p.next;
        }
    }
}