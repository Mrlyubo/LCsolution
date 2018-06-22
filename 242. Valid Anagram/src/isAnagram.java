import java.util.Arrays;

class Solution {
    //Using FrequencyMap!! 2ms!!
    public boolean isAnagram1(String s, String t) {
        int []chars = new int[26];
        for(char c : s.toCharArray()){
            chars[c-'a']++;
        }
        for(char c: t.toCharArray()){
            chars[c-'a']--;
        }
        for(int i : chars){
            if( i != 0){
                return false;
            }
        }
        return true;
    }

    //Using charArray Sorting, 6ms!
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        char[] chs = s.toCharArray();
        char[] cht = t.toCharArray();
        Arrays.sort(chs);
        Arrays.sort(cht);
        String ss = String.valueOf(chs);
        String tt = String.valueOf(cht);
        return ss.equals(tt);
    }
    public static void main(String[] args) {
        Solution Launcher = new Solution();
        Launcher.start();
    }

    public void start() {

        System.out.println(isAnagram("anagram","nagaram"));
        System.out.println(isAnagram("abc","abb"));
    }
}

