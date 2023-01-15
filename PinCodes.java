/*
 * The PinCodes class takes a given a list of pin codes that can be between 3 - 10 numbers
 * and returns a count of distinct PIN codes using TrieNode.java to manage the PIN codes. 
 * A PIN code is considered a duplicate of another PIN code if it is in the same or reversed order. 
 * Author: Aaron Brengelman
 * Last Modified: 1/13/2023
 */
public class PinCodes {

    public static int solve(String[] codes) {
        TrieNode root = new TrieNode();
        int count = 0;
        for (int x = 0; x < codes.length; x++) {
            String reverse = "";
            for (int y = codes[x].length(); y > 0; y--) {
                reverse = reverse + codes[x].charAt(y - 1);
            }
            if (Integer.parseInt(codes[x]) <= Integer.parseInt(reverse)) {
                if (root.addWord(codes[x])) {
                    count++;
                }
            } else {
                if (root.addWord(reverse)) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String[] set = { "123", "213", "321", "21453", "321", "24513", "33321", "24413", "55555", "55555" };
        System.out.println(solve(set));
        String[] set2 = { "0123", "3210" };
        System.out.println(solve(set2));
    }
}
