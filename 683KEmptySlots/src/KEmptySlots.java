
import java.util.HashMap;
import java.util.Map;


class A {
    public int kEmptySlots(int[] flowers, int k) {
/**
        int[] days =  new int[flowers.length];
        for(int i=0; i<flowers.length; i++)days[flowers[i] - 1] = i + 1;
        int left = 0, right = k + 1, res = Integer.MAX_VALUE;
        for(int i = 0; right < days.length; i++){
            if(days[i] < days[left] || days[i] <= days[right]){
                if(i == right)res = Math.min(res, Math.max(days[left], days[right]));   //we get a valid subarray
                left = i;
                right = k + 1 + i;
            }
        }
        return (res == Integer.MAX_VALUE)?-1:res;}
 */

        int n = flowers.length, ans = Integer.MAX_VALUE;
        int[] day = new int[n+1];
        for(int i = 0; i < n; i++ ) day [flowers[i]-1] = i;
        int left = 0 ,right = k+1;
        for(int i = 0; right < n; i++){
            if(day[i] < day[left] || day[i] <= day[right]){
                if( i == right){
                    ans = Math.min(Math.max(day[left], day[right])+1,ans);
                }
                left = i;
                right = left + k +1;
            }
        }
         return (ans == Integer.MAX_VALUE)?-1:ans;
    }

    // Aproach #1 BruteForce O(n2)
    /**
    public int kEmptySlots(int[] flowers, int k) {
         Aproach #1 BruteForce.
        Map<Integer,Integer> map = new HashMap<>();
        int n = flowers.length;
        int currans = -1, res = -1;
        if ( n < 2 ) return -1;
        for(int i = 0; i < n ; i++){

            int Max = 0,Min = 0,day = 0;
            if(map.containsKey(flowers[i]+k+1)||map.containsKey(flowers[i]-k-1)) {
                map.put(flowers[i],i);
                if (map.containsKey(flowers[i] - k - 1)) {
                    Max = Math.max(flowers[i], flowers[i] - k - 1);
                    Min = Math.min(flowers[i], flowers[i] - k - 1);

                }
                if (map.containsKey(flowers[i] + k + 1)) {
                    Max = Math.max(flowers[i], flowers[i] + k + 1);
                    Min = Math.min(flowers[i], flowers[i] + k + 1);

                }
                day = Math.max(map.get(Max),map.get(Min));
                int count = 0;

                for (int j = day + 1; j < n; j++) {
                    if (flowers[j] < Max && flowers[j] > Min) count++;
                }
                if (count == k) {res = day+1;break;}
                else currans = -1;
                
            }
            else map.put(flowers[i],i);
        }
        return Math.max(currans,res);
    }*/

    public static void main(String [] args){
        A Launcher = new A();
        Launcher.start();
    }
    public void start(){
        int[] flowers1 = {1,2,3}, flowers2 ={1,2}, flowers3={6,5,8,9,7,1,10,2,3,4};
        int k = 2;
        System.out.print( kEmptySlots(flowers3,k));
    }
}
