import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BSTTest {
    @Test
    /* helper */
    public void basicTest() {
        BST t = new BST();
        t.add(4);
        t.add(1);
        t.add(2);
        t.add(5);
        t.add(6);
        t.add(3);
        t.add(7);
        List<Integer> s = t.inOrderList();
        assertThat(s).containsExactly(1, 2, 3, 4, 5, 6, 7).inOrder();
    }

    @Test
    /*ex. 30 */
    public void minHeightTest() {
        int[] d = new int[] {1, 2, 3};
        assertThat(BST.minHeight(d).inOrderList()).containsExactly(2, 1, 3);
        int[] arr = new int[] {1, 2, 3, 4, 5, 6, 7};
        int h = BST.minHeight(arr).height();
        assertThat(h).isEqualTo((int) (Math.log(7)/Math.log(2)));
        assertThat(BST.minHeight(arr).inOrderList()).containsExactly(4, 2, 6, 1, 3, 5, 7);
    }

    @Test
    /*ex. 32 */
    public void minGreaterThanK() {
        BST<Double> t = new BST();
        t.add(4.0);
        t.add(6.0);
        t.add(2.0);
        t.add(1.0);
        t.add(3.0);
        t.add(5.0);
        t.add(7.0);
        t.add(4.9);
        t.add(4.8);
        t.add(4.7);
        t.add(4.75);
        t.root.setParents();


        assertThat(t.minGreaterThanK(7.0)).isNull();
        assertThat(t.minGreaterThanK(6.0)).isEqualTo(7.0);
        assertThat(t.minGreaterThanK(5.0)).isEqualTo(6.0);
        assertThat(t.minGreaterThanK(4.0)).isEqualTo(4.7);
    }
}