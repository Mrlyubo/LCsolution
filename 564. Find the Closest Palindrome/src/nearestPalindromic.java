import java.util.*;

public class nearestPalindromic {

    public String nearestPalindromic(String n) {
        Long number = Long.parseLong(n);
        Long high = findHigherPalindrome(number+1);// do not return itself
        Long low = findLowerPalindrome(number-1);// do not return itself
        return Math.abs(number-low) > Math.abs(number - high) ? String.valueOf(high) : String.valueOf(low);
    }

    public Long findHigherPalindrome(Long number) {
        String n = String.valueOf(number);
        char[] s = n.toCharArray();
        int m = s.length;
        char[] t = Arrays.copyOf(s, m); // target array.
        //System.arraycopy();

        //change it to standard palindrome.
        for( int i = 0; i < m/2; i++) {
            t[m-1-i] = t[i];
        }

        //change the target array until its the nearest higher palindrome.
        for( int i = 0; i < m; i++ ) {
            if (s[i] < t[i]) {// the target palindrome is higher, simply return it.
                return Long.parseLong(String.valueOf(t));
            } else if (s[i] > t[i]) {
                for (int j = (m-1)/2; j >= 0; j--) {
                    if(++t[j] > '9') {//++i will increment the value of i, and then return the incremented value.
                        t[j] = '0';
                    } else {
                        break;
                    }
                }
                //when a char is changed, make it palindrome again immediately for later comparision.
                for( int k = 0; k < m/2; k++) {
                    t[m-1-k] = t[k];
                }
                return Long.parseLong(String.valueOf(t));
            }
        }
        return Long.parseLong(String.valueOf(t));
    }

    public Long findLowerPalindrome(Long number) {
        String n = String.valueOf(number);
        char[] s = n.toCharArray();
        int m = s.length;
        char[] t = Arrays.copyOf(s, m); // target array.

        //Change it to standard palindrome.
        for( int i = 0; i < m/2; i++) {
            t[m-1-i] = t[i];
        }

        //Change the target array until its the nearest lower palindrome.
        for( int i = 0; i < m; i++ ) {
            if (s[i] > t[i]) {// the target palindrome is higher, simply return it.
                return Long.parseLong(String.valueOf(t));
            } else if (s[i] < t[i]) {
                for (int j = (m-1)/2; j >= 0; j--) {
                    if(--t[j] < '0') {
                        t[j] = '9';
                    } else {
                        break;
                    }
                }
                //System.out.println("lower one: "+ String.valueOf(t));
                //For example, n is '1000', the standard palindrome is '1001'(higher one) ,the lower one '0901'-->'999'
                if (t[0] == '0') {
                    char[] a = new char[m - 1];
                    Arrays.fill(a, '9');
                    return Long.parseLong(String.valueOf(a));
                }

                //when a char array is changed, make it palindrome again immediately for later comparision.
                for( int k = 0; k < m/2; k++) {
                    t[m-1-k] = t[k];
                }
                return Long.parseLong(String.valueOf(t));
            }
        }
        return Long.parseLong(String.valueOf(t));
    }

    public static void main(String[] args) {
        nearestPalindromic Launcher = new nearestPalindromic();
        Launcher.start();
    }

    public void start() {
        System.out.println(nearestPalindromic("1000"));
        System.out.println(nearestPalindromic("1343"));
        System.out.println(nearestPalindromic("11"));
    }
}
