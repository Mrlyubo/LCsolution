import java.util.*;

public class compareVersion {

    public int compareVersion(String version1, String version2) {


        String[] cv1 = version1.split("\\.");
        String[] cv2 = version2.split("\\.");

//      Otherwise you are splitting on the regex ., which means "any character".
//      Note the double backslash needed to create a single backslash in the regex.

        int len = Math.max(cv1.length, cv2.length);
        int vsum1 = vSum(cv1,len);
        int vsum2 = vSum(cv2,len);

        if(vsum1 == vsum2) return 0;
        else if (vsum1 > vsum2) return 1;
        else return -1;

    }

    public int vSum(String[] str, int len) {

        int vsum = 0;
        int i;
        for(i = 0; i < str.length; i ++ ) {
            int c = Integer.parseInt(str[i]);
            vsum = vsum *10 + c;
        }
        for(int j = i; j < len; j++) {
            vsum = vsum *10;
        }
        return vsum;
    }


    public static void main(String[] args) {
        compareVersion Launcher = new compareVersion();
        Launcher.start();
    }

    public void start() {
/*      System.out.println(compareVersion("0.1","1.1"));
        System.out.println(compareVersion("1.0.1","1"));
        System.out.println(compareVersion("7.5.2.4","7.5.3"));*/
        System.out.println(compareVersion("01","1"));
        System.out.println(compareVersion("1.0","1"));
        System.out.println(compareVersion("1.0.0","1"));
        System.out.println(compareVersion("1.0.1","1"));
        System.out.println(compareVersion("1.0.1","1.0.0.2"));
    }

}
