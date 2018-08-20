import java.util.*;

public class wordBreak {

    public List<String> wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        HashMap<Integer, List<String>> map = new HashMap<>(); //HashMap<End-index, List<String>>

        dp[0] = true;

//        for(int i = 1;i < dp.length; i ++) {
//            for (String ds : wordDict) {
//                if (i >= ds.length()) {
//                    if (dp[i-ds.length()]
//                    && s.substring(i-ds.length(), i).equals(ds)) {
//                        dp[i] = true;
//                        map.putIfAbsent(i, new ArrayList<>());
//                        map.get(i).add(ds);
//                    }
//                }
//            }
//        }
        //Build graph using dp
        Set<String> set = new HashSet<>(wordDict);

        dp[0] = true;

        //Build graph using dp
        for(int i = 0; i <= s.length(); i++){
            for(int j = 0; j < i; j++){
                String tmp = s.substring(j, i);
                if(dp[j] && set.contains(tmp)){
                    dp[i] = true;
                    map.putIfAbsent(i, new ArrayList<>());
                    map.get(i).add(tmp);
                }
            }
        }
        List<String> res = new ArrayList<>();
        if (!dp[s.length()])
            return res;
        findWordR("", s.length(), map, res);
        return res;
    }

    public void findWordR(String preStr, int index,
    HashMap<Integer, List<String>> map, List<String> res) {
        if (index == 0) {
            res.add(preStr);
            return;
        }

        for (String s : map.get(index)) {
            if (preStr.equals(""))
                findWordR(s, index - s.length(), map, res);
            else
                findWordR(s + " " + preStr, index - s.length(), map, res);
        }
    }
    /*
        1. Using Dynamic programming to create a graph(HashMap);
        2. Using BackTrace to build List<String>;
     */
/*     List<String> ans = new ArrayList<>();
   public List<String> wordBreak(String s, List<String> wordDict) {


        Set<String> wordSet = new HashSet<>(wordDict);
        Map<String, List<String>> map = new HashMap<>();
        Map<Integer, List<String>> indexmap = new HashMap<>();

        map.put("#", new ArrayList<>());// BackTrace start from "#"
        indexmap.put(0, new ArrayList<>());
        indexmap.get(0).add("#");

        int N = s.length();
        //boolean[] dp = new boolean[N+1];
        //dp[0] = true;

        //DP to create a Graph(HashMap) according to String s
        for(int i = 0; i < N; i++){
            for(int j = 0; j < i; j++) {
               String tmps = s.substring(j, i+1);
               if(wordSet.contains(tmps)){
                    if(j == 0){
                        map.get("#").add(tmps);
                        map.putIfAbsent(tmps, new ArrayList<>());
                        indexmap.putIfAbsent(i, new ArrayList<>());
                        indexmap.get(i).add(tmps);
                    }else if (indexmap.containsKey(j-1)){
                        List<String> endlist = indexmap.get(j-1);
                        for(String endword: endlist) {
                            map.putIfAbsent(endword, new ArrayList<>());
                            map.get(endword).add(tmps);
                            indexmap.putIfAbsent(i, new ArrayList<>());
                            indexmap.get(i).add(tmps);
                        }
                    }else{
                        continue;
                    }
               }
            }
        }


        //BackTrace to build List<String>
        backtrace(map, ans);

        return ans;

    }

    public void backtrace(Map map, List<String> ans) {
        return;
    }*/

    public static void main(String[] args) {
        wordBreak Launcher = new wordBreak();
        Launcher.start();
    }

    public void start() {
//        String s = "pineapplepenapple";
//        String[] arr = {"apple", "pen", "applepen", "pine", "pineapple"};
//        List<String> list = new ArrayList<>();
//        arrtolist(arr,list);
//        wordBreak(s, list);

        String s1 = "a";
        String[] arr1 = {"a"};
        List<String> list1 = new ArrayList<>();
        arrtolist(arr1,list1);
        wordBreak(s1, list1);
    }

    public void arrtolist(String[] arr, List<String> list) {
        for(String s : arr) {
            list.add(s);
        }
    }
}
