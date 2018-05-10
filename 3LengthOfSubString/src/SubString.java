import java.util.HashSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
class Substring {

    public int lengthOfLongestSubstring1(String s) {

        int j = 0;
        int res = 0;
        for(int i = 0; i < s.length(); i += 1) { //i += j will get wrong answer when input "dvdf".
            HashSet<Character> prevseen = new HashSet<>();// <char> is not allowed.
            for (j = i; j < s.length(); j += 1) {
                if (prevseen.contains(s.charAt(j))) {
                    break;
                }
                prevseen.add(s.charAt(j));

            }
            res = Math.max(j-i,res);

        }
        return res;

    }


    /**Aproach #2 : Sliding Window*/

     public int lengthOfLongestSubstring2(String s) {
     int n = s.length();
     Set<Character> set = new HashSet<>();
     int ans = 0, i = 0, j = 0;
     while (i < n && j < n) {
     // try to extend the range [i, j]
     if (!set.contains(s.charAt(j))){
         set.add(s.charAt(j++));
         ans = Math.max(ans, j - i);
     }
     else {
             set.remove(s.charAt(i++));
         }
     }
     return ans;
     }

    /**Aproach #3 : Sliding Window [Optimized]*/
    public int lengthOfLongestSubstring3(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
                //where i SKIP directly to the next position of repeated char(j),
                //the position is recorded in Map,instead of increasing l by 1.
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }
    /**Aproach #4 : Sliding Window [Optimized]*/
    public int lengthOfLongestSubstring4(String s) {
        int n = s.length(), ans = 0;
        int[] index = new int[128]; // current index of character,int[128] for ASCII
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);//SKIP according to Map.
            ans = Math.max(ans, j - i + 1);//Update the length of Window;
            index[s.charAt(j)] = j + 1;//Map
        }
        return ans;
    }
    public static void main(String[] args) {
        Substring Launcher = new Substring();
        Launcher.start();
    }

    public void start() {

        System.out.println(lengthOfLongestSubstring4("dvcrdf"));
        System.out.println(lengthOfLongestSubstring1("aaaaaaxyzuvwaaaaaaaaabcdefghijklmnaaaaaaaxyaaaaaaaaa"));
        System.out.println(lengthOfLongestSubstring1("abcabc"));
        System.out.println(lengthOfLongestSubstring2("pwwkew"));
        System.out.println(lengthOfLongestSubstring3("dvdf"));
    }
}
