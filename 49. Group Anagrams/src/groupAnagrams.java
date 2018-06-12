import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

class A {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new LinkedList<>();
        HashMap<String, List<String>> map = new HashMap<>(); // the result often store in a map's key first.
        for(String str : strs){
            char[] cc = str.toCharArray();
            Arrays.sort(cc);
            String strkey = String.valueOf(cc); // toString() won't work.
            if(!map.containsKey(strkey))
                map.put(strkey, new LinkedList<>());
            map.get(strkey).add(str);
        }
        for(String key : map.keySet())
            res.add(map.get(key));
        return res;
    }
    public static void main(String [] args){
        A Launcher = new A();
        Launcher.start();
    }
    public void start(){
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }
}