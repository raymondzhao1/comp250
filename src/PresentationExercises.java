import java.util.*;

public class PresentationExercises<T> {

    /** Exercise 1:
     * Return two strings are a permutation of one another in N time.
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
    /** Exercise 15:
     * Solution on SLList.java
     * Mutate this Linked List in place such that no
     * duplicates exist.
     */

    /** Exercise 16:
     * Solution on SLList.java
     * Mutate this integer Linked List such that all items
     * less than x are in the front of the list and all items
     * greater than x are in the back of the list in O(N).
     * This implementation mutates in place (constant memory).
     */

    /** Exercise 17:
     * Solution on SLList.java
     * Return the Linked List at the intersection
     * of two Linked Lists by reference.
     */

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

        // For testing purposes only.
        return lst;
    }

    /** Exercise 19:
     * Given a 2D int array {@code arr} sorted in ascending order
     * along its rows n and columns m, search for item {@code i}
     * in O(N + M) time. This algorithm runs in Theta(log(N*M)).
     * @param arr 2D array
     * @return true/false
     */
    public static boolean gridSearch(int[][] arr, int val) {
        return gridSearch(arr, val, 0, arr.length);
    }

    private static boolean gridSearch(int[][] arr, int val, int start, int end) {
        if (start == end) {
            return false;
        }
        int mid = (start + end) / 2;
        int currVal = arr[mid][0];

        if (currVal == val) {
            return true;
        } else if (currVal > val) {
            return linBinarySearch(arr[mid], val, 0, arr[mid].length) || gridSearch(arr, val, start, mid);
        } else {
            return linBinarySearch(arr[mid], val, 0, arr[mid].length) || gridSearch(arr, val, mid + 1, end);
        }
    }

    private static boolean linBinarySearch(int[] s, int val, int start, int end) {
        if (start == end) {
            return false;
        }
        int mid = (start + end) / 2;
        int currVal = s[mid];

        if (currVal == val) {
            return true;
        } else if (currVal > val) {
            return linBinarySearch(s, val, start, mid);
        } else {
            return linBinarySearch(s, val, mid + 1, end);
        }
    }

    /** Exercise 20:
     * Return the number of ways to build a Lego tower
     * of height n using blocks of size 1, 2, 3.
     */
    public static int lego(int n) {
        if (n == 0) {
            return 1;
        } else if (n < 0) {
            return 0;
        } else {
            return lego(n - 3) + lego(n - 2) + lego(n - 1);
        }
    }

    /** Exercise 21:
     * Given sorted array arr, return the index for which arr[i] = i.
     */
    public static int indexValueMatch(int[] arr) {
        return indexValueMatch(arr, 0);
    }
    private static int indexValueMatch(int[] arr, int i) {
        if (i == arr.length) {
            return -1;
        } else if (i == arr[i]) {
            return i;
        } else {
            return indexValueMatch(arr, i + 1);
        }
    }

    /** Exercise 22:
     * Generate a list of all anagrams of s.
    */
    public static List<String> anagram(String s) {
        if (s.length() == 0) {
            List<String> base = new ArrayList<>();
            base.add("");
            return base;
        }
        List<String> res = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            for (String x : anagram(s.substring(0, i) + s.substring(i + 1))) {
                res.add(s.charAt(i) + x);
            }
        }
        return res;
    }

    /** Exercise 23:
     * VV
     * Generate a list of all valid containing all valid combinations
     * of{@code n} n pairs of parentheses.
     */
    public static List<String> valPar(int n) {
        return valPar(n, n);
    }
    private static List<String> valPar(int numLeft, int numRight) {
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
        } else if (currVal < s[mid - 1] && currVal > s[mid + 1]) {
            return getLargestIndex(s, start, mid);
        } else {
            return getLargestIndex(s, mid, end);
        }
    }

    /** Exercise 25:
     * Solution located in NaryTree.java
     * Return a list of lists where the sublist at each index contains all nodes at the
     * depth corresponding to that index.
     */

    /** Exercise 26:
     *  Solution located in BTree.java
     *  Return whether every subtree of BTree is balanced.
     *  A tree is balanced if its subtrees' heights differ
     *  by at most 1.
     */

    /** Exercise 27:
     *  Solution found in BTree.java.
     *  Return first common ancestor of two BTNodes.
     */

    /** Ex. 30
     * Solution found in BST.java
     * Recursively construct a BST of minimum height
     * given a sorted array.
     */

    /** Exercise 31:
     *  Determine whether this BTree is a BST.
     */

    /** Ex. 32
     * Given a tree with references to its parent and
     * left/right child, return the smallest key in
     * tree larger than k.
     */

    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}
