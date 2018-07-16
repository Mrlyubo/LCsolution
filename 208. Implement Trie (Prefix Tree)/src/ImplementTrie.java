import java.util.HashMap;
import java.util.Map;


class Trie {
    Map<Character, Trie> children;
    boolean isWord;

    /** Initialize your data structure here. */

    public Trie(){
        children = new HashMap<>();
        isWord = false;
    }


    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie curr = this;
        char[] chw = word.toCharArray();
        for(char c : chw){
            Trie next = curr.children.get(c);
            if(next == null) {
                next = new Trie();
                curr.children.put(c, next);
            }
            curr = next;
        }
        curr.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie curr = this;
        for(char c : word.toCharArray()){
            Trie next = curr.children.get(c);
            if(next == null){
                return false;
            }
            curr = next;
        }
        return curr.isWord;

    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie curr = this;
        for(char c : prefix.toCharArray()){
            Trie next = curr.children.get(c);
            if(next == null){
                return false;
            }
            curr = next;
        }
        return true;
    }

    public static void main(String[] args){
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println("true:"+trie.search("apple"));   // returns true
        System.out.println("false:"+trie.search("app"));     // returns false
        System.out.println("true:"+trie.startsWith("app")); // returns true
        trie.insert("app");
        System.out.println("true:"+trie.search("app"));     // returns true
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */