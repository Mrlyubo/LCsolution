import java.util.*;

class Solution {
    /** List<String>[] + frequency buckets: 19ms (much faster than PriorityQueue)*/
    //387. First Unique Character in a String  is also use a frequency buckets.
    public List<String> topKFrequent1(String[] words, int k) {
        //there can be at most word length of buckets.
        List<String>[] buckets = new ArrayList[words.length+1];

        HashMap<String, Integer> freqMap = new HashMap<>();
        for(String word : words) //O(n)
            freqMap.put(word, freqMap.getOrDefault(word, 0)+1);

        for(String key :  freqMap.keySet()){//O(n)
            int f = freqMap.get(key);
            if(buckets[f]== null)
                buckets[f] = new ArrayList<String>();
            buckets[f].add(key);
        }

        List<String> result = new ArrayList<>();
        int count = 0;
        for(int i=buckets.length-1; i>0; i--){//O(k)
            if(buckets[i]!=null){
                Collections.sort(buckets[i]);
                for(String word : buckets[i]){
                    if(count < k){
                        result.add(word);
                    }else
                        break;
                    count ++;
                }
            }
        }
        return result;
    }

    /**PriorityQueue  O(N*log(k)): 96ms*/
    public List<String> topKFrequent(String[] words, int k) {
        //use a Map<word, frequency> do map the frequency of each words.O(n).
        Map<String, Integer> map = new HashMap<>();
        for(String word: words)
            map.put(word, map.getOrDefault(word, 0)+1);
        //Use PriorityQueue with size K to find the top K frequent words.
        //Sorting way: from less freqent to more frequent. when the size is bigger than k, poll the first item(which is the less frequent in the PriorityQueue),as for same frequency, the word with lower alphabetical order should be near the bottom of the PriorityQueue.
        //No need to use Map.Entry in the PriorityQueue. O(logk)
        PriorityQueue<String> heap = new PriorityQueue<>((w1, w2)->
                map.get(w1) == map.get(w2) ? w2.compareTo(w1) : map.get(w1) - map.get(w2));
        for(String word: map.keySet()){ //*****note: keySet()
            heap.offer(word);
            if(heap.size() > k)
                heap.poll();
        }
        List<String> res = new LinkedList<>();
        while(!heap.isEmpty())
            res.add(heap.poll());
        Collections.reverse(res);
        return res;
    }
    public static void main(String[] args) {
        Solution Launcher = new Solution();
        Launcher.start();
    }

    public void start() {

        System.out.println();
    }
}

