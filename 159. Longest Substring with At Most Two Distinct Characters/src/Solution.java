import java.util.HashMap;
import java.util.Map;

class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int S = s.length();
        char[] chs = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int start = 0, end = 0, count = 0, res =0;
        while ( end < S ){
            char cur = chs[end];
            int cnt = map.getOrDefault(cur,0);
            if(cnt == 0) count++;
            map.put(cur, cnt+1);

            while (count > 2){
                char tmp = chs[start];
                if(map.containsKey(tmp)){
                    int tmpcnt = map.get(tmp);
                    if(tmpcnt == 1) count--;
                    map.put(tmp,tmpcnt-1);
                }
                start++;
            }
            res = Math.max(res, end - start + 1);
            end++;
        }
        return res;
    }
    public static void main(String[] args) {
        Solution Launcher = new Solution();
        Launcher.start();
    }

    public void start() {
        System.out.println("3:"+lengthOfLongestSubstringTwoDistinct("eceba"));
        System.out.println("5:"+lengthOfLongestSubstringTwoDistinct("ccaabbb"));
    }
}

