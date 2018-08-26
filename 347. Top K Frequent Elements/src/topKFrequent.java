import java.util.*;

public class topKFrequent {

    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frqmap = new HashMap<>();
        List<Integer>[] buckets = new ArrayList[nums.length+1];

        //Traverse the nums array and record the frq of each Integer.
        for (int i = 0 ; i < nums.length; i++) {
            frqmap.put(nums[i], frqmap.getOrDefault(nums[i],0) + 1);
        }

        //Using bucket array to sort the Integer according to their frq.
        //Note: buckets[f] can not be referenced!
        //Note: List<Integer> list = buckets[f] is un-valid.
        for(int num: frqmap.keySet()) {
            int f = frqmap.get(num);
            if(buckets[f] == null) {
                buckets[f] = new ArrayList<>();
            }
            buckets[f].add(num);
        }

        //Add topKFrequent num to result List.
        List<Integer> res = new ArrayList<>();
        int cnt = 0;
        for(int i = nums.length; i > 0; i-- ) {
            if( buckets[i] != null) {
                for(int num: buckets[i]) {
                    if(cnt < k) {
                        res.add(num);
                    }else {
                        break;
                    }
                    cnt++;
                }
            }
        }
        return res;
    }
//****************************better solution.********************************************
    //1. Using ( diff = i - min ) to count frequency.
    //2. Skip the same number.
    //3. Using subList & addAll.


    public List<Integer> topKFrequent1(int[] nums, int k) {
        int min = nums[0], max = nums[0]; // array is non empty
            for(int i : nums){
            if(min > i) min = i;
            if(max < i) max = i;
        }
        int cnt[] = new int[max-min+1];
        int max_freq = 0;
            for(int i : nums){
            int j = i-min;
            cnt[j] = cnt[j] + 1;
            if(max_freq < cnt[j]){
                max_freq = cnt[j];
            }
        }

        // use array instead of Sorted TreeMap, make run-time O(n) instead of O(logn)
        // But it allocates space even for the empty frequency
        ArrayList<Integer> bucket[] = new ArrayList[max_freq + 1];
            for(int i : nums){
            int j = i-min;
            int freq = cnt[j];
            // System.out.println(i+" freq="+freq);
            if(freq == 0) continue;
            cnt[j] = 0; // next time we see it, we can skip it.
            if (bucket[freq] == null){
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(i);
        }
        List<Integer> result = new ArrayList<>();
            while(result.size() < k){
            result.addAll(bucket[max_freq]);
            while(bucket[--max_freq] == null){
                if(max_freq == 0) break;
            }
        }
            return result.size() > k ? result.subList(0, k) : result;
    }
//************************************************************************
    public static void main(String[] args) {
        topKFrequent Launcher = new topKFrequent();
        Launcher.start();
    }

    public void start() {
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        System.out.println(topKFrequent(nums, k));
    }
}
