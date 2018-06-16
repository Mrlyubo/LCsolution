import java.util.*;

class Solution {
    public List<Integer> findSubstring(String S, String[] L) {
        List<Integer> res = new LinkedList<>();
        if (L.length == 0 || S.length() < L.length * L[0].length())   return res;
        int N = S.length();
        int M = L.length; // *** length
        int wl = L[0].length();
        Map<String, Integer> map = new HashMap<>(), curMap = new HashMap<>();
        for (String s : L) {
            if (map.containsKey(s))   map.put(s, map.get(s) + 1);
            else                      map.put(s, 1);
        }
        String str = null, tmp = null;
        for (int i = 0; i < wl; i++) {// from 0 to wl.
            int count = 0;  // remark: reset count
            int start = i;
            for (int r = i; r + wl <= N; r += wl) { //*****note: move wl steps instead of 1 step every time!
                str = S.substring(r, r + wl);
                if (map.containsKey(str)) {
                    if (curMap.containsKey(str))   curMap.put(str, curMap.get(str) + 1);
                    else                           curMap.put(str, 1);

                    if (curMap.get(str) <= map.get(str))    count++;
                    while (curMap.get(str) > map.get(str)) {//*******note: it is str instead of tmp.
                        tmp = S.substring(start, start + wl);
                        curMap.put(tmp, curMap.get(tmp) - 1);
                        start += wl;

                        //the same as https://leetcode.com/problems/longest-substring-without-repeating-characters/
                        if (curMap.get(tmp) < map.get(tmp)) count--;

                    }


                    if (count == M) { // almost the same as the part above.
                        res.add(start);
                        tmp = S.substring(start, start + wl);
                        curMap.put(tmp, curMap.get(tmp) - 1);
                        start += wl;
                        count--;
                    }
                }else {
                    curMap.clear();
                    count = 0;
                    start = r + wl;//not contain, so move the start
                }
            }
            curMap.clear();
        }
        return res;
    }
    public static void main(String[] args) {
        Solution Launcher = new Solution();
        Launcher.start();
    }

    public void start() {
        String s = "wordgoodstudentgoodword";
        String[] words = {"word","student"};
        System.out.println(findSubstring(s,words));

        String s1 = "barfoothefoobarman";
        String[] words1 = {"foo","bar"};
        System.out.println(findSubstring(s1,words1));

        String s2 = "wordgoodgoodgoodbestword";
        String[] words2 = {"word","good","best","word"};
        System.out.println(findSubstring(s2,words2));
    }
}

