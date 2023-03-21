import java.util.List;

public class PresentationExercises {
    /*
    Write a recursive method that takes as input a string s and returns a list containing all the anagrams of
    the string s. An anagram is a word formed by rearranging the letters of a different word. For example,
    the word ‘binary’ is an anagram of ‘brainy’. Note that the output list should not contain duplicates. For
    this exercise, it doesn’t matter whether or not the strings formed are valid English words.
    **/
    public static List<String> anagram(String s) {
        return null;
    }

    /** Exercise 24
     * Return index of the 'peak' of an array in log(N) time.
     * The peak occurs when the values in the input list go from increasing to decreasing.
     * Assumption: Input array is size 3 or greater, since the return for a size 2
     * array is non-deterministic.
     */

    public static int getLargestIndex(int[] s) {
        return getLargestIndex(s, 0, s.length);
    }

    private static int getLargestIndex(int[] s, int start, int end) {
        int mid = (start + end) / 2;
        int currVal = s[mid];

        if (currVal > s[mid - 1] && currVal > s[mid + 1]) {
            return mid;
        }

        if (currVal < s[mid - 1] && currVal > s[mid + 1]) {
            return getLargestIndex(s, start, mid);
        }

        else {
            return getLargestIndex(s, mid, end);
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}
