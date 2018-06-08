import java.util.*;

// Note: s="aa",t="aa",ouput: "aa".
class A {

    public String minWindow(String s, String t) {

        int[] map = new int[256];// 256 is will include the special characters.
        char[] sChars = s.toCharArray();// s.toCharArray() can avoid s.charAt(i);
        int counter = 0;
        for(char c: t.toCharArray()){
            map[c]++;
            ++counter;
        }
        int head = 0, tail = 0, front = 0, len = Integer.MAX_VALUE;//use head and tail, don't use i and j.
        while(tail < sChars.length){
            if(map[sChars[tail++]]-- > 0){ // ++ operator is very elegent.
                --counter;
            }
            while(counter == 0){// use count to determine whether the current window is valid.
                if(tail - head < len){
                    len = tail - (front = head);//assign head to front, and head++ won't affect the result.
                }
                if(map[sChars[head++]]++ >= 0){
                    ++counter;
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(front, front+len);
    }
// My Approach
    public String minWindow1(String s, String t) {
        int start=0, end=0,n = s.length(), m = t.length();
        if(n < m) return "";
        boolean hasres = false;
        boolean stilcorrect = false;
        int[] map = new int[128];
        for(int k = 0; k < t.length(); k++){
            map[t.charAt(k)]++;
        }
        int i = 0, j = -1, currlen = n;
        do {
            if(j<n-1) {
                j++;
                map[s.charAt(j)]--;
            }
            int[] sortmap = new int[128];
            System.arraycopy(map,0,sortmap,0,128);
            Arrays.sort(sortmap);
            if(sortmap[127] <= 0 && currlen > j-i){
                start = i;
                end = j;
                currlen = end-start;
                hasres = true;
            }

            while (hasres||j==n-1||stilcorrect){
                map[s.charAt(i)]++;
                i++;// ++ util answer  is not correct;
                System.arraycopy(map,0,sortmap,0,128);
                Arrays.sort(sortmap);
                if(sortmap[127] <= 0 && currlen > j-i) {
                    start = i;
                    end = j;
                    currlen = end - start;
                    hasres = true;
                    stilcorrect = true;
                }
                else {
                    stilcorrect = false;
                    break;
                }
            }
            if( i==n-1 && j ==n-1) break;
        }while (i <= j);
        if(!hasres) return "";
        else return s.substring(start,end+1);
    }
    public static void main(String [] args){
        A Launcher = new A();
        Launcher.start();
    }
    public void start(){
        String s = "ADBECODEBANC", t = "ABC";
        String s1 = "a", t1 = "aa";
        String s2 = "ab", t2 = "b";
        String s3 = "a", t3 = "b";
        String s4 = "ADOBECODEBANC", t4 = "ABC";
        String s5 = "ab", t5 = "A";
        String s6 = "ab", t6 = "a";
        String s7 = "aa", t7 = "aa";
        String s8 = "bba", t8 = "ab";
        String s9 = "aaflslflsldkalskaaa", t9 = "aaa";
        String s10 = "aaflslfaaalsldkalskaa", t10 = "aaa";

        System.out.println( "BANC: "+minWindow(s,t));
        System.out.println( " : "+minWindow(s1,t1));
        System.out.println( "b: "+minWindow(s2,t2));
        System.out.println( " : "+minWindow(s3,t3));
        System.out.println( "BANC: "+minWindow(s4,t4));
        System.out.println( " : "+minWindow(s5,t5));
        System.out.println( "a: "+minWindow(s6,t6));
        System.out.println( "aa: "+minWindow(s7,t7));
        System.out.println( "ba: "+minWindow(s8,t8));
        System.out.println( "aaa: "+minWindow(s9,t9));
        System.out.println( "aaa: "+minWindow(s10,t10));
    }
}