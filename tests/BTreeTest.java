import org.junit.jupiter.api.Test;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BTreeTest {
    @Test
    /* Test ex. 26 */
    public void isBalancedTest() {
        BTree t = new BTree();
        BTree.BTNode tn1 = new BTree.BTNode(1, new BTree.BTNode(2, new BTree.BTNode(4), new BTree.BTNode(5)), new BTree.BTNode(3, new BTree.BTNode(6), new BTree.BTNode(7)));
        t.root = tn1;
        assertThat(t.isBalanced()).isTrue();

        BTree.BTNode tn2 = new BTree.BTNode(1, new BTree.BTNode(2, new BTree.BTNode(4, new BTree.BTNode(8), null), new BTree.BTNode(5)), new BTree.BTNode(3, new BTree.BTNode(6), new BTree.BTNode(7)));
        t.root = tn2;
        assertThat(t.isBalanced()).isTrue();

        BTree.BTNode tn3 = new BTree.BTNode(1, new BTree.BTNode(2, new BTree.BTNode(4, new BTree.BTNode(8, new BTree.BTNode(9), null), null), new BTree.BTNode(5)), new BTree.BTNode(3, new BTree.BTNode(6), new BTree.BTNode(7)));
        t.root = tn3;
        assertThat(t.isBalanced()).isFalse();
    }

    @Test
    /* Test ex. 27 */
    public void commonAncestorTest() {
        BTree tree = new BTree();
        BTree.BTNode tn1 = new BTree.BTNode(1);
        BTree.BTNode tn2 = new BTree.BTNode(2);
        BTree.BTNode tn3 = new BTree.BTNode(3);

        tn1.left = tn2;
        tn1.right = tn3;

        tree.root = tn1;

        assertThat(tree.commonAncestor(tn2, tn3)).isEqualTo(tn1);

        BTree.BTNode tn4 = new BTree.BTNode(4);
        BTree.BTNode tn5 = new BTree.BTNode(5);
        BTree.BTNode tn6 = new BTree.BTNode(6);
        BTree.BTNode tn7 = new BTree.BTNode(7);
        BTree.BTNode tn8 = new BTree.BTNode(8);

        tn2.left = tn4;
        tn2.right = tn5;
        tn3.left = tn6;
        tn3.right = tn7;
        tn7.right = tn8;

        tree.root = tn1;

        assertThat(tree.commonAncestor(tn2, tn3)).isEqualTo(tn1);
        assertThat(tree.commonAncestor(tn4, tn5)).isEqualTo(tn2);
        assertThat(tree.commonAncestor(tn6, tn7)).isEqualTo(tn3);
        assertThat(tree.commonAncestor(tn6, tn8)).isEqualTo(tn3);
        assertThat(tree.commonAncestor(new BTree.BTNode(10), tn3)).isEqualTo(tn3);
        assertThat(tree.commonAncestor(new BTree.BTNode(10), new BTree.BTNode(10))).isNull();
        assertThat(tree.commonAncestor(tn5, tn7)).isEqualTo(tn1);
    }

    @Test
    /* Test ex. 31 */
    public void isBSTTest() {
        BTree tree = new BTree();
        BTree.BTNode tn1 = new BTree.BTNode(1);
        BTree.BTNode tn2 = new BTree.BTNode(2);
        BTree.BTNode tn3 = new BTree.BTNode(3);

        tn2.left = tn1;
        tn2.right = tn3;

        tree.root = tn2;

        assertThat(tree.isBST()).isTrue();

        BTree.BTNode tn4 = new BTree.BTNode(4);
        BTree.BTNode tn5 = new BTree.BTNode(5);
        BTree.BTNode tn6 = new BTree.BTNode(6);
        BTree.BTNode tn7 = new BTree.BTNode(7);
        BTree.BTNode tn8 = new BTree.BTNode(8);

        tn1.left = tn2;
        tn1.right = tn3;
        tn2.left = tn4;
        tn2.right = tn5;
        tn3.left = tn6;
        tn3.right = tn7;
        tn7.right = tn8;

        tree.root = tn1;

        tn4.left = tn2;
        tn4.right = tn6;
        tn2.left = new BTree.BTNode(1);
        tn2.right = new BTree.BTNode(3);
        tn6.left = new BTree.BTNode(5);
        tn6.right = new BTree.BTNode(7);

        tree.root = tn4;

        assertThat(tree.isBST()).isTrue();
    }
}