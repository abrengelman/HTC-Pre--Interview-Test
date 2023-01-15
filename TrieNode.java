
/*
 * The TrieNode class is used to create a trie tree to manage adding and the comparing
 * of Strings in a library.
 * Author: Aaron Brengelman
 * Last Modified: 1/13/2023
 */
import java.util.HashMap;

public class TrieNode {
    HashMap<Character, TrieNode> children;
    boolean isWord;

    // Root
    TrieNode() {
        children = new HashMap<Character, TrieNode>();
        isWord = false;
    }

    // Child
    TrieNode(Boolean word) {
        children = new HashMap<Character, TrieNode>();
        isWord = word;
    }

    /**
     * Adds a String to the trie tree that returns true when the added word is new.
     * 
     * @param word String to be added the trie tree
     * @return Boolean that states if the String input was a new word
     */
    Boolean addWord(String word) {
        TrieNode current = this;
        for (char c : word.toCharArray()) {
            if (!current.children.containsKey(c)) {
                current.children.put(c, new TrieNode());
            }
            current = current.children.get(c);
        }
        if (current.getIsWord()) {
            return false;
        }
        current.isWord = true;
        return true;
    }

    HashMap<Character, TrieNode> getChildren() {
        return children;
    }

    Boolean getIsWord() {
        return isWord;
    }

    /**
     * Checks to see if String input starts with another word in the library
     * before calling isEndCompount()
     * 
     * @param word potential compound word to be checked
     * @return Boolean that states if the word is a compound word
     */
    Boolean isCompound(String word) {
        TrieNode current = this;
        // Checks to see if String input starts with another word in the library
        for (int x = 0; x < word.length() && current.getChildren().containsKey(word.charAt(x)); x++) {
            current = current.getChildren().get(word.charAt(x));
            if (current.getIsWord()) {
                if (this.isEndCompound(word.substring(x + 1))) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Navigates through the TrieNodes to determine if the String is another
     * word from the library or contains a library word
     * 
     * @param word (remainder of the potential compound word)
     * @return (Boolean that states whether the word is a compound word)
     */
    private Boolean isEndCompound(String word) {
        TrieNode current = this;
        for (int x = 0; x < word.length(); x++) {
            // If library ends before the string the function returns false.
            if (!current.getChildren().containsKey(word.charAt(x))) {
                return false;
            }
            // If the final TrieNode is a word in the library the function returns true.
            if ((x + 1) == word.length()) {
                return current.getChildren().get(word.charAt(x)).getIsWord();
            }
            // If current TrieNode is a word the function will call recursively to check the
            // second
            // half of the String and return true if the second half of the String is a word
            // or words.
            if (current.getIsWord()) {
                if (this.isEndCompound(word.substring(x + 2))) {
                    return true;
                }
            }
            current = current.getChildren().get(word.charAt(x));

        }
        return false;
    }

}
