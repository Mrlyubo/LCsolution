import java.util.LinkedList;


/**Method might be useful:
 * s.toLowerCase()
 * s.isLowerCaseAndToUpperCase();
 * s.isLetterOrDigit();
 * s.reverse();
 * s.equals();
 */



class A {
    /**
     * Pretty Two Pointer 7ms Solution  .
     */
    public boolean isPalindrome1(String s) {
        int i = 0;
        int j = s.length() - 1;
        char[] c = s.toCharArray();
        while (i < j) {
            while (i < s.length() && !valid(c[i])) i++;
            while (j >= 0 && !valid(c[j])) j--;
            if (i < j && Character.toLowerCase(c[i]) != Character.toLowerCase(c[j])) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public boolean valid(char c) {
        return (c >= 'a' && c <= 'z') ||
               (c >= 'A' && c <= 'Z') ||
               (c >= '0' && c <= '9');
    }

    //My Approach : LinkedList, 11ms.
    public boolean isPalindrome(String s) {// The readability is not as good as the method above.
        char[] cc= s.toCharArray();//String -> CharArray, 13ms->11ms.
        LinkedList<Integer> schar = new LinkedList<>();
        for(int i = 0; i < s.length(); i++ ){
            char c = cc[i];
            if(c <= 57 && c >=48 || c <=122 && c>= 97)
                schar.add(c+0);
            else if( c <=90 && c >= 65)
                schar.add( c+32 );
        }
        //System.out.println(schar.toString());
        while (schar.size() >1){
            if(schar.removeFirst() != schar.removeLast())
               return false ;
        }
        return true;
    }

    public static void main(String [] args){
        A Launcher = new A();
        Launcher.start();
    }
    public void start(){
        String s = "A man, a plan, a canal: Panama";
        System.out.println( isPalindrome(s) );
    }
}