class A {
    public int romanToInt(String s) {
        int result = 0;
        int prev = 1001;

        for (char c : s.toCharArray()) {
            int curr = 0;
            switch (c) { // switch appear inside the for loop.
                case 'I':
                    curr = 1;
                    break; // use BREAK instead of CONTINUE;
                case 'V':
                    curr = 5;
                    break;
                case 'X':
                    curr = 10;
                    break;
                case 'L':
                    curr = 50;
                    break;
                case 'C':
                    curr = 100;
                    break;
                case 'D':
                    curr = 500;
                    break;
                case 'M':
                    curr = 1000;
                    break;
            }
            // Roman num appear in the order: M…M D…D C…C L…L X…X V…V I…I
            // except in the 6 cases where subtraction is used;
            if (prev < curr) {

                result = result - 2 * prev;
            }
            result += curr;
            prev = curr;
        }
        return result;
    }

    public int romanToInt1(String s) {
        char[] cc= s.toCharArray();
        int res = 0;
        for( int i = 0; i < cc.length; i++){
            if( cc[i] == 'I') {
                if(i!=cc.length-1 && cc[i+1] == 'V'){res = res + 4;i++;continue;}
                else if(i!=cc.length-1 && cc[i+1] == 'X'){res = res + 9;i++;continue;}
                else{res = res + 1;continue;}
            }
            else if (cc[i] == 'V') {res = res + 5;continue;}
            else if( cc[i] == 'X') {
                if(i!=cc.length-1 && cc[i+1] == 'L'){res = res + 40;i++;continue;}
                else if(i!=cc.length-1 && cc[i+1] == 'C'){res = res + 90;i++;continue;}
                else{res = res + 10;continue;}
            }
            else if (cc[i] == 'L') {res = res + 50;continue;}
            else if( cc[i] == 'C') {
                if(i!=cc.length-1 && cc[i+1] == 'D'){res = res + 400;i++;continue;}
                else if(i!=cc.length-1 && cc[i+1] == 'M'){res = res + 900;i++;continue;}
                else{res = res + 100;continue;}
            }
            else if (cc[i] == 'D') {res = res + 500;continue;}
            else if (cc[i] == 'M') {res = res + 1000;continue;}
        }
        return res;
    }

    public static void main(String [] args){
        A Launcher = new A();
        Launcher.start();
    }
    public void start(){
        String s = "III", s1 = "IV", s2 = "IX", s3 ="LVIII",s4 ="MCMXCIV",
               s5= "MMMCMXCIX";
        System.out.println("3:"+romanToInt(s));
        System.out.println("4:"+romanToInt(s1));
        System.out.println("9:"+romanToInt(s2));
        System.out.println("58:"+romanToInt(s3));
        System.out.println("1994:"+romanToInt(s4));
        System.out.println("3999:"+romanToInt(s5));
    }
}