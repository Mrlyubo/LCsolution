import java.util.*;

class A {
    //Same idea, less lines;
    public String mostCommonWord1(String p, String[] banned) {
        Set<String> ban = new HashSet<>(Arrays.asList(banned)); // Arrays.asList(banned);
        Map<String, Integer> count = new HashMap<>();
        String[] words = p.replaceAll("\\pP" , "").toLowerCase().split("\\s+");
        /**Unicode 编码并不只是为某个字符简单定义了一个编码，而且还将其进行了归类。

        \pP 其中的小写 p 是 property 的意思，表示 Unicode 属性，用于 Unicode 正表达式的前缀。

        大写 P 表示 Unicode 字符集七个字符属性之一：标点字符。

         http://www.runoob.com/java/java-regular-expressions.html
         https://www.cnblogs.com/qixuejia/p/4211428.html
         */
        String res = "";
        for (String w : words) if (!ban.contains(w)) count.put(w, count.getOrDefault(w, 0) + 1);
        return Collections.max(count.entrySet(), Map.Entry.comparingByValue()).getKey(); //Collections.max
    }


    public String mostCommonWord(String paragraph, String[] banned) {
        String[] words = paragraph.replaceAll("[^a-zA-Z ]", "").toLowerCase().split(" ");
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((x,y)->y.getValue()-x.getValue());
        Map<String, Integer> map = new HashMap<>();
        Set<String> banset = new HashSet<>();
        for(String bans : banned)
            banset.add(bans);
        for(String s : words){
            if(!banset.contains(s))
               map.put(s,map.getOrDefault(s,0)+1);
        }
        for(Map.Entry e : map.entrySet())
            pq.add(e);
        return pq.peek().getKey();
    }
    public static void main(String [] args){
        A Launcher = new A();
        Launcher.start();
    }
    public void start(){
        String paragraph =  "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = {"hit"};
        System.out.println(mostCommonWord(paragraph, banned));
    }
}