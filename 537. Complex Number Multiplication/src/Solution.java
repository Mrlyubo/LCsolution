class Solution {

    // Also, we can use : int plusB = b.indexOf("+");
    public String complexNumberMultiply(String a, String b) {
        a = a.substring(0,a.length()-1);
        b = b.substring(0,b.length()-1);
        String[] A = a.split("\\+");
        String[] B = b.split("\\+");
        int A0 = Integer.parseInt(A[0]);
        int A1 = Integer.parseInt(A[1]);
        int B0 = Integer.parseInt(B[0]);
        int B1 = Integer.parseInt(B[1]);
        //System.out.println("A0:"+A0+"A1:"+A1+"B0:"+B0+"B1:"+B1);
        int cstE = A0*B0-A1*B1;
        //System.out.print("cstE="+cstE);
        int iE = A0*B1+A1*B0;
        //System.out.print("iE="+iE);
        StringBuilder sb = new StringBuilder();
        sb.append(cstE+"+"+iE+"i");
        return sb.toString();
    }
    public static void main(String[] args) {
        Solution Launcher = new Solution();
        Launcher.start();
    }

    public void start() {
        System.out.println("0+2i:"+complexNumberMultiply("1+1i", "1+1i"));
        System.out.println("0+-2i:"+complexNumberMultiply("1+-1i", "1+-1i"));
        System.out.println("1+0i:"+complexNumberMultiply("1+0i", "1+0i"));
    }
}

