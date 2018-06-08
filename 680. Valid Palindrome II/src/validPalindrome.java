class A {
    /**
     * Note: need to check whether i+1 || j-1 will be valid.
     */
       // TwoPointer Approach with helper ,28ms.

        public boolean validPalindrome1(String s) {
            if (s == null || s.length() == 0) {
                return false;
            }
            int i = 0, j = s.length() - 1;
            char[] arr = s.toCharArray();

            while (i < j) {
                if (arr[i] != arr[j]) {
                    return helper(arr, i + 1, j) || helper(arr, i, j - 1);
                }
                i++;
                j--;
            }
            return true;
        }
        private boolean helper(char[] arr, int i, int j) {
            while (i < j) {
                if (arr[i] != arr[j]) {
                    return false;
                }
                i++;
                j--;
            }
            return true;
        }


    //My Approach : TwoPointer 38ms.
    public boolean validPalindrome(String s) {
        char[] c = s.toCharArray();
        int n = s.length();
        int i = 0, j =n-1;
        boolean nodelete = true;
        while (j-i>1){
            if(c[i]==c[j]){
                i++;
                j--;
                continue;
            }
            else if ( c[i+1] == c[j] && nodelete && c[i+2] ==c[j-1]){
                i = i+2;
                j--;
                nodelete = false;
                continue;
            }
            else if ( c[i] == c[j-1] && nodelete && c[i+1] == c[j-2]){
                j = j-2;
                i++;
                nodelete = false;
                continue;
            }
            else
                return false;
        }
        return true;
    }

    public static void main(String [] args){
        A Launcher = new A();
        Launcher.start();
    }
    public void start(){
        String s= "aba",s1 = "abca",s2="dcxbacabcd",
                s3 ="lcupuupucul",s4 = "abc";
        System.out.println( validPalindrome(s));
        System.out.println( validPalindrome(s1));
        System.out.println( validPalindrome(s2));
        System.out.println( validPalindrome(s3));
        System.out.println( validPalindrome(s4));
    }
}
