public class BTree<T> {
    BTNode<T> root;

    public static class BTNode<T> {
        T element;
        BTNode<T> left;
        BTNode<T> right;

        public BTNode(T i) {
            element = i;
            left = null;
            right = null;
        }

        public BTNode(T i, BTNode<T> left, BTNode<T> right) {
            element = i;
            this.left = left;
            this.right = right;
        }
    }

    /** Exercise 26:
     *  Return whether every subtree of BTree is balanced.
     *  A tree is balanced if its subtrees' heights differ
     *  by at most 1.
     */
    public boolean isBalanced(BTree t) {
        return isBalanced(t.root);
    }
    private boolean isBalanced(BTNode t) {
        if (isLeaf(t)) {
            return true;
        }
        return Math.abs(height(t.left) - height(t.right)) <= 1 && isBalanced(t.left) && isBalanced(t.right);
    }

    private int height(BTNode t) {
        if (isLeaf(t)) {
            return 0;
        } else {
            return 1 + Math.max(height(t.left), height(t.right));
        }
    }

    public boolean isLeaf(BTNode t) {
        return t.left == null && t.right == null;
    }

    /** Exercise 27:
     *  Return whether every subtree of BTree is balanced.
     *  A tree is balanced if its subtrees' heights differ
     *  by at most 1.
     */
    public BTNode commonAncestor(BTNode a, BTNode b) {
        return commonAncestor(root, a, b);
    }

    public static BTNode commonAncestor(BTNode t, BTNode a, BTNode b) {
        if (t == a) {

        }
        commonAncestor(t, a, b);
    }

    /** Exercise 28:
     *  Return whether every subtree of BTree is balanced.
     *  A tree is balanced if its subtrees' heights differ
     *  by at most 1.
     */
    public int numSumPaths(BTree t) {
        return numSumPaths(BTNode t.root);
    }
    private int numSumPaths(BTNode t) {
        return 0;
    }

}
