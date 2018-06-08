
class A {

    /**
     * The numDecodings1 is better:
     * 1. Use dp[] instead of dp1[] and dp2[].
     * 2. Use prev and cur instead of ((charAt(i)-'0')*10 + charAt(i+1)-'0')
     * 3. the classification is simpler.
     * @param s
     * @return
     */
    public int numDecodings1(String s) {
        if(s == null || s.length() == 0)
            return 0;
        int len = s.length();
        int[] dp = new int[len+1];
        dp[0] = 1;
        char cur = '#', prev = '#';
        for(int i = 0; i < len; i++) {
            cur = s.charAt(i);
            if(cur == '0') {
                if(!(prev == '1' || prev == '2'))
                    return 0;
                dp[i+1] = dp[i-1];
            } else {
                dp[i+1] = dp[i];
                if(prev == '1' || prev == '2' && cur >= '1' && cur <= '6')
                    dp[i+1] += dp[i-1];
            }
            prev = cur;
        }
        return dp[len];
    }
// My 2ms O(n) Approach.
    public int numDecodings(String s) {


        int n = s.length();
        if( n == 0 ) return 0;
        if(s.charAt(0)=='0') return 0;
        else if( n == 1 )  return 1;

        int[] isComma = new int[n];
        int[] noComma = new int[n];

        int first = (s.charAt(0)-'0')*10+ s.charAt(1)-'0';
        noComma[1] = (first <= 26 )?1:0;
        isComma[1] = ( s.charAt(1)!='0')?1:0;

        for( int i = 1 ; i < n-1; i ++ ){
            int test = (s.charAt(i)-'0')*10 + s.charAt(i+1)-'0';
            if(test == 0) return 0;
            isComma[i+1] =(s.charAt(i+1) != '0')? (isComma[i]+ noComma[i]):0;
            noComma[i+1] = ( test <= 26 )? isComma[i]:0;
        }
        return isComma[n-1]+noComma[n-1];
    }

    public static void main(String [] args){
        A Launcher = new A();
        Launcher.start();
    }
    public void start(){
        String s = "2262", s1 = "12",s2 = "2125332421",s3 = "0", s4 ="70010", s5="10",
                s6 = "27",s7 = "00", s8 = "01", s9 = "100",s10 = "101", s11 = "110", s12 = "230",s13 ="301";

        System.out.println( s+" "+numDecodings(s) );
        System.out.println( s1+" "+numDecodings(s1) );
        System.out.println( s2+" "+numDecodings(s2) );
        System.out.println( s3+" "+numDecodings(s3) );
        System.out.println( s4+" "+numDecodings(s4) );
        System.out.println( s5+" "+ numDecodings(s5) );
        System.out.println( s6+" "+numDecodings(s6) );
        System.out.println( s7+" "+numDecodings(s7) );
        System.out.println( s8+" "+numDecodings(s8) );
        System.out.println( s9+" "+numDecodings(s9) );
        System.out.println( s10+" "+numDecodings(s10) );
        System.out.println( s11+" "+numDecodings(s11) );
        System.out.println( s12+" "+numDecodings(s12) );
        System.out.println( s13+" "+numDecodings(s13) );
    }
}