/*
 * The LongestWord class finds the longest compound word in a list that is made up of other words
 * in that same list using a custom built class, TrieNode.java, to implement a trie tree.
 * Author: Aaron Brengelman
 * Last Modified: 1/13/2023
 */
public class LongestWord {

    /**
     * LongestWord() function adds the Array of Strings to a trie tree. Then, after
     * determing
     * whether a String is longer than the current one, it will be checked by
     * .isCompound() fuction
     * to determen if it is a compound word.
     * 
     * @param words An Array of Strings to determin the longest compound word
     * @return String, the longest compound word.
     */
    public static String solve(String[] words) {
        TrieNode root = new TrieNode();
        String longestWord = "";

        for (int x = 0; x < words.length; x++) {
            root.addWord(words[x]);
        }

        for (int x = 0; x < words.length; x++) {
            if (words[x].length() > longestWord.length()) {
                if (root.isCompound(words[x])) {
                    longestWord = words[x];
                }
            }
        }
        return longestWord;
    }

    public static void main(String[] args) {
        String[] set = { "dogcatcher", "mouse", "state", "road", "cat", "catch", "building", "catcher", "chase", "dog",
                "when", "tunnel" };
        System.out.println(solve(set));
    }
}
