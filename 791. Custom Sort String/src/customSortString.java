import java.util.HashMap;
import java.util.Map;

class Solution {

    /**
     * use int[26] as map is better, even we need to go through 26 character to add the remaining characters.
     */
    public String customSortString(String S, String T) {
        Map<Character, Integer> map = new HashMap<>();

        //Store the frequency of each character in T.
        for(char c : T.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);
        }

        //Build new String According to frequency-map and String S.
        StringBuilder sb = new StringBuilder();
        for(char cc : S.toCharArray() ){
            if(map.containsKey(cc)){
                int n = map.get(cc);
                for(int i = 0; i < n; i++){
                    sb.append(cc);
                }
                map.remove(cc);
            }
        }

        //Write all remaining characters that don't occur in S.
        for(char c: map.keySet()){
            int n = map.get(c);
            for(int i = 0; i < n; i++){
                sb.append(c);
            }
        }

        return sb.toString();

    }
    public static void main(String[] args) {
        Solution Launcher = new Solution();
        Launcher.start();
    }

    public void start() {

        System.out.println(customSortString("cba","abcd"));
        System.out.println(customSortString("cba","abccd"));
    }
}

