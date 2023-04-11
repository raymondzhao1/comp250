import java.util.ArrayList;
import java.util.List;
import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;

public class NaryTree<T> {
    public TreeNode<T> root;

    public static class TreeNode<T> {
        T element;
        ArrayList<TreeNode<T>> children;

        public TreeNode(T data) {
            element = data;
            children = new ArrayList<>();
        }

        public void addChild(T child) {
            children.add(new TreeNode<>(child));
        }
    }
    public NaryTree(T data) {
        root = new TreeNode<>(data);
        root.children = new ArrayList<>();
    }

    public void addChild(TreeNode<T> child) {
        this.root.children.add(child);
    }

    /**
     * Exercise 25:
     * Return a list of lists where the sublist at each index contains all nodes at the
     * depth corresponding to that index.
     */
    public static <T> List<List<T>> level(NaryTree<T> t) {
        return level(t.root, new ArrayList<>(), 0);
    }

    public static <T> List<List<T>> level(TreeNode<T> t, List<List<T>> res, int level) {
        if (level == res.size()) {
            res.add(new ArrayList<>());
        }
        res.get(level).add(t.element);
        for (TreeNode<T> b : t.children) {
            level(b, res, level + 1);
        }
        return res;
    }
}