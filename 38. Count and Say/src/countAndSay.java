class A {
    public String countAndSay(int n) {
        String s = "1";
        if(n == 1) return "1";
        if(n == 2) return "11";
        for(int i = 2; i <= n; i++)
            s = compress(s);
        return s;
    }

    private String compress(String s){
        int cnt = 1;
        StringBuilder sb =new StringBuilder();
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) == s.charAt(i-1)) cnt ++;
            else {
                sb.append(cnt).append(s.charAt(i - 1));
                cnt =1;
            }
        }
        sb.append(cnt).append(s.charAt(s.length() - 1));
     return sb.toString();
    }
    public static void main(String [] args){
        A Launcher = new A();
        Launcher.start();
    }
    public void start(){
        //System.out.println(countAndSay(1));
        /*System.out.println(countAndSay(2));
        System.out.println(countAndSay(3));
        System.out.println(countAndSay(4));
        System.out.println(countAndSay(5));
        System.out.println(countAndSay(6));
        System.out.println(countAndSay(7));*/
        System.out.println(countAndSay(8));
    }
}