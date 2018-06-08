class B{
    int len = 0, maxLength = 0, init = 0;
    public String longestPalindrome(String s) {
        char[] chars = s.toCharArray();/** change to array will be faster.*/
        len = s.length();
        if (len <= 1) return s;
        for (int i = 0; i < len; i++) {
            i = manacher(chars, i);
        }
        return s.substring(init, init + maxLength);
    }
    public int manacher(char[] chars, int k) {
        int i = k - 1, j = k;
        while (j < len - 1 && chars[j] == chars[j + 1]) j++;
        int nextCenter = j++;// nextCenter = j; j++;
        /** 0 1 (2 3 4 5 6 7) 8 9 10
            b b (a a a a a a) b b a
            Since chars in [2]-[7] are the same, consider them as One Big Center.
            This means the center can be 1 chars,2 chars, or any number of chars.
        */
        while (i >= 0 && j < len && chars[i] == chars[j]) {
            i--;
            j++;
        }
        if (j - i - 1 > maxLength) {
            maxLength = j - i - 1;
            init = i + 1;
        }
        return nextCenter;
    }
    public static void main(String [] args){
        B Launcher = new B();
        Launcher.start();
    }
    public void start(){
        String s = "aaaaababaaaa";
        System.out.print(longestPalindrome(s));
    }
}