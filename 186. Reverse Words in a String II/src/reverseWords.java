class Solution {
    public void reverseWords(char[] str) {
        int n = str.length;

        //1.reverse the whole string.
        reverseStr(str, 0, n-1);
        //System.out.println("str1:"+String.valueOf(str));

        //2. reverse each word;
        int start = 0, end = 0;
        while (end < n){
            if(str[end] !=' ') end++;
            else{
                reverseStr(str,start,end-1);
                end++;
                start = end;
            }
            //System.out.println("str2:"+String.valueOf(str));
        }

        //3.reverse the last word.
        reverseStr(str,start, end-1);
        //System.out.println("str3:"+String.valueOf(str));
    }

    private void reverseStr(char[] str, int s, int e){
        int cen = (s+e+1)/2;
        while (s < cen){
            char old = str[s];
            str[s++] = str[e];
            str[e--] = old;
        }
    }
    public static void main(String[] args) {
        Solution Launcher = new Solution();
        Launcher.start();
    }

    public void start() {
        char[] str = {'t','h','e',' ','s','k','y',' ','i','s',' ','b','l','u','e'};
        reverseWords(str);
        System.out.println(str);

        char[] str1 = {'b','l','u','e'};
        reverseWords(str1);
        System.out.println(str1);

        char[] str2 = {'c'};
        reverseWords(str2);
        System.out.println(str2);

        char[] str3 = {};
        reverseWords(str3);
        System.out.println(str3);

    }
}

