import java.util.*;

class A {


        public String numberToWords(int num) {
            String s = format(num);
            // handle leading space
            if (s.charAt(0) == ' ') {
                return s.substring(1);
            }
            return s;
        }

        public String format(int num) {
            if (num == 0) return "Zero";
            StringBuffer sb = new StringBuffer();
            int bc = num / 1000000000;
            if (bc >= 1) {
                sb.append(format(bc));
                sb.append(" Billion");
                num %= 1000000000;
            }
            bc = num / 1000000;
            if (bc >= 1) {
                sb.append(format(bc));
                sb.append(" Million");
                num %= 1000000;
            }
            bc = num / 1000;
            if (bc >= 1) {
                sb.append(format(bc));
                sb.append(" Thousand");
                num %= 1000;
            }
            bc = num / 100;
            if (bc >= 1) {
                sb.append(format(bc));
                sb.append(" Hundred");
                num %= 100;
            }
            // 20-90
            if (num >= 20) {
                bc = num / 10;
                switch(bc) {
                    case 2: sb.append(" Twenty"); break;
                    case 3: sb.append(" Thirty"); break;
                    case 4: sb.append(" Forty"); break;
                    case 5: sb.append(" Fifty"); break;
                    case 6: sb.append(" Sixty"); break;
                    case 7: sb.append(" Seventy"); break;
                    case 8: sb.append(" Eighty"); break;
                    case 9: sb.append(" Ninety"); break;
                }
                num %= 10;
            }
            // 1-19
            if (num > 0) {
                switch(num) {
                    case 1: sb.append(" One"); break;
                    case 2: sb.append(" Two"); break;
                    case 3: sb.append(" Three"); break;
                    case 4: sb.append(" Four"); break;
                    case 5: sb.append(" Five"); break;
                    case 6: sb.append(" Six"); break;
                    case 7: sb.append(" Seven"); break;
                    case 8: sb.append(" Eight"); break;
                    case 9: sb.append(" Nine"); break;
                    case 10: sb.append(" Ten"); break;
                    case 11: sb.append(" Eleven"); break;
                    case 12: sb.append(" Twelve"); break;
                    case 13: sb.append(" Thirteen"); break;
                    case 14: sb.append(" Fourteen"); break;
                    case 15: sb.append(" Fifteen"); break;
                    case 16: sb.append(" Sixteen"); break;
                    case 17: sb.append(" Seventeen"); break;
                    case 18: sb.append(" Eighteen"); break;
                    case 19: sb.append(" Nineteen"); break;
                }
            }
            return sb.toString();
        }

    public String numberToWords1(int num) {
        if(num ==0) return "Zero";
        LinkedList<String> res = new LinkedList<>();
        String ans ="";
        String[] Units = new String[]{"","One","Two","Three","Four","Five","Six",
                                        "Seven","Eight","Nine","Ten"};
        String[] Tens = new String[]{"","","Twenty","Thirty","Forty","Fifty","Sixty","Seventy",
                                        "Eighty","Ninety"};
        String[] OneTens = new String[]{"Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen",
                                        "Sixteen","Seventeen","Eighteen","Nineteen"};
        int temp =0;
        for(int i = 0 ; num !=0; i++){
            int mod = num%10;
            if(i == 0) {temp = mod;res.addFirst(Units[mod]);}
            else if((i == 1 || i == 4 ||i == 7)&& mod!=1 ) res.addFirst(Tens[mod]);
            else if((i == 1 || i == 4 ||i == 7)&& mod==1 ) {
                res.removeFirst();
                res.addFirst(OneTens[temp]);
            }
            else if(i == 2 || i == 5 ||i == 8 ) {
                if(mod !=0) res.addFirst("Hundred");
                res.addFirst(Units[mod]);
            }
            else if(i == 3) {
                temp = mod;
                if(num > 0 && num <1000 || num%1000 !=0) res.addFirst("Thousand");
                res.addFirst(Units[mod]);
                }

            else if(i == 6) {
                temp = mod;
                if(num > 0 && num <1000|| num%1000 !=0) res.addFirst("Million");
                res.addFirst(Units[mod]);
            }

            else{
                temp = mod;
                if(num > 0 && num <1000|| num%1000 !=0) res.addFirst("Billion");
                res.addFirst(Units[mod]);
            }
            num = num/10;
        }
        while(res.getLast() == "") res.removeLast();

        for(int i = 0 ;i< res.size();i++){
            if(res.get(i) == "") continue;
            if(i==res.size()-1 )ans += res.get(i);
            else ans += res.get(i)+" ";
        }
        return ans;
    }

    public static void main(String [] args){
        A Launcher = new A();
        Launcher.start();
    }
    public void start(){
        int[] num = {1234567,10,10000,100002000,120,20,1111115114,12113};

        for(int i:num)
            System.out.println( numberToWords(i));

    }
}