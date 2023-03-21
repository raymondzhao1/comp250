import java.util.*;

public class PresentationExercises {

    /** Exercise 1:
     * Return two strings are a permutation of one another.
     * @param a first string
     * @param b second string
     * @return true/false
     */
    public static boolean isPerm(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length(); i++) {
            char c = a.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int matches = 0;
        for (int i = 0; i < a.length(); i++) {
            char c = b.charAt(i);
            if (map.containsKey(c)) {
                matches += 1;
                map.put(c, map.get(c) - 1);
                    if (map.get(c) == 0) {
                        map.remove(c);
                    }
            }
        }
        return matches == a.length();
    }

    /** Exercise 18:
     * Display start and end index of the smallest subsection of {@code s}
     * that is yet to be sorted.
     * Return value is only for testing purposes.
     * @param s array of unsorted ints
     * @return array of start/end index
     */
    public static List<Integer> getUnsortedSection(int[] s) {
        int[] copy = s.clone();
        Arrays.sort(copy);
        List<Integer> lst = new ArrayList<>();
        for (int i = 0; i < s.length; i++) {
            if (s[i] != copy[i]) {
                lst.add(i);
            }
        }
        System.out.println(lst.get(0));
        System.out.println(lst.get(lst.size() - 1));
        return lst;
    }

    /** Exercise 22:
     * Generate a list of all anagrams of s.
    */
    public static List<String> anagram(String s) {
        return null;
    }

    /** Exercise 24:
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
