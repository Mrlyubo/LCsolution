import java.util.Stack;

class Solution {

    public String decodeString(String s) {
        int i = 0;
        StringBuilder res = new StringBuilder();
        Stack<Integer> cntStack = new Stack<>();
        Stack<String> resStack = new Stack<>();
        while ( i < s.length()){
            char cur = s.charAt(i);
            if(Character.isDigit(cur)){
                int end = s.substring(i, s.length()).indexOf("[")+i;
                int cnt = Integer.parseInt(s.substring(i,end));
                cntStack.push(cnt);
                i = end-1;
            }
            else if ( cur == '[' ){
                resStack.push(res.toString());
                res = new StringBuilder();
            }
            else if ( cur == ']' ){
                StringBuilder sb = new StringBuilder(resStack.pop());
                int repeatedTimes = cntStack.pop();
                for(int j = 0; j < repeatedTimes; j++){
                    sb.append(res);
                }
                res = new StringBuilder(sb);
            }
            else {
                res.append(cur);
            }
            i++;
        }
        return res.toString();
    }



    public static void main(String[] args) {
        Solution Launcher = new Solution();
        Launcher.start();
    }

    public void start() {
        //System.out.println(decodeString("3[a]"));

        //System.out.println(decodeString("3[ay2[x]]3[e]"));

        System.out.println(decodeString("100[a]"));

    }
}

