class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int length = s.length();
        if(length == 0 || s == null) return false;
        boolean repeated = false;
        for(int l = 1; l < length; l++){
            String firstS = s.substring(0, l);
            if(length % l != 0)
                continue;
            int n = length/l;
            repeated = true;
            for(int i = 1; i < n; i++){
                String testS = s.substring(l*i,l*(i+1));
                if(!testS.equals(firstS))
                    repeated =  false;
            }
            if(repeated)
                return repeated;
        }
        return repeated;
    }

    public boolean repeatedSubstringPattern1(String str) {
        int l = str.length();
        for(int i=l/2;i>=1;i--) {
            if(l%i==0) {
                int m = l/i;
                String subS = str.substring(0,i);
                StringBuilder sb = new StringBuilder();
                for(int j=0;j<m;j++) {
                    // when we find the first String, use StringBuilder to build the entire String.
                    sb.append(subS);
                }
                if(sb.toString().equals(str)) return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Solution Launcher = new Solution();
        Launcher.start();
    }

    public void start() {

        System.out.println("True:"+repeatedSubstringPattern("abab"));
        System.out.println("False:"+repeatedSubstringPattern("aba"));
        System.out.println("True:"+repeatedSubstringPattern("abcabcabcabc"));
    }
}

