import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int firstUniqChar(String s) {
        char[] chs = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < chs.length; i++){
            char c = chs[i];
            if(map.containsKey(c))
                map.put(c,-1);
            else
                map.put(c, i);
        }
        for(char c : map.keySet()){
            int curres = map.get(c);
            if(curres != -1){
                res = Math.min(res,curres);
            }
        }
        return res == Integer.MAX_VALUE ? -1: res;
    }

    /**
     *1.Get the frequency of each character.
     *2.Get the first character that has a frequency of one.
     */
    public int firstUniqChar1(String s) {
            int freq [] = new int[26];
            for(int i = 0; i < s.length(); i ++)
                freq [s.charAt(i) - 'a'] ++;
            for(int i = 0; i < s.length(); i ++)
                if(freq [s.charAt(i) - 'a'] == 1)
                    return i;
            return -1;
    }

    public static void main(String[] args) {
        Solution Launcher = new Solution();
        Launcher.start();
    }

    public void start() {
        System.out.println("0:"+firstUniqChar("leetcode"));
        System.out.println("2:"+firstUniqChar("loveleetcode"));
        System.out.println("0:"+firstUniqChar("l"));
        System.out.println("-1:"+firstUniqChar(""));
        System.out.println("-1:"+firstUniqChar("aa"));
        System.out.println("0:"+firstUniqChar("ab"));
        System.out.println("2:"+firstUniqChar("aab"));
    }
}

