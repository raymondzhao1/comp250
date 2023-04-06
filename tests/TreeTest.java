import org.checkerframework.checker.units.qual.A;
import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class TreeTest {
    @Test
    /* Test ex. 25 */
    public void levelTest() {
        Tree<Integer> t1 = new Tree<>(1);
        Tree.TreeNode<Integer> t2 = new Tree.TreeNode<>(2);
        Tree.TreeNode<Integer> t3 = new Tree.TreeNode<>(3);
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
        List<List<Integer>> t = Tree.level(t1);
        assertThat(t).isEqualTo(exp);
    }

}