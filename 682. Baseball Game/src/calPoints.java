import java.util.LinkedList;

class Solution {
    public int calPoints(String[] ops) {
        LinkedList<Integer> stack = new LinkedList<>();
        int sum = 0;
        for(int i = 0; i < ops.length; i++){
            String s = ops[i];
            if (!s.equals("+") && !s.equals("D") && !s.equals("C")) { // Use .equals instead of ==  !!
                stack.addFirst(Integer.parseInt(s));
            }
            else if(s.equals("+")) {
                Integer cur = 0;
                if(stack.size() > 0 ){
                    cur += stack.get(0);
                        if(stack.size() > 1)
                            cur += stack.get(1);
                    stack.addFirst(cur);
                }
            }
            else if(s.equals("D")){
                stack.addFirst(stack.get(0) * 2);
            }
            else { //if(s == "C")
                if(stack.size() >0 )
                    sum -= stack.remove(0);
                continue;
            }
            sum += stack.get(0);
        }
        return sum;
    }
    public static void main(String[] args) {
        Solution Launcher = new Solution();
        Launcher.start();
    }

    public void start() {
        //String[] ops = new String[]{"5","-2","4","C","D","9","+","+"};
        //System.out.println("27:"+calPoints(ops));

        String[] ops1 = new String[]{"5","2","C","D","+"};
        System.out.println("30:"+calPoints(ops1));
    }
}

