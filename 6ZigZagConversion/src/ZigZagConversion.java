class A {
    public String convert(String s, int numRows) {
        /**
         * Stringbuilder will be faster
         */
        if (numRows == 1 || numRows >= s.length()) {// consider the corner case, including every paras;
            return s;
        }

        int k = 0,x,y;
        int n = s.length();
        int numCols = numRows>1? ((n/(numRows-1))+1) : n;// consider the corner case, including every paras;
        String[][] chars = new String[numCols][numRows];// Not numCols-1 and numRows-1;
            for( x = 0; x < numCols; x ++) {/**Not numCols-1*/
                if (x % 2 == 0)
                    for (y = 0; y < numRows && k != n ; y++) // (k != n) should be here;
                    chars[x][y]=s.substring(k++,k);//Substring will be time consuming;
                else
                    for (y = numRows - 2; y > 0 && k != n; y--)
                    chars[x][y]=s.substring(k++,k);

            }

        String res = "";
        for( int i = 0 ;i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if( chars[j][i] == null)// switch i and j;
                    {continue;}
                res += chars[j][i];
            }
        }
        return res;
    }


    public static void main(String [] args){
        A Launcher = new A();
        Launcher.start();
    }
    public void start(){
        String s = "twckwuyvbihajbmhmodminftgpdcbquupwflqfiunpuwtigfwjtgzzcfofjpydjnzqysvgmiyifrrlwpwpyvqadefmvfshsrxsltbxbziiqbvosufqpwsucyjyfbhauesgzvfdwnloojejdkzugsrksakzbrzxwudxpjaoyocpxhycrxwzrpllpwlsnkqlevjwejkfxmuwvsyopxpjmbuexfwksoywkhsqqevqtpoohpd";
        System.out.print(convert(s,4));
    }
}