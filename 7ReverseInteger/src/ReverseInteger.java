/**
 * Given a 32-bit signed integer, reverse digits of an integer.
 * Example 1:
 *
 * Input: 123
 * Output: 321
 * Example 2:
 *
 * Input: -123
 * Output: -321
 * Example 3:
 *
 * Input: 120
 * Output: 21
 *
 * #1   int -> string -> 0,isNegetive -> reverseString -> reverse int;
 *      Using too much API. and String might be not parsable.
 *      U
 */
class A {
    public int reverse(int x) {
        Integer num = x;
        String s = num.toString();
        String rs = "";
        int len = s.length();
        int i = len-1;
        boolean isNegative = false;
        if(x < 0){
            s = s.replace("-","");
            isNegative = true;
        }
        while( s.substring(i)== "0"){
            s = s.replace("0","");
            i--;
        }

        int currlen = s.length();
        for(int j = currlen-1; j>=0; j--){
                rs += s.substring(j,j+1);
            }

        Long reslong = Long.parseLong(rs);
        if(reslong > Integer.MAX_VALUE){return 0;}

        int res = Math.toIntExact(reslong);
        if(isNegative) res = res*(-1);

        return res;
    }

    /**  Algorithm:
     *   423%10 = 3, 423/10 = 42 ;  3*10 = 30;
     *   42%10 = 2,  42/10 = 4;     (30+2)*10 = 320;
     *   4%10 = 4, 4/10 = 0;        320+4 = 324.
     * @param x
     * @return
     */
    public int reverse1(int x) {
        //long res = 0;
        int res = 0;
        int tail, prevres = 0;
        while( x != 0 ){

            tail = x%10;
            prevres = res;
            res = res*10+tail;
            if(((res-tail)/10) != prevres) return 0;// Handle Integer overflow;`
            //if( res > 0x7FFFFFFF || res < - 0x7FFFFFFF ) return 0;
            x = x/10;

        }
        return res;
        //return (int)res ;
    }
    public static void main(String [] args){
        A Launcher = new A();
        Launcher.start();
    }
    public void start(){
        int x = 1534236469;
        int y = 1230;
        int z = -123;
        System.out.print(reverse1(x));
    }
}
