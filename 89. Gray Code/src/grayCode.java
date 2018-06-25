
import java.util.*;
class Solution {
    //^ 异或运算：同0异1.
    // The idea is simple. GrayCode(i) = i^ (i/2).
    public List<Integer> grayCode (int n) {
        List<Integer> result = new LinkedList<>();
        //System.out.println("n:"+n+"   1<<n:"+(1<<n));
        for (int i = 0; i < 1<<n; i++){//1<<n 即 n*2.
            //System.out.println("Decimal：i:"+i+"  ||i>>1:"+(i>>1)+"   ||i^(i>>1):"+(i^(i>>1)));
            //System.out.println("Binary： i:"+Integer.toBinaryString(i)+"  ||i>>1:"+Integer.toBinaryString(i>>1)+"  ||i^ i>>1:"+Integer.toBinaryString(i^(i>>1)));
            result.add(i ^ (i>>1));//i>>1 即 i/2.
        }

        return result;
    }

    public List<Integer> grayCode1(int n) {
        List<String> slist = new ArrayList<>();
        if(n >-1)  slist.add("0");
        if(n > 0)  slist.add("1");

        for(int i = 2; i <= n; i++){
            int len = slist.size();
            for(int j = len-1; j >= 0; j--){
                String tmps = slist.get(j);
                String s0 = "0"+tmps;
                String s1 = "1"+tmps;
                slist.set(j,s0);
                slist.add(s1);
            }
        }
        List<Integer> res= new ArrayList<>();
        for(String s : slist)
            res.add(Integer.parseInt(s,2));
        return res;
    }
    public static void main(String[] args) {
        Solution Launcher = new Solution();
        Launcher.start();
    }

    public void start() {

        System.out.println(grayCode(0));
        System.out.println(grayCode(1));
        System.out.println(grayCode(2));
        System.out.println(grayCode(3));
        //System.out.println(grayCode(4));
    }
}

