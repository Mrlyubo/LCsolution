class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] map = new int[128];
        if (s.length() == 0) return 0;
        int res = 0, end = 0, start = 0;
        while( end < s.length()){
            if( map[s.charAt(end)]> start)
                start = map[s.charAt(end)];
            res = Math.max(res, end - start+1);
            map[s.charAt(end)] = end+1;
            end++;
        }
        return res;
    }
    public static void main(String[] args) {
        Solution Launcher = new Solution();
        Launcher.start();
    }

    public void start() {

        System.out.println("1:"+lengthOfLongestSubstring("bbbbb"));
        System.out.println("3:"+lengthOfLongestSubstring("abcabcbb"));
        System.out.println("5:"+lengthOfLongestSubstring("dvcrdf"));
        System.out.println("14:"+lengthOfLongestSubstring("aaaaaaxyzuvwaaaaaaaaabcdefghijklmnaaaaaaaxyaaaaaaaaa"));
        System.out.println("3:"+lengthOfLongestSubstring("abcabc"));
        System.out.println("3:"+lengthOfLongestSubstring("pwwkew"));
        System.out.println("3:"+lengthOfLongestSubstring("dvdf"));
        System.out.println("1:"+lengthOfLongestSubstring("c"));
        System.out.println("2:"+lengthOfLongestSubstring("ab"));
    }
}

