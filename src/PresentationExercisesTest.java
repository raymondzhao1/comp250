import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;

public class PresentationExercisesTest {
    @Test
    /* Test ex. 1 */
    public void isPermTest() {
        String a = "fish";
        String b = "ishf";
        String c = "doga";
        String d = "fishy";
        String e = "shif";
        String f = "yay";
        String g = "ayy";
        assertThat(PresentationExercises.isPerm(a, b)).isTrue();
        assertThat(PresentationExercises.isPerm(a, e)).isTrue();
        assertThat(PresentationExercises.isPerm(e, b)).isTrue();
        assertThat(PresentationExercises.isPerm(a, d)).isFalse();
        assertThat(PresentationExercises.isPerm(b, c)).isFalse();
        assertThat(PresentationExercises.isPerm(c, d)).isFalse();
        assertThat(PresentationExercises.isPerm(f, g)).isTrue();
    }

    @Test
    /* Test ex. 18 */
    public void getUnsortedSectionTest() {
        int[] a = new int[] {1, 5, 1, 2, 3, 6, 5, 7};
        List<Integer> res = PresentationExercises.getUnsortedSection(a);
        assertThat(res.get(0)).isEqualTo(1);
        assertThat(res.get(res.size() - 1)).isEqualTo(6);

        int[] b = new int[] {1, 2, 3, 2, 4, 5, 6, 7};
        res = PresentationExercises.getUnsortedSection(b);
        assertThat(res.get(0)).isEqualTo(2);
        assertThat(res.get(res.size() - 1)).isEqualTo(3);

        int[] c = {2, 4, 6, 7, 9, 8, 12, 15, 5, 13, 18, 20};
        res = PresentationExercises.getUnsortedSection(c);
        assertThat(res.get(0)).isEqualTo(2);
        assertThat(res.get(res.size() - 1)).isEqualTo(9);

    }

    @Test
    /* Test ex. 22 */
    public void AnagramTest() {
        String s1 = "hi";
        assertThat(PresentationExercises.anagram(s1)).containsExactly("hi", "ih");

    }

    @Test
    /* Test ex. 24 */
    public void getLargestTest() {
        int[] a = new int[] {1, 3, 4, 5, 3, 2, 0};
        assertThat(PresentationExercises.getLargestIndex(a)).isEqualTo(3);

        int[] b = new int[] {1, 4, -1, -2};
        assertThat(PresentationExercises.getLargestIndex(b)).isEqualTo(1);

        int[] c = new int[] {-100, -2, -1, 0, 1, 2, 3, 4, -1, -2};
        assertThat(PresentationExercises.getLargestIndex(c)).isEqualTo(7);
    }
}
