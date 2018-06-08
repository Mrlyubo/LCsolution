import java.util.List;
import java.util.ArrayList;

class A {
    public List<String> addOperators(String num, int target) {
        List<String> rst = new ArrayList<String>();
        if(num == null || num.length() == 0) return rst;
        helper(rst, "", num, target, 0, 0, 0);
        return rst;
    }
    public void helper(List<String> rst, String path, String num, int target, int pos, long eval, long multed){
        if(pos == num.length()){
            if(target == eval)
                rst.add(path);
            return;
        }
        for(int i = pos; i < num.length(); i++){
            if(i != pos && num.charAt(pos) == '0') break;// 1+05 is  invalid. pos = 1,i = 2
            long cur = Long.parseLong(num.substring(pos, i + 1));
            if(pos == 0){
                helper(rst, path + cur, num, target, i + 1, cur, cur); //结果1，结果2； 已知条件1，已知条件2； 过程变量1，过程变量2，过程变量3；
            }
            else{
                helper(rst, path + "+" + cur, num, target, i + 1, eval + cur , cur);// 注意： pos ：i+1；因为是helper里的helper是下一层级的运算。
                helper(rst, path + "-" + cur, num, target, i + 1, eval -cur, -cur);
                helper(rst, path + "*" + cur, num, target, i + 1, eval - multed + multed * cur, multed * cur );
            }
        }
    }
    public static void main(String [] args){
        A Launcher = new A();
        Launcher.start();
    }
    public void start(){
        String num = "105";
        int target = 5;
        System.out.println(addOperators(num,target).toString());
     }
}


/**
 * pos i    pos  i     pos  i
 * 0   0     0   1     0    2
 * 1   1     1   2
 * 2   2
 */