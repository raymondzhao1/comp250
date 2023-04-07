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
}