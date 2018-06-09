import java.util.Stack;

class A {
    public boolean isValid(String s) {
        char[] cc = s.toCharArray();
        if(cc.length == 0) return true;
        Stack<Character> stack = new Stack<>();
        boolean flag = true;
        for(int i = 0; i < cc.length; i++){
            if (cc[i] == '{'|| cc[i] == '[' || cc[i] =='('){
                stack.push(cc[i]);
                continue;
            }
            else{
                if(stack.isEmpty())
                    flag = false;
                else if(isMatch(stack.pop(),cc[i]))
                    continue;
                else {
                    flag = false;
                    break;
                }
            }
        }
        return flag && stack.isEmpty();
    }

    private boolean isMatch(char l, char r ){

        if( r == '}' && l == '{' || r == ']' && l == '[' || r == ')' && l == '(')
            return true;
        else
            return false;
    }
    public static void main(String [] args){
        A Launcher = new A();
        Launcher.start();
    }
    public void start(){
        String s ="()",s1 = "()[]{}", s2 = "([)]", s3 = "{[]}" ,s4 ="[";
        System.out.println(isValid(s));
        System.out.println(isValid(s1));
        System.out.println(isValid(s2));
        System.out.println(isValid(s3));
        System.out.println(isValid(s4));
    }
}
