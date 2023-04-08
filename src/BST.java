import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BST<Key extends Comparable<Key>> {
    public Node root;             // root of BST

    public static class Node<Key extends Comparable<Key>> implements Comparable<Node<Key>> {
        private Key key;       // sorted by key
        private Node<Key> parent, left, right;    // left and right subtrees
        public Node() {
            key = null;
            parent = null;
            left = null;
            right = null;
        }

        public Node(Key data) {
            this.key = data;
            parent = null;
            left = null;
            right = null;
        }
        public boolean isLeaf() {
            return left == null && right ==null;
        }

        public void setParents() {
            if (hasLeft()) {
                left.parent = this;
                left.setParents();;
            } if (hasRight()) {
                right.parent = this;
                right.setParents();
            }

        }

        public boolean hasParent() {
            return parent != null;
        }

        public boolean hasLeft() {
            return left != null;
        }

        public boolean hasRight() {
            return right != null;
        }

        @Override
        public int compareTo(Node<Key> o) {
            return key.compareTo(o.key);
        }
    }

    public BST() {
        root = null;
    }
    public BST(Node r) {
        root = r;
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

    /** Ex. 32
     * Given a tree with references to its parent and
     * left/right child, return the smallest key in
     * tree larger than node {@code n}.
     * @param n Node
     * @return smallest value in this tree
     * greater than {@code k}. Null otherwise.
     */
    public Key minGreaterNode(Node<Key> n) {
        if (!n.hasParent() && !n.hasRight()) {
            return null;
        } else {
            if (n.hasParent() && n.key.compareTo(n.parent.key) < 0) {
                return n.parent.key;
            } else {
                Node<Key> next = n;
                if (n.hasRight()) {
                    next = n.right;
                } else {
                    return null;
                }
                while (next.hasLeft()) {
                    next = next.left;
                }
                return next.key;
            }
        }
    }

    public Key smallestKey(Node<Key> b) {
        if (b.right != null) {
            return findSmallestKey(b.right);
        } else {
            if (b.parent == null) {
                return null;
            }
            Node<Key> p = b.parent;
            while (p.compareTo(b) < 0) {
                if (p.parent == null) {
                    return null;
                }
                p = p.parent;
            }
            return p.key;
        }
    }

    public Key findSmallestKey(Node<Key> b) {
        if (b.left==null) {
            return b.key;
        } else {
            return findSmallestKey(b.left);
        }
    }

    /** Ex. 32 helper
     * Find and return node with key {@code k}.
     */
    public Node<Key> search(Node<Key> n, Key k) {
        if (n == null || n.key.compareTo(k) == 0) {
            return n;
        } else if (n.key.compareTo(k) < 0) {
            return search(n.right, k);
        } else {
            return search(n.left, k);
        }
    }


    /**
     * Methods for testing
     */
    public int height() {
        return height(root);
    }
    private int height(Node t) {
        if (t.isLeaf()) {
            return 0;
        } else if (t.right == null) {
            return 1 + height(t.left);
        } else if (t.left == null) {
            return 1 + height(t.right);
        } else {
            return 1 + Math.max(height(t.left), height(t.right));
        }
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

    public void add(Key k) {
        if (root == null) {
            root = new Node(k);
        } else {
            add(root, k);
        }
    }
    private Node add(Node rt, Key key) { // returns root node
        if (rt == null) {
            rt = new Node(key);
        } else if (key.compareTo((Key) rt.key) < 0) {
            rt.left = add(rt.left, key);
        } else if (key.compareTo((Key) rt.key) > 0) {
            rt.right = add(rt.right, key);
        }
        return rt;
    }

    public void add(Node n) {
        if (root == null) {
            root = n;
        } else {
            add(root, n);
        }
    }
    private Node add(Node rt, Node n) { // returns root node
        if (rt == null) {
            rt = n;
        } else if (n.key.compareTo((Key) rt.key) < 0) {
            rt.left = add(rt.left, n);
        } else if (n.key.compareTo((Key) rt.key) > 0) {
            rt.right = add(rt.right, n);
        }
        return rt;
    }
}