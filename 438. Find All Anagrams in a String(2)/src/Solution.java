import java.util.*;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int S = s.length(), P = p.length();
        List<Integer> res = new LinkedList<>();
        if(S < P) return res;
        char[] chp = p.toCharArray();
        char[] chs = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for(char cp: chp)
            map.put(cp, map.getOrDefault(cp, 0)+1);

        int start = 0, end = 0, unmatchCnt = map.size();
        while( end < S){
            char cur = chs[end];
            if(map.containsKey(cur)){
                int cnt = map.get(cur);
                if(cnt == 1) unmatchCnt--;
                map.put(cur, cnt-1);
            }
            while( unmatchCnt == 0){
                if(end - start + 1 == P)
                    res.add(start);
                char tmp = chs[start];
                if(map.containsKey(tmp)){
                    int cnt = map.get(tmp);
                    if( cnt == 0) unmatchCnt++;
                    map.put(tmp, cnt+1);
                }
                start++;
            }
            end++;
        }
        return res;
    }
    public static void main(String[] args) {
        Solution Launcher = new Solution();
        Launcher.start();
    }

    public void start() {
        System.out.println(findAnagrams("cbaebabacd","abc"));
    }
}

