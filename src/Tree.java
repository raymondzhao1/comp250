import java.util.ArrayList;
import java.util.List;
import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;

public class Tree<T> {
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

        public List<List<T>> level(List<List<T>> res, int level) {
            if (level == res.size()) {
                res.add(new ArrayList<>());
            }
            res.get(level).add(element);
            for (TreeNode<T> b : children) {
                b.level(res, level + 1);
            }
            return res;
        }
    }
    public Tree(T data) {
        root = new TreeNode<>(data);
        root.children = new ArrayList<>();
    }

    public void addChild(TreeNode<T> child) {
        this.root.children.add(child);
    }

    /** Exercise 25:
     * Return a list of lists where the sublist at each index contains all nodes at the
     * depth corresponding to that index.
     */
    public List<List<T>> level() {
        return root.level(new ArrayList<>(), 0);
    }
}