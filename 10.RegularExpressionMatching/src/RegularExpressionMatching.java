
class A {

            /**public boolean isMatch(String s, String p) {
                if(s.isEmpty()) return p.isEmpty();
                boolean first_match = (!s.isEmpty() && (s.charAt(0) == s.charAt(0) ||
                        p.charAt(0) == '.'));
                if( p.length() >= 2 && p.charAt(1) == 'x')
                    return first_match && isMatch( s.substring(1),p) ||
                            isMatch(s,p.substring(2));
                else
                    return first_match && isMatch(s.substring(1),p.substring(1));

            }
            public void F3(int n ){
               if ( n <= 1) return;
                F3(n/2);
                F3(n/2);
                F3(n/2);
               System.out.println("1 "+" ");
                }

    Result[][] memo; */

    public boolean isMatch(String s, String p ) {

        /**boolean[][] dp = new boolean[text.length() + 1][pattern.length() + 1];
        dp[text.length()][pattern.length()] = true;

        for (int i = text.length(); i >= 0; i--){
            for (int j = pattern.length() - 1; j >= 0; j--){
                boolean first_match = (i < text.length() &&
                        (pattern.charAt(j) == text.charAt(i) ||
                                pattern.charAt(j) == '.'));
                if (j + 1 < pattern.length() && pattern.charAt(j+1) == '*'){
                    dp[i][j] = dp[i][j+2] || first_match && dp[i+1][j];
                } else {
                    dp[i][j] = first_match && dp[i+1][j+1];
                }
            }
        }
        return dp[0][0];*/
        boolean[][] dp= new boolean[s.length()+1][p.length()+1];
        dp[s.length()][p.length()] = true;

        for (int i = s.length(); i >= 0 ; i--)
            for (int j = p.length()-1; j >= 0; j--){

                boolean first_match = (i < s.length()&&
                        (s.charAt(i) == p.charAt(j)|| p.charAt(j) == '.'));

                if (j < p.length()-1 && p.charAt(j+1) =='*')
                    dp[i][j] = dp[i][j+2]  || first_match  && dp[i+1][j] ;
                    // j-1< p.length()--> j+2 <= p.length().
                    /** && first ,then ||;
                        As for: first_match && dp[i+1][j],
                        check first_match first, if first_match == true, i < s.length() must be true;
                        i+1 must < = s.length().
                        However, if we write: dp[i+1][j] && first_match ,there will be IndexOutOfBoundsException.
                     */

                else
                    dp[i][j] = first_match && dp[i+1][j+1];

            }
        return dp[0][0];
        /**assume it is match in the end, if the matchness can transfer from the end to the beginning, the
         * whole String s is  match to the patten.
         * there will be two situation can transfer the matchness:
         * 1.*  :if there is a * ,it can transfer the matchness to j-2.
         * 2.no *: if can transfer the matchness to j-1.
         */
    }


    public static void main(String [] args){
        A Launcher = new A();
        Launcher.start();
    }
    public void start(){
        String s1 = "aa", p1 = "a", s2 = "aa", p2 = "a*",
               s3 = "ab", p3 = ".*",
               s4 = "aab", p4 = "c*a*b",
               s5 = "mississippi", p5 = "mis*is*p*.",
               s6 = "", p6 = "*" ;
       // System.out.println(isMatch(s1,p1));
       // System.out.println(isMatch(s2,p2));
       // System.out.println(isMatch(s3,p3));
        System.out.println(isMatch(s4,p4));
       // System.out.println(isMatch(s5,p5));
       // F3(8);
    }
}
