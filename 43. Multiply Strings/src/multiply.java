class A {
    public String multiply(String num1, String num2) {
        int n1 = num1.length(), n2 = num2.length();
        char[] arr1 = num1.toCharArray();
        char[] arr2 = num2.toCharArray();
        int[] arrres = new int[n1+n2];

        for(int j = n2-1; j >= 0; j--){
           int k = 0,carry = 0;
           for(int i = n1-1; i >= 0; i--){
                int multed = (arr1[i]-'0')*(arr2[j]-'0')+ carry;
                int mod = multed % 10;
                carry = multed / 10;
                k = n2-j+n1-i-2;

                int sum = arrres[k] + mod;
                arrres[k] = sum % 10;
                arrres[k+1] += sum /10;
           }
           arrres[k+1] += carry;
        }
        int t = n1+n2-1;
        while ( arrres[t] == 0 && t >0) t--;
        StringBuilder sb = new StringBuilder();
        for(int m = t; m >= 0; m--)
            sb.append(arrres[m]);
        return sb.toString();
    }
    public static void main(String [] args){
        A Launcher = new A();
        Launcher.start();
    }
    public void start(){
        System.out.println("56088: "+multiply("123","456"));
        System.out.println("0: "+multiply("0","0"));
        System.out.println("0: "+multiply("1","0"));
        System.out.println("1: "+multiply("1","1"));
        System.out.println("891: "+multiply("99","9"));
        System.out.println("891: "+multiply("9","99"));
        System.out.println("81: "+multiply("9","9"));
        System.out.println("9801: "+multiply("99","99"));
        System.out.println("99999999980000000001: "+multiply("9999999999","9999999999"));
    }
}