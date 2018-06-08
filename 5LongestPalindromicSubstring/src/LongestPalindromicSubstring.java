class A {
    /** To improve its run time ,we can do char[] charS = s.toCharArray();
     *
     */
    public String longestPalindrome(String s) {
        if( s == "") return "";
        int n = s.length();
        int len = 0, start = 0, end = 0, currlen; //len should not be set to 0 inside the for loop.

        for (int c = 0; c < n; c++) {//increse the center point.
            for(int T = 0; T < 2; T++) { // when T = 0 ,the center point is in the char;
                                         // when T = 1 ,the center point between two chars.
                int L = 0, R = T;        // T for loop should be set INSIDE the c for loop.
                while ((c - L) >= 0 && (c + R) < n && s.charAt(c - L) == s.charAt(c + R)) {
                    currlen = R + L + 1;
                    if (currlen > len) { // update len and currlen BEFORE updating the L and R
                        start = c - L;
                        end = c + R;
                        len = end - start + 1;
                    }
                    L++;
                    R++;
                }
            }
        }
        return s.substring(start,end+1);
    }
    public static void main(String [] args){
        A Launcher = new A();
        Launcher.start();
    }
    public void start(){
        String s = "abcddcbabb";
        System.out.print(longestPalindrome(s));
    }
}

