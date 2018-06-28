class Solution {
    //5ms, beats 100%!. improvement:
    public String solveEquation(String ss) {
        int cst = 0;
        int xf = 0;
        boolean isFactor;
        boolean isRightside = true;
        while (ss.length() > 0) {
            int len = ss.length();
            int s = len - 1;
            int factor;
            if ('0' <= ss.charAt(len - 1) && ss.charAt(len - 1) <= '9')
                isFactor = false;
            else {
                isFactor = true;
                if (s >= 0) s--;
                len--;
            }

            while (s >= 0 && '0' <= ss.charAt(s) && ss.charAt(s) <= '9')
                s--;
            if (s >= 0 && (ss.charAt(s) == '+' || ss.charAt(s) == '-'))
                s--;

            String target = ss.substring(s+1, len);
            if (target.equals("+") || target.equals(""))
                factor = 1;
            else if (target.equals("-"))
                factor = -1;
            else
                factor = Integer.parseInt(target);

            if(isRightside) factor *= -1;
            if(isFactor) xf += factor;
            else cst -= factor;

            if (s > 0 && ss.charAt(s) == '='){
                isRightside = false;
                s--;
            }
            ss  = ss.substring(0, s+1);
        }
        if(xf == 0 && cst == 0) return "Infinite solutions";
        else if(xf == 0 && cst != 0) return "No solution";
        else return "x="+(cst/xf);
    }


    //其他思路：* sign.
    public String solveEquation1(String equation) {
        int a = 0;
        int b = 0;
        int sign = 1;

        int n = equation.length();
        int i = 0;
        int j = 0;

        while (j < n) {
            char c = equation.charAt(j);
            if (c == '+' || c == '-') {
                if (j > i) {
                    b += Integer.parseInt(equation.substring(i, j)) * sign;
                }
                i = j;
            }
            else if (c == 'x') {
                if (i == j || equation.charAt(j - 1) == '+') {
                    a += sign;
                }
                else if (equation.charAt(j - 1) == '-') {
                    a -= sign;
                }
                else {
                    a += Integer.parseInt(equation.substring(i, j)) * sign;
                }
                i = j + 1;
            }
            else if (c == '=') {
                if (j > i) {
                    b += Integer.parseInt(equation.substring(i, j)) * sign;
                }
                sign = -1;
                i = j + 1;
            }
            j++;
        }
        if (i < n) {
            b += Integer.parseInt(equation.substring(i)) * sign;
        }

        if (a == 0 && b == 0) {
            return "Infinite solutions";
        }
        else if (a == 0 && b != 0) {
            return "No solution";
        }
        else {
            return "x=" + (-b / a);
        }

    }
    public static void main(String[] args) {
        Solution Launcher = new Solution();
        Launcher.start();
    }

    public void start() {
/*        System.out.println(solveEquation("x+5-3+x=6+x-2"));
        System.out.println(solveEquation("x=x"));
        System.out.println(solveEquation("2x=x"));
        System.out.println(solveEquation("2x+3x-6x=x+2"));
        System.out.println(solveEquation("x=x+2"));*/
        System.out.println(solveEquation("x=100"));
    }
}

