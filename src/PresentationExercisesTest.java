import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;

public class PresentationExercisesTest {
    @Test
    /* Test recursive Anagram method. */
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
