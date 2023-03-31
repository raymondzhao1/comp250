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
}
