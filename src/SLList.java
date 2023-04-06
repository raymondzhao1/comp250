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

    /** Exercise 15:
     * Mutate this Linked List in place such that no
     * duplicates exist.
    */
    public void remove_duplicates() {
        if (head.next == null) {
            return;
        }

        Node<T> curr = head;

        while (curr != null) {
            Node nxt = curr.next;
            T currItem = curr.item;
            Node beforeNxt = curr;
            while (nxt != null) {
                if (nxt.item.equals(currItem)) {
                    Node tmp = nxt.next;
                    remove(beforeNxt, nxt);
                    nxt = tmp;
                }
                else {
                    beforeNxt = beforeNxt.next;
                    nxt = nxt.next;
                }
            }
            curr = curr.next;
        }
    }

    /** Exercise 16:
     * Mutate this integer Linked List such that all items
     * less than x are in the front of the list and all items
     * greater than x are in the back of the list in O(N).
     * This implementation mutates in place (constant memory).
    */
    public void make_partition(int x) {
        if (head.next == null) {
            return;
        }

        Node curr = head.next;
        Node prev = head;

        while (curr != null) {
            if ((Integer) curr.item < x) {
                addFirst(remove(prev, curr));
                curr = prev.next;
            }
            else {
                curr = curr.next;
                prev = prev.next;
            }
        }
    }

    /** Exercise 15 & 16 Helper:
     * Add Node {@code n} to the front of this SLList.
    */
    public void addFirst(Node n) {
        n.next = head;
        head = n;
    }

    /** Exercise 15-16 Helper:
     * Remove and return Node {@code curr} from this SLList.
     * Corrects affected pointers.
    */
     public Node remove(Node prev, Node curr) {
        if (curr.next == null) {
            prev.next = null;
            return curr;
        } else {
            prev.next = curr.next;
        }
        return curr;
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
    public static SLList intersect(SLList s, SLList t) {
        HashSet<Node> seen1 = new HashSet<>();
        HashSet<Node> seen2 = new HashSet<>();

        SLList res = new SLList<>();

        Node sCopy = s.head;
        Node tCopy = t.head;

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

    /** Exercise 17 Helper:
     */
    private static void newSLL(Node n) {
        Node p = n;
        while (n != null) {
            p.next = n.next;
            n = n.next;
            p = p.next;
        }
    }
}