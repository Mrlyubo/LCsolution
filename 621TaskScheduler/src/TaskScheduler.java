import java.util.*;
class A {


    // better Approach.
    public int leastInterval(char[] tasks, int n) { // 9ms

        int[] c = new int[26];//This is the basic concept of HashMap.
        for(char t : tasks){
            c[t - 'A']++;
        }
        Arrays.sort(c);// Array.sort() can arrange an array, Max in the last position.
        int i = 25;
        while(i >= 0 && c[i] == c[25])
            i--;

        return Math.max(tasks.length, (c[25] - 1) * (n + 1) + 25 - i);
        /**(n+1) refer to the number of tasks + idles in each unit,except the last unit.
         * c[25]-1 refer to the number of units.
         * (25-i) refer to the length of the last unit.
         * we don't care the exact number of idles.
        */
    }


    // My approach
    /** we can use Map.Entry<Character, Integer> , but there is no need to do this.*/
    public int leastInterva2(char[] tasks, int n) { //180ms

        //System.out.println("n= " + n);
        //System.out.println("tasks.length= " + tasks.length);
        Map<Character, Integer> map = new HashMap<>();
        Queue<Integer> pq = new PriorityQueue<>((x, y) -> y-x);// pq.poll() can get and remove the MaxValue.
        Stack<Integer> stack = new Stack<>();

        if (tasks.length == 0) return 0;
        int idelNum = 0;
        for (char i : tasks) {// map the occurrences of each characters.
            if (map.containsKey(i))
                map.put(i, map.get(i) + 1);
            else {
                map.put(i, 1);
                //count the number of different character types.
            }
        }
        //System.out.println("cnt = " + cnt);

        for (char i : map.keySet()) {// Sort the occurrences using PriorityQueue.
            pq.add(map.get(i));
        }

        //System.out.println("pq = " + pq.toString());

        while (pq.peek() != 1) {
            for (int j = 0; j < n + 1; j++) {
                if (pq.peek() == null ) {
                    idelNum++;
                    //System.out.println("   idelNum1 = "+idelNum);
                    continue;
                }
                int temp = pq.poll();
                //System.out.println("j = "+j+"   temp=" +temp);
                if (temp != 1) stack.push(temp - 1);
                //System.out.println("pq = "+ pq.toString()+ "   idelNum = "+idelNum);
            }
            while(!stack.isEmpty()) pq.add(stack.pop());
            //System.out.println("after stack.pop, pq = "+pq.toString());
        }
        return tasks.length + idelNum;
    }

        /**
        for(int i = 0; i < cnt && i < n; i++){// delta of occurrences.
            int t= pq.poll();
            dList.addLast(pq.peek()-t);
        }


        while (dList.getLast() == 0) dList.removeLast();
        int Len = dList.size();
        System.out.println("dList is "+ dList.toString());
        for(int i = 0; i < Len; i++) {

            int x = dList.removeFirst();
            if (i != Len-1 ) {
                System.out.println("i = " + i + "   x= " + x);
                idelNum += (n - cnt+1) * x;

            }
            else{
                System.out.println("the last loop");
                System.out.println("i = " + i + "   x= " + x);
                idelNum += (n - cnt+1) * (x-1);
            }
            System.out.println( "  idelNum is " + idelNum);
            cnt--;

        } return tasks.length+idelNum;
}
         */



    public static void main(String [] args){
        A Launcher = new A();
        Launcher.start();
    }
    public void start(){
        //char[] tasks = {'A','A','A','A','A','B','B','B','B','C','C','C','C','C','C','C','E','E'};
        char[] tasks1 = {'A','A','A','B','B','B'};
        //char[] tasks2 = {'A'};
        //char[] tasks3 = {'A','A','A','A','A','B','B','B','B','C','C','C','C','E','E'};
        //char[] tasks4 = {'A','A','A','A','A','A','B','C','D','E','F','G'};
        int n = 2;
        //System.out.println( leastInterval(tasks , n) );
        System.out.println( leastInterval(tasks1 , n) );
    }
}