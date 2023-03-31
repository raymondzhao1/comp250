import org.checkerframework.checker.units.qual.A;
import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SLListTest {
    @Test
    /* Test ex. 17 */
    public void intersectTest() {
        SLList<Integer> s = new SLList<>();
        SLList<Integer> t = new SLList<>();
        SLList<Integer> n = new SLList<>();
        SLList.Node<Integer> intersect = new SLList.Node<>(10);
        intersect.next = new SLList.Node<>(11);
        intersect.next.next = new SLList.Node<>(12);
        s.add(1);
        s.add(2);
        s.add(intersect);
        s.add(3);

        t.add(5);
        t.add(6);
        t.add(7);
        t.add(intersect);

        SLList.Node<Integer> hunnid = new SLList.Node<>(100);
        n.add(hunnid);

        SLList<Integer> test = SLList.intersect(s, t);
        assertThat(test.head).isEqualTo(intersect);

        SLList<Integer> empty1 = SLList.intersect(s, n);

        SLList<Integer> empty2 = SLList.intersect(t, n);

        SLList<Integer> t2 = SLList.intersect(n, n);
        assertThat(t2.head).isEqualTo(hunnid);

    }

}