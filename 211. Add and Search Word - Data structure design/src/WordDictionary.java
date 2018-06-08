

class WordDictionary {

    public class TreeNode{
        public TreeNode[] children = new TreeNode[26];
        public String item = "";
    }
    TreeNode root = new TreeNode();
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TreeNode node = root;
        for(char c:word.toCharArray()){
            if(node.children[c-'a'] == null){
                node.children[c-'a'] = new TreeNode();
            }
            node = node.children[c-'a'];
        }
        node.item = "word";
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return match(word.toCharArray(), 0, root );
    }

    public boolean match(char[] chs, int k, TreeNode node){
        if(k == chs.length)
            return !node.item.equals("");
        if(chs[k] != '.'){
            return node.children[chs[k]-'a'] != null
                    && match (chs, k+1, node.children[chs[k]-'a']);
        }else{
            for(int i = 0; i< 26; i++){
                if(node.children[i] != null ){
                    if(match( chs, k+1, node.children[i]))
                        return true;
                }
            }
        }
        return false;
    }



    public static void main(String [] args){
        WordDictionary obj = new WordDictionary();
        obj.addWord("bad");
        obj.addWord("bed");
        obj.addWord("bac");

        System.out.println("false:"+obj.search("pad"));
        System.out.println("true:"+obj.search("bad"));
        System.out.println("true:"+obj.search(".ad"));
        System.out.println("true:"+obj.search("b.."));
    }

}
/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */