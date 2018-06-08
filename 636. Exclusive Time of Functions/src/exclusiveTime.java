import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

class A {
/**
 * My Approach: use Array to store every seconds' funtions' id.
 * When the time is large, it will exceed memory limit.
 * Optimized #1:
 * No need to use time_array to keep track of every  every seconds' functions' id, when we know its id,
 * Just update result[] directly.
 *
 * Optimized #2:
 * use count to update the result[] without iteration;
 *
 * Optimized #3:
 * use  prev_timestamp instead of nextstamp. No need to logs.get(0);
 */
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        while (logs.size()>1) {
            String curr = logs.remove(0);
            String[] loginfo = curr.split(":");
            int timestamp = Integer.parseInt(loginfo[2]);
            int nextstamp = Integer.parseInt(logs.get(0).split(":")[2]);
            int cnt = nextstamp-timestamp;
            int id = Integer.parseInt(loginfo[0]);

            if (loginfo[1].equals("start")){
                stack.push(id);
                res[stack.peek()]+=cnt;
            }
            if(loginfo[1].equals("end")) {
                res[stack.pop()]++;
                if(!stack.isEmpty())res[stack.peek()] += cnt-1;
            }
        }
        if(!stack.isEmpty())res[stack.peek()]++;
        return res;
    }

    public static void main(String [] args){
        A Launcher = new A();
        Launcher.start();
    }
    public void start(){
        int n = 3;
        LinkedList<String> logs = new LinkedList<>();
        logs.add("1:start:0");
        logs.add("2:start:2");
        logs.add("2:end:3");
        logs.add("0:start:4");
        logs.add("0:end:5");
        logs.add("1:end:7");
        for(int r: exclusiveTime(n,logs))
            System.out.print(r+",");
        System.out.println("***2,4,2");

        int n1 = 2;
        LinkedList<String> logs1 = new LinkedList<>();
        logs1.add("0:start:0");
        logs1.add("1:start:2");
        logs1.add("1:end:5");
        logs1.add("0:start:6");
        for(int r: exclusiveTime(n1,logs1))
            System.out.print(r+",");
        System.out.println("***3,4");

        int n2 = 1;
        LinkedList<String> logs2 = new LinkedList<>();
        logs2.add("0:start:0");
        logs2.add("0:start:2");
        logs2.add("0:end:5");
        logs2.add("0:start:6");
        logs2.add("0:end:6");
        logs2.add("0:end:7");
        for(int r2: exclusiveTime(n2,logs2))
            System.out.print(r2+",");
        System.out.println("***8");

        int n3 = 1;
        LinkedList<String> logs3 = new LinkedList<>();
        logs3.add("0:start:0");
        logs3.add("0:start:100000000");
        for(int r3: exclusiveTime(n3,logs3))
            System.out.print(r3+",");
        System.out.println("***100000001");

        int n4 = 3;
        LinkedList<String> logs4 = new LinkedList<>();
        logs4.add("0:start:0");
        logs4.add("0:end:0");
        logs4.add("1:start:1");
        logs4.add("1:end:1");
        logs4.add("2:start:2");
        logs4.add("2:end:2");
        logs4.add("2:start:3");
        logs4.add("2:end:3");
        for(int r4: exclusiveTime(n4,logs4))
            System.out.print(r4+",");
        System.out.println("***1,1,2");

    }
}
