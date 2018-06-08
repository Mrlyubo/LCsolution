import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

class A {

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        for(String word: wordDict){
            set.add(word);
        }
        boolean[] f = new boolean[s.length() + 1]; // if f[i] is True, it means s.substirng(0,i+1) is valid.
        f[0] = true;
        /* First DP
        for(int i = 1; i <= s.length(); i++){
            for(String str: dict){
                if(str.length() <= i){
                    if(f[i - str.length()]){
                        if(s.substring(i-str.length(), i).equals(str)){
                            f[i] = true;
                            break;
                        }
                    }
                }
            }
        }*/
        //Second DP
        for(int i=1; i <= s.length(); i++){
            for(int j=0; j < i; j++){
                if(f[j] && set.contains(s.substring(j, i))){
                    f[i] = true;
                    break;
                }
            }
        }
        return f[s.length()];
    }

    //My Recursive Approach ,it works, but it exceeded time limit;
    public boolean wordBreak1(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        for(String word: wordDict){
            set.add(word);
        }
        return isValid1(s,0,set);
    }

    public boolean isValid1(String s, int start,Set set){ //
        boolean flag = false;
        for(int i = start; i < s.length(); i++ ){
            String cur = s.substring(start, i+1);
            if(set.contains(cur)){
                if(i-start == cur.length()-1 && i == s.length()-1) {
                    flag = true;
                    break;
                }
                if(isValid1(s, i+1, set))
                    return true;
                else
                    continue;
            }
            else if(i-start == s.length()-1){
                flag = false;
                break;
            }
        }
        return flag;
    }
    public static void main(String [] args){
        A Launcher = new A();
        Launcher.start();
    }
    public void start(){
        List<String> wordDict = new LinkedList<>();
        wordDict.add("leet");
        wordDict.add("code");
        System.out.println(wordBreak("leetcode",wordDict));

        List<String> wordDict1 = new LinkedList<>();
        wordDict1.add("apple");
        wordDict1.add("pen");
        System.out.println(wordBreak("applepenapple",wordDict1));

        List<String> wordDict2 = new LinkedList<>();
        wordDict2.add("cats");
        wordDict2.add("og");
        wordDict2.add("and");
        wordDict2.add("cat");
        wordDict2.add("an");
        System.out.println(wordBreak("catsandog",wordDict2));

        List<String> wordDict3 = new LinkedList<>();
        wordDict3.add("c");
        wordDict3.add("aa");
        wordDict3.add("aaa");
        wordDict3.add("aaaa");
        wordDict3.add("aaaaaa");
        wordDict3.add("aaaaaaaa");
        wordDict3.add("aaaaaaaaaa");
        wordDict3.add("aaaaaaaaaaaaaaaaa");
        System.out.println(wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",wordDict3));
    }
}
