import java.util.Arrays;
class Solution {
    //better way: use frq_map, 5ms.
    /*
    Three conditions could be merged to one:
        The Person with age A can request person with age B if
        B is in range ( 0.5 * A + 7, A ]
    * */

    public int numFriendRequests(int[] ages) {
        int[] count = new int[121];
        for (int i: ages){
            count[i]++;
        }

        int[] sum = new int[121];
        for (int i = 1; i < 121; i++){
            sum[i] = sum[i - 1] + count[i];
        }

        int res = 0;
        for (int i = 15; i < 121; i++){
            if (count[i] != 0){
                int lo = i / 2 + 7;
                int current = sum[i] - sum[lo];
                res += count[i] * (current - 1);
            }
        }

        return res;
    }

    //My way: Straight forward, 65ms.
    public int numFriendRequests1(int[] ages) {
        Arrays.sort(ages);
        int res = 0;
        int fast = ages.length-1;
        for(int i = ages.length-1; i >= 0; i--){
            if(ages[i]<= 14) continue;
            int edge = ages[i]/2 + 7;
            while(fast >= 1 && ages[fast-1] > edge  ){
                fast--;
            }

            int t = i;
            while (t < ages.length-1 && ages[t] == ages[t+1]){
                t++;
            }

            int tmpres = t >= fast ? t - fast : 0;
            //System.out.println("i="+i + " ,tmpres = "+tmpres);
            res += tmpres;
            if(fast > i )
                fast = i;
        }
        return res;
    }
    public static  void main(String[] args) {
        Solution Launcher = new Solution();
        Launcher.start();
    }

    public void start() {

        int[] ages = {16, 17, 18, 25, 30};
        int[] ages1 = {16, 16, 16};
        int[] ages2 = {20,30,100,110,120};
        int[] ages3 = {16, 16,16, 16};
        int[] ages4 = {10, 10};
        int[] ages5 = {16, 16};
        int[] ages6 = {100, 100};
        int[] ages7 = {14, 14};
        int[] ages8 = {15, 15};
        int[] ages9 = {8,24,85,69,85};


        System.out.println("3:"+numFriendRequests(ages));
        System.out.println("6:"+numFriendRequests(ages1));
        System.out.println("3:"+numFriendRequests(ages2));
        System.out.println("12:"+numFriendRequests(ages3));
        System.out.println("0:"+numFriendRequests(ages4));
        System.out.println("2:"+numFriendRequests(ages5));
        System.out.println("2:"+numFriendRequests(ages6));
        System.out.println("2:"+numFriendRequests(ages6));
        System.out.println("0:"+numFriendRequests(ages7));
        System.out.println("2:"+numFriendRequests(ages8));
        System.out.println("4:"+numFriendRequests(ages9));


        int[] ages10 = {7,8,20,77,80,97,98,101,109,114};
        System.out.println("21:"+numFriendRequests(ages10));

        int[] ages11 = {21,23,40,54,74,74,76,90,102,112};
        System.out.println("22:"+numFriendRequests(ages11));

        int[] ages12 = {98,60,24,89,84,51,61,96,108,87,68,29,14,11,13,50,13,104,57,8,57,111,92,87,9,59,65,116,56,39,55,11,21,105,57,36,48,93,20,94,35,68,64,41,37,11,50,47,8,9};
        System.out.println("439:"+numFriendRequests(ages12));

        int[] ages13 = {98,65,61,96,99,34,67,37,32,74,48,52,8,72,64,112,120,28,71,56,109,63,9,13,41,27,20,62,11,31,38,57,38,16,12,107,40,39,77,43,105,73,99,102,14,66,13,44,90,86,51,87,37,99,57,77,45,63,56,34,84,76,92,22,118,76,90,89,58,67,109,97,87,47,9,58,97,46,22,42,16,6,43,75,63,108,23,14,44,30,87,116,93,17,21,64,46,14,70,90};
        System.out.println("2081:"+numFriendRequests(ages13));


    }
}

