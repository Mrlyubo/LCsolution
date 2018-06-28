import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    //牛逼解法： 7ms Chars-Count-Map.
    public String frequencySort(String s) {
        char[] chars = s.toCharArray();
        int[] charsCount = new int[128];
        for (char c: chars) charsCount[c]++;
        char[] ret = new char[chars.length];
        int retIndex = 0;
        while (retIndex < ret.length) {//O(n) 128*length + length.
            int maxCount = 0;
            char maxChar = 0;
            for (int i = 0; i < 128; i++) {// 128 times;
                if (charsCount[i] > maxCount) {
                    maxCount = charsCount[i];
                    maxChar = (char) i;
                }
            }
            charsCount[maxChar] = 0;
            while (maxCount-- > 0) // length times in all.
                ret[retIndex++] = maxChar;
        }
        return new String(ret); // Array to String!!!!!!!!!!!!!!!
    }

    // 我的解法：32ms.
    public String frequencySort1(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] chs = s.toCharArray();
        for(char c : chs)
            map.put(c, map.getOrDefault(c, 0)+1);

        int n = chs.length;
        List<Character>[] frq = new ArrayList[n+1]; // No <> for generic Array.
        for(char c1: map.keySet()){
            if(frq[map.get(c1)] == null)
                frq[map.get(c1)] = new ArrayList<>();
            frq[map.get(c1)].add(c1);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = n; i >= 0; i--){
            if ( frq[i] == null)
                continue;
            for(char cc : frq[i])
                for(int j = 0 ; j < i; j++)
                    sb.append(cc);
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        Solution Launcher = new Solution();
        Launcher.start();
    }

    public void start() {
        System.out.println(frequencySort("tree"));
    }
}

