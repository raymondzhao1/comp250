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

    public Node add(Key k) {
        return add(root, k);
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

    public BST minHeight(int[] arr) {
        root = minHeight(root, arr);
        return new BST(root);
    }
    private Node minHeight(Node n, int[] arr) {
        return null;
    }
}