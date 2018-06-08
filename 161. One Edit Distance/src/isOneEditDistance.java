class A {
    public boolean isOneEditDistance(String s, String t) {

        char[] sarr = s.toCharArray();
        char[] tarr = t.toCharArray();
        int slen = sarr.length, tlen = tarr.length;
        if(Math.abs(slen-tlen)>1 || s.equals(t)){
            return false;
        }

        int cnt = 0;
        for(int i =0,j = 0; i < slen && j < tlen;){
            if(sarr[i] != tarr[j]){
                if(cnt == 1)
                    return false;
                else{
                    cnt++;
                    if(slen < tlen)
                        j++;
                    else if( slen > tlen)
                        i++;
                    else{
                        i++;
                        j++;
                    }
                }
            }
            else{
                i++;
                j++;
            }
        } return true;
    }
    public static void main(String [] args){
        A Launcher = new A();
        Launcher.start();
    }
    public void start(){
        System.out.println("true:"+isOneEditDistance("ab","acb"));
        System.out.println("false:"+isOneEditDistance("ab","acd"));
        System.out.println("flase:"+isOneEditDistance("cab","ad"));
        System.out.println("true:"+isOneEditDistance("1203","1213"));
        System.out.println("true:"+isOneEditDistance("","1"));
        System.out.println("flase:"+isOneEditDistance("",""));
        System.out.println("true:"+isOneEditDistance("A","a"));
        System.out.println("false:"+isOneEditDistance("c","c"));
        System.out.println("true:"+isOneEditDistance("ba","a"));
        System.out.println("flase:"+isOneEditDistance("ba","ab"));
        System.out.println("true:"+isOneEditDistance("abcc","acc"));
        System.out.println("false:"+isOneEditDistance("teacher","treachery"));
    }
}