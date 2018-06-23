

class Solution {
/**Let me use an example to briefly explain this. For example,
 * your machines[] is [0,0,11,5]. So your total is 16 and the
 * target value for each machine is 4. Convert the machines
 * array to a kind of gain/lose array, we get: [-4,-4,7,1].
 * Now what we want to do is go from the first one and try to make all of them 0.
   To make the 1st machines 0, you need to give all its "load" to the 2nd machines.
   So we get: [0,-8,7,1]
        then: [0,0,-1,1]
      lastly: [0,0,0,0], done.
 You don't have to worry about the details about how these machines give load to
 each other. In this process, the least steps we need to eventually finish this
 process is determined by the peak of abs(cnt) and the max of "gain/lose" array.
 In this case, the peak of abs(cnt) is 8 and the max of gain/lose array is 7.
 So the result is 8.
 * */

//Another idea:
/**First we check the sum of dresses in all machines. if that number cannot be divided by count of machines,
 *  there is no solution.

 Otherwise, we can always transfer a dress from one machine to another, one at a time until every machines
 reach the same number, so there must be a solution. In this way, the total actions is sum of operations on
 every machine.

 Since we can operate several machines at the same time, the minium number of moves is the maximum number
 of necessary operations on every machine.

 For a single machine, necessary operations is to transfer dresses from one side to another until sum of both
 sides and itself reaches the average number. We can calculate (required dresses) - (contained dresses) of
 each side as L and R:

 L > 0 && R > 0: both sides lacks dresses, and we can only export one dress from current machines at a time,
                so result is abs(L) + abs(R)
 L < 0 && R < 0: both sides contains too many dresses, and we can import dresses from both sides at the same
                time, so result is max(abs(L), abs(R))
 L < 0 && R > 0 or L >0 && R < 0: the side with a larger absolute value will import/export its extra dresses
                from/to current machine or other side, so result is max(abs(L), abs(R))

 For example, [1, 0, 5], average is 2
 for 1, L = 0 * 2 - 0 = 0, R = 2 * 2 - 5= -1, result = 1
 for 0, L = 1 * 2 - 1= 1, R = 1 * 2 - 5 = -3, result = 3
 for 5, L = 2 * 2 - 1= 3, R = 0 * 2 - 0= 0, result = 3
 so minium moves is 3
 * */
        public int findMinMoves(int[] machines) {
                int total = 0;
                for(int i: machines) total+=i;
                if(total%machines.length!=0) return -1;
                int avg = total/machines.length, cnt = 0, max = 0;
                for(int load: machines){
                    cnt += load-avg; //load-avg is "gain/lose"
                    max = Math.max(Math.max(max, Math.abs(cnt)), load-avg);
                }
                return max;
            }



    public static void main(String[] args) {
        Solution Launcher = new Solution();
        Launcher.start();
    }

    public void start() {
        int[] machines = {1,0,5};
        System.out.println("3:"+findMinMoves(machines));

        int[] machines1 = {0,3,0};
        System.out.println("2:"+findMinMoves(machines1));

        int[] machines2 = {0,2,0};
        System.out.println("-1:"+findMinMoves(machines2));

        int[] machines3 = {0,4,4,0};
        System.out.println("2:"+findMinMoves(machines3));

        int[] machines4 = {3,1,0,4};
        System.out.println("2:"+findMinMoves(machines4));

        int[] machines5 = {100000,0,100000,0,100000,0,100000,0,100000,0,100000,0};
        System.out.println("50000:"+findMinMoves(machines5));

    }
}

