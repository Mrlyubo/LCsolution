
class A {
    public String addBinary(String a, String b) {
         int sum;
         int x , y , carry=0;
         StringBuilder sb = new StringBuilder();
         int diff = a.length()-b.length();

         for(int i = a.length()-1;i >= 0|| i - diff >= 0;i--) {
             x = (i >= 0 ) ? a.charAt(i)-'0' : 0;
             y = ( i - diff >= 0) ? b.charAt(i-diff)-'0' : 0;
             sum = x + y + carry;
             if(sum >1){
                 carry = 1;
                 sum = sum-2;
             }
             else
                 carry = 0;

             sb.insert(0,sum);
         }
         if(carry == 1) sb.insert(0,carry);

         return sb.toString();
    }

    public static void main(String [] args){
        A Launcher = new A();
        Launcher.start();
    }
    public void start(){
        String a = "1010", b = "1011"; // res = 10101 ;
        String a1 = "10011",b1 = "11"; // res = 10110;
        String a2 = "11", b2 = "111";// res = 1010;
        System.out.println( addBinary(a2,b2) );
    }
}