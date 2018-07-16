import java.util.*;

class AutocompleteSystem {
    //TireNode 的结构： childrenMap, countsMap, isWord.
    class TrieNode {
        Map<Character, TrieNode> children;
        Map<String, Integer> counts;
        boolean isWord;
        public TrieNode() {
            children = new HashMap<Character, TrieNode>();
            counts = new HashMap<String, Integer>();
            isWord = false;
        }
    }

    class Pair {
        String s;
        int c;
        public Pair(String s, int c) {
            this.s = s; this.c = c;
        }
    }

    TrieNode root;
    String prefix;

    public AutocompleteSystem(String[] sentences, int[] times) {
        root = new TrieNode();// miss ()
        prefix = "";
        for(int i = 0; i< sentences.length; i++){
            add(sentences[i], times[i]);
        }
    }
    private void add(String s, int count){
        TrieNode curr = root;
        for(char c : s.toCharArray()){
            TrieNode next = curr.children.get(c);
            if(next == null){
                next = new TrieNode();
                curr.children.put(c, next);
            }
            curr = next;
            curr.counts.put(s, curr.counts.getOrDefault(s,0)+count);// miss s
            //注意，每一步都要记录完整的string，这样便于搜索。
        }
        curr.isWord = true;
    }

    public List<String> input(char c) {
        if(c == '#'){
            add(prefix, 1);
            prefix = "";
            return new ArrayList<String>();
        }

        prefix = prefix + c;
        TrieNode curr = root;
        for(char cc : prefix.toCharArray()){
            TrieNode next = curr.children.get(cc);
            if(next == null){
                return new ArrayList<String>();// miss return;
            }
            curr = next;
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> (a.c == b.c ?
         a.s.compareTo(b.s) : b.c - a.c));//
        List<String> res = new ArrayList<>();
        for(String s : curr.counts.keySet()){
            pq.add(new Pair(s, curr.counts.get(s)));
        }
        for(int i = 0; i < 3 && !pq.isEmpty(); i++){
            res.add(pq.poll().s);// miss .s
        }
        return res;
    }

    public static void main(String[] args) {
        String[] s = {"i love you", "island", "iroman", "i love leetcode"};
        int[] times = {5, 3, 2, 2};
        AutocompleteSystem obj = new AutocompleteSystem(s, times);
        System.out.println(obj.input('i'));
        System.out.println(obj.input(' '));
        System.out.println(obj.input('a'));
        System.out.println(obj.input('#'));
    }

}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */