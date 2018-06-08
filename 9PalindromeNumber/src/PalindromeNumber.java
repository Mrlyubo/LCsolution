class A {
    public boolean isPalindrome(int x) {
        String s = Integer.toString(x);
        System.out.print( " "+s+ " ");
        int n = s.length();
        int i = 0;

        while( s.charAt(i) == s.charAt(n-i-1) && i < n/2) i++;// i can be n/2.

        if( i >  n/2-1) return true;
        else return false;

    }
    public boolean isPalindrome2(int x) { // reverse the integer and compare.

        int res = 0;
        int orix = x;

        if( x < 0 )  return false;
        while ( x != 0 ){
            res = res * 10 + x % 10;
            x = x / 10;
        }

        if (res > Integer.MAX_VALUE)
            return false;
        if (res == orix)
            return true;
        return false;

    }

    public static void main(String [] args){
        A Launcher = new A();
        Launcher.start();
    }
    public void start(){
        int x = 12345, x1 = 12321, x2 = 123321, x3 = 123421;
        int x5 = -121, x6 = 1, x7 = 0, x4 = 10;
        /**
        System.out.println(isPalindrome(x));
        System.out.println(isPalindrome(x1));
        System.out.println(isPalindrome(x2));
        System.out.println(isPalindrome(x3));
        System.out.println(isPalindrome(x4));
        System.out.println(isPalindrome(x5));
        System.out.println(isPalindrome(x6));
        System.out.println(isPalindrome(x7));
        */
        System.out.println(isPalindrome2(x));
        System.out.println(isPalindrome2(x1));
        System.out.println(isPalindrome2(x2));
        System.out.println(isPalindrome2(x3));
        System.out.println(isPalindrome2(x4));
        System.out.println(isPalindrome2(x5));
        System.out.println(isPalindrome2(x6));
        System.out.println(isPalindrome2(x7));
    }
}