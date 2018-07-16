import java.util.*;

class AutocompleteSystem {
    // This MapEntry works better because the complete sentences will be less than 100,
    // no need to use TrieNode.
    // However, the startsWith method is kind of cheating. It is so simple.
    private Map<String, Integer> map = new HashMap<>();
    private StringBuilder build = new StringBuilder ();
    private List<Map.Entry<String, Integer>> answers = new ArrayList<> ();

    public AutocompleteSystem(String[] sentences, int[] times) {
        for (int idx = 0; idx < sentences.length; idx ++)
            map.put (sentences [idx], times [idx]);
    }

    public List<String> input(char c) {
        List<String> ans = new ArrayList<>();
        if (c == '#') {
            map.put (build.toString (), map.getOrDefault (build.toString (), 0) + 1);
            build.setLength (0);
            answers.clear();
        } else {
            build.append (c);
            if (build.length () == 1) { // pick mapEntry from the map.
                for (Map.Entry<String, Integer> e : map.entrySet ())
                    if (e.getKey ().startsWith (build.toString ()))
                        answers.add (e);

                Collections.sort
                        (answers,  (a, b) -> (a.getValue() == b.getValue()) ? 
                            a.getKey ().compareTo (b.getKey ()) : b.getValue() - a.getValue());
            } else { // remove mapEntry that is not suitable.
                for (Iterator <Map.Entry <String, Integer>> itr = answers.iterator (); itr.hasNext();)
                    if (!itr.next().getKey().startsWith (build.toString ()))
                        itr.remove ();
            }
            for (int idx = 0; idx < 3 && idx < answers.size(); idx ++)
                ans.add (answers.get (idx).getKey ());
        }
        return ans;
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