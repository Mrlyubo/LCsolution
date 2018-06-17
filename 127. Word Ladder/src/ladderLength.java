import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) // check if the endWord exists in the given wordList.
            return 0;
        Set<String> beginSet = new HashSet<>(), endSet = new HashSet<>();
        Set<String> dict = new HashSet<>(wordList);//
        /*TLE caused by searching whether target already exists
        in the wordList if (!visited.contains(target) && wordList.contains(target))
         {...}as the contains() consumes O(n) time,
         converting the input to Set<> would solve it
         */

        HashSet<String> seen = new HashSet<>();
        int res = 1;
        beginSet.add(beginWord);
        endSet.add(endWord);
        while(!beginSet.isEmpty() && !endSet.isEmpty()){
            if(beginSet.size() > endSet.size()){
                Set<String> set = beginSet;
                beginSet = endSet;
                endSet = set;
            }
            Set<String> tmp = new HashSet<>();// ** outside the  for(String s: beginSet) loop.
            for(String s: beginSet){ // beginSet.size() is limited.
                char[] chs = s.toCharArray();
                for(int i = 0; i < chs.length; i++){ //chs.length is limited.
                    for(char c = 'a'; c <= 'z'; c++){//a->z, 26 times, limited.
                        char old = chs[i];
                        chs[i] = c;
                        String target = String.valueOf(chs);
                        if(endSet.contains(target)){
                            return res+1;
                        }
                        if(!seen.contains(target) && dict.contains(target)){
                            tmp.add(target);
                            seen.add(target);
                        }
                        chs[i] = old;
                    }
                }
            }
            beginSet = tmp; // ** outside the  for(String s: beginSet) loop.
            res++;
        }return 0;
    }


    //**********My Approach: TLE.
    public int ladderLength1(String b, String e, List<String> w) {
        int cnt = 0;
        boolean found = false;
        Set<String> set = new HashSet<>();
        for(String s : w)
            set.add(s);
        Set<String> curset1 = new HashSet<>();
        curset1.add(b);
        while(!set.isEmpty()){
            Set<String> curset2 = new HashSet<>();
            for(String s1: curset1)
                for(String s2: set)// *********note: set.size() could be very large.
                    if(isNeighbor(s1,s2))
                        curset2.add(s2);

            for(String ss2: curset2)
                set.remove(ss2);

            cnt++;
            if(curset2.contains(e)) {
                found = true;
                break;
            }
            curset1 = curset2;
        }
        return found?cnt+1:0;
    }
    private boolean isNeighbor(String prev, String next){
        int n = prev.length();
        int cnt = 0;
        for(int i = 0; i < n; i++)
            if(prev.charAt(i)!=next.charAt(i)) cnt++;
        return cnt == 1;
    }

    public List<String> ArraytoList ( String[] array){
        List<String> list = new LinkedList<>();
        for(String n: array)
            list.add(n);
        return list;
    }
    public static void main(String[] args) {
        Solution Launcher = new Solution();
        Launcher.start();
    }

    public void start() {
        String[] words1 = {"hot","dot","dog","lot","log"};
        List<String> wordList1 = ArraytoList(words1);
        System.out.println(ladderLength("hit","cog" , wordList1));


    }


}

