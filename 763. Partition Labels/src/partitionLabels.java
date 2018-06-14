import java.util.*;

class A {

    /**
     *  Idea: record the end index of the current sub string
     * */
    public List<Integer> partitionLabels(String S) {
        if(S == null || S.length() == 0){
            return null;
        }
        List<Integer> list = new ArrayList<>();
        int[] map = new int[26];  // record the last index of the each char

        for(int i = 0; i < S.length(); i++){
            map[S.charAt(i)-'a'] = i;
        }
        // record the end index of the current sub string


        int last = 0;
        int start = 0;
        for(int i = 0; i < S.length(); i++){
            last = Math.max(last, map[S.charAt(i)-'a']);
            if(last == i){
                list.add(last - start + 1);
                start = last + 1;
            }
        }
        return list;
    }

    public List<Integer> partitionLabels1(String S) {
        Map<Character, Integer> map = new HashMap<>();
        List<Integer> list = new LinkedList<>();
        Set<Character> set = new HashSet<>();
        char[] chs = S.toCharArray();
        int n = chs.length;
        for(char c : chs)
            map.put(c, map.getOrDefault(c, 0) + 1);
        for(int i = -1, j = 0; j < n; j++){
            char c = chs[j];
            map.put(c, map.getOrDefault(c, 0) + 1);
            set.add(c);
            Integer cnt = map.get(c);
            if(cnt != 0) map.put(c, cnt-1);
            if(cnt-1 == 0) set.remove(c);
            if(set.isEmpty()){
                list.add(j-i);
                i = j;
            }
        }
        return list;
    }
    public static void main(String [] args){
        A Launcher = new A();
        Launcher.start();
    }
    public void start(){
        String s = "ababcbacadefegdehijhklij";
        System.out.println(partitionLabels(s));
    }
}