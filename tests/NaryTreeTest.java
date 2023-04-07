import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import static com.google.common.truth.Truth.assertThat;

class NaryTreeTest {
    @Test
    /* Test ex. 25 */
    public void levelTest() {
        NaryTree<Integer> t1 = new NaryTree<>(1);
        NaryTree.TreeNode<Integer> t2 = new NaryTree.TreeNode<>(2);
        NaryTree.TreeNode<Integer> t3 = new NaryTree.TreeNode<>(3);
        t1.addChild(t2);
        t1.addChild(t3);
        t2.addChild(4);
        t2.addChild(5);
        t3.addChild(6);
        t3.addChild(7);
        ArrayList<Integer> l1 = new ArrayList<>(List.of(1));
        ArrayList<Integer> l2 = new ArrayList<>(List.of(2, 3));
        ArrayList<Integer> l3 = new ArrayList<>(List.of(4, 5, 6, 7));
        ArrayList<ArrayList<Integer>> exp = new ArrayList<>();
        exp.add(l1);
        exp.add(l2);
        exp.add(l3);
        List<List<Integer>> t = NaryTree.level(t1);
        assertThat(t).isEqualTo(exp);
    }

}