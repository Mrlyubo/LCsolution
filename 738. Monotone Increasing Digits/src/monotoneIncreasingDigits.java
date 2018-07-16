class Solution {
    public int monotoneIncreasingDigits(int N) {
        String s = String.valueOf(N);
        char[] chs = s.toCharArray();

        //find the index where is not increasing.
        int pow = 0, i;
        for(i = 0; i < chs.length-1; i++){
            if(chs[i] > chs[i+1]){
                while ( i>0 && chs[i] == chs[i-1])
                    i--;
                pow = chs.length - i -1;
                break;
            }
        }

        // calculate the divider.
        if(pow == 0) return N;
        int d = 1;
        for(int t = 0; t < pow; t++)
            d *= 10;

        // cal the res;
        int mod = N % d;
        return N-mod-1;
    }
    public static void main(String[] args) {
        Solution Launcher = new Solution();
        Launcher.start();
    }

    public void start() {

        System.out.println("1234:"+monotoneIncreasingDigits(1234));
        System.out.println("2233:"+monotoneIncreasingDigits(2233));
        System.out.println("299:"+monotoneIncreasingDigits(322));
        System.out.println("999:"+monotoneIncreasingDigits(1001));
        System.out.println("299:"+monotoneIncreasingDigits(332));
    }
}

