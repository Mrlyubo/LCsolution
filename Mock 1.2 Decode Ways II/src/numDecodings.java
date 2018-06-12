class A {

    public int numDecodings(String s) {
        char[] chs = s.toCharArray();
        Integer n = chs.length;
        long [] res = new long[n];//long type!!!!

        if(chs[0]  == '*') res[0] = 9;
        else if(chs[0] == '0') return 0; //return directly.
        else res[0] = 1;
        if( n == 1) return (int)res[0];

        for( int i = 1 ;i < n; i++){
            int one;
            if(chs[i]  == '*') one = 9;
            else if(chs[i] == '0') one = 0;
            else one = 1;

            int two;
            if(chs[i-1] == '*') {// chs[i-1] == '*';
                if(chs[i] =='*') two = 15; //  81 is wrong.
                else if (chs[i] <= '6' && chs[i]>= '0') two = 2;
                else two = 1;
            }
            else { // chs[i-1] != '*';
                if(chs[i-1] == '0') two = 0;
                else if(chs[i-1] == '1') {
                    if(chs[i] =='*') two = 9;
                    else two=1;
                }
                else if(chs[i-1] == '2'){
                    if(chs[i] <= '6' && chs[i]>= '0') two = 1;
                    else if(chs[i] =='*') two = 6;
                    else two = 0;
                }
                else two = 0;
            }
            if(i == 1) res[i] = res[i-1]*one + two;
            else       res[i] = res[i-1]*one + res[i-2]*two;
            res[i] %= 1000000007; // mod result in every step.
        }

        return (int)(res[n-1]);
    }
    public static void main(String [] args){
        A Launcher = new A();
        Launcher.start();
    }
    public void start(){
            System.out.println("3:"+numDecodings("123"));
            System.out.println("18:"+numDecodings("1*"));
            System.out.println("20:"+numDecodings("1*1"));
            System.out.println("177:"+numDecodings("1**"));
            System.out.println("0:"+numDecodings("100"));
            System.out.println("0:"+numDecodings("1001"));
            System.out.println("1:"+numDecodings("101"));
            System.out.println("15:"+numDecodings("2*"));
            System.out.println("9:"+numDecodings("*"));
            System.out.println("96:"+numDecodings("**"));
            System.out.println("404:"+numDecodings("*1*1*0"));
            System.out.println("0:"+numDecodings("904"));
            System.out.println("285:"+numDecodings("1*72*"));
            System.out.println("133236775:"+numDecodings("**********1111111111"));
            System.out.println("104671669:"+numDecodings("********************"));
    }
}