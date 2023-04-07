import java.util.ArrayList;
import java.util.List;

public class BST<Key extends Comparable<Key>> {
    private Node root;             // root of BST

    public static class Node<Key> {
        private Key key;       // sorted by key
        private Node left, right;    // left and right subtrees

        public Node(Key data) {
            this.key = data;
        }
    }

    public BST() {
        root = null;
    }
    public BST(Node r) {
        root = r;
    }

    public void add(Key k) {
        if (root == null) {
            root = new Node(k);
        }
        add(root, k);
    }
    private Node add(Node rt, Key key) { // returns root node
        if (rt == null) {
            rt = new Node(key);
        } else if (key.compareTo((Key) rt.key) < 0) {
            rt.left = add(root.left, key);
        } else if (key.compareTo((Key) rt.key) > 0) {
            rt.right = add(rt.right, key);
        }
        return rt;
    }

    /** Ex. 30
     * Recursively construct a BST of minimum height
     * given a sorted array.
     */
    public static BST minHeight(int[] arr) {;
        return new BST(minHeight(arr, 0, arr.length));
    }
    private static Node minHeight(int[] arr, int start, int end) {
        if (start == end) {
            return null;
        }
        int mid = (start + end) / 2;
        Node n = new Node(arr[mid]);
        n.left = minHeight(arr, start, mid);
        n.right = minHeight(arr, mid + 1, end);
        return n;
    }
    public List<Key> inOrderList() {
        List<Key> res = inOrderList(root);
        while (res.remove(null)){
            int x;
        }
        return res;
    }
    private List<Key> inOrderList(Node n) {
        ArrayList<Key> s = new ArrayList<>();
        if (n == null) {
            s.add(null);
            return s;
        }
        s.addAll(inOrderList(n.left));
        s.add((Key) n.key);
        s.addAll(inOrderList(n.right));
        return s;
    }

    public int height() {
        return height(root);
    }
    private int height(Node t) {
        if (t.left == null && t.right == null) {
            return 0;
        } else if (t.right == null) {
            return 1 + height(t.left);
        } else if (t.left == null) {
            return 1 + height(t.right);
        } else {
            return 1 + Math.max(height(t.left), height(t.right));
        }
    }
}