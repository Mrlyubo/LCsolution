class A {
    public int myAtoi(String str) {
/** No need to use i ,j ,k for 3 consecutive loop------>just use i.
 *  No need to cast and substring(). ------> int num = str.charAt(i)-'0';
 *  No need to Double.valueOf(). ------> if( r > Integer.MAX_VALUE / 10); r = r*10 + num;
 *  No need to 0x7FFFFFFF or 0x80000000------- >Integer.MAX_VALUE  , Integer.MIN_VALUE.
 *  No need to if else ------->return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
 *  No need to use While -------> use IF , once read a sign ,break and i++;
 */
        int i = 0, k = 0;
        int n = str.length();
        int sign = 1;
        int result = 0;
        String res = "";
        if (n == 0) {
            return 0;
        } else {

            while (i < n) {// skip all the whitespace;
                int p = (int) str.charAt(i);
                if (p == 32) i++;
                else break;
            }


            k = i;
            while (k < n) {// once read a sign, break;  No need to use while, use if.
                int r = (int) str.charAt(k);
                if (r == 45) {
                    sign = sign * (-1);
                    k++;
                    break;
                } else if (r == 43) {
                    k++;
                    break;
                } else break;
            }


            for (int j = k; j < n; j++) {// append the number to String res.
                int q = (int) str.charAt(j);
                if (q >= 48 && q <= 57)
                    res += str.substring(j, j + 1);
                else
                    break;
            }

            if (res == "") return 0; // String  res -> Integer.
            else {

                double ans = Double.valueOf(res);// Handle integer overflow.
                if (ans > 0x7FFFFFFF) {
                    if (sign > 0)
                        return 0x7FFFFFFF;
                    else if (sign < 0)
                        return 0x80000000 * sign;
                }
                else result = (int) ans * sign;

            }
        } return result;
    // end of code.
    }
    public int myAtoi2(String str) {
        int i = 0, sign = 1, r = 0;
        int n = str.length();
        if (n == 0) return 0;

        while (i < n && str.charAt(i) == ' ') {
            i++;
        }

        if (str.charAt(i) == '+' || str.charAt(i) == '-') {
            sign = str.charAt(i) == '+' ? 1 : -1;
            i++;
        }

        while (i < n) {
            int num = str.charAt(i) - '0';// No need to cast.
            if (num < 0 || num > 9) break;

            if (r > Integer.MAX_VALUE / 10 || Integer.MAX_VALUE / 10 == r && Integer.MAX_VALUE % 10 < num) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            r = 10 * r + num;
            i++;

        }

        return sign * r;
    }
    public static void main(String [] args){
        A Launcher = new A();
        Launcher.start();
    }
    public void start(){
        String s = "-+1",s1 = "1+0", s2 = "+4193 with words",
               s3 = "words and 987", s4 ="-91283472332", s5 = "-", s6="",
               s7 = "   -20000000000000000000",s8 = "+-2", s9="2147483648";

        System.out.println( myAtoi2(s) );
        System.out.println( myAtoi(s1) );
        System.out.println( myAtoi(s2) );
        System.out.println( myAtoi(s3) );
        System.out.println( myAtoi(s4) );
        System.out.println( myAtoi(s5) );
        System.out.println( myAtoi(s6) );
        System.out.println( myAtoi(s7) );
        System.out.println( myAtoi(s8) );
        System.out.println( myAtoi(s9) );
    }
}
