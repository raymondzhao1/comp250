public class BTree<T> {
    BTNode root;

    public static class BTNode<T extends Comparable<T>> implements Comparable<BTNode<T>> {
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

        @Override
        public int compareTo(BTNode<T> other) {
            return element.compareTo(other.element);
        }
    }

    /** Exercise 26:
     *  Return whether every subtree of BTree is balanced.
     *  A tree is balanced if its subtrees' heights differ
     *  by at most 1.
     */
    public boolean isBalanced() {
        return isBalanced(root);
    }
    private boolean isBalanced(BTNode t) {
        if (t == null) {
            return true;
        }
        return isBalanced(t.left) && isBalanced(t.right) && Math.abs(height(t.left) - height(t.right)) <= 1;
    }

    /** Exercise 26 Helper:
     * Return the maximum height of a tree, where
     * height is defined as distance from root node.
     */
    private int height(BTNode t) {
        if (t == null) {
            return -1;
        } else if (t.right == null) {
            return 1 + height(t.left);
        } else if (t.left == null) {
            return 1 + height(t.right);
        } else {
            return 1 + Math.max(height(t.left), height(t.right));
        }
    }

    /** Exercise 27:
     *  Return the first common ancestor of two BTNodes.
     *  Assumptions: {@code a} and {@code b} are not the
     *  same, can both be found in this Tree. If only
     *  one of the nodes can be found, that node is returned.
     * @param a any BTNode
     * @param b any BTNode
     * @return the first common ancestor of {@code a} and {@code b}
     * if they both exist in this tree. {@code a} or {@code b} if only
     * {@code a} or {@code b} exist within this tree, respectively.
     * {@code null} if neither {@code a} and {@code b} are in this tree
     */
    public BTNode commonAncestor(BTNode a, BTNode b) {
        return commonAncestor(root, a, b);
    }

    public BTNode commonAncestor(BTNode t, BTNode a, BTNode b) {
        if (t == null) {
            return null;
        } else if (t == a || t == b) {
            return t;
        }

        BTNode foundLeft = commonAncestor(t.left, a, b);
        BTNode foundRight = commonAncestor(t.right, a, b);

        if (foundLeft != null && foundRight != null) {
            return t;
        } else if (foundLeft != null && foundRight == null){
            return foundLeft;
        } else if (foundLeft == null && foundRight != null) {
            return foundRight;
        } else {
            return null;
        }
    }

    /** Exercise 28:
     *  Return whether every subtree of BTree is balanced.
     *  A tree is balanced if its subtrees' heights differ
     *  by at most 1.
     */
    public int numSumPaths(BTree t) {
        return numSumPaths(t.root);
    }
    private int numSumPaths(BTNode t) {
        return 0;
    }

    /** Exercise 31:
     *  Determine whether this BTree is a BST.
     */
    public boolean isBST() {
        return isBST(root);
    }
    private boolean isBST(BTNode t) {
        if (t.left == null && t.right == null) {
            return true;
        }

        int rootToLeft = t.compareTo(t.left);
        int rootToRight = t.compareTo(t.right);

        if (rootToLeft > 0 && rootToRight < 0) {
            return isBST(t.left) && isBST(t.right);
        }
        return false;
    }

}
