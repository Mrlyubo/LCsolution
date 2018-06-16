import java.util.HashMap;
import java.util.Map;

class Solution {
    public String minWindow(String s, String t) {
        int S = s.length();
        int T = t.length();
        if(S < T) return "";
        Map<Character ,Integer> map = new HashMap<>();
        char[] chs = s.toCharArray();
        char[] cht = t.toCharArray();
        for(char c:cht)
            map.put(c, map.getOrDefault(c,0)+1 );
        int size = map.size();
        int len = Integer.MAX_VALUE;

        int start = 0, end = 0, unmatchCnt = size, head = 0;
        while( end < S){
            char cur = chs[end];
            if(map.containsKey(cur)){
                Integer count = map.get(cur);
                if(count == 1) unmatchCnt--;
                map.put(cur, count-1);
            }

            while( unmatchCnt == 0){
                if(end - start + 1 < len){
                    head = start;
                    len =  end-start+1;
                }
                char tmp = chs[start];
                if(map.containsKey(tmp)){
                    Integer count = map.get(tmp);
                    if(count == 0) unmatchCnt++;
                    map.put(tmp,count+1);
                }
                start++;
            }
            end++;
        }
        return len == Integer.MAX_VALUE ? "":s.substring(head,head+len);
    }
    public static void main(String[] args) {
        Solution Launcher = new Solution();
        Launcher.start();
    }

    public void start() {

        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(minWindow("a", "a"));
    }
}

