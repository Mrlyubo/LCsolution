import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new LinkedList<>();
        int n = p.length();
        char[] chsp = p.toCharArray();
        Arrays.sort(chsp);
        String sortp = String.valueOf(chsp);

        for(int i = 0; i <= s.length()-n; i++){//O(n*n)
            int j = i + n;
            char[] test = s.substring(i,j).toCharArray();
            Arrays.sort(test);//O(n)
            String sorttest = String.valueOf(test);
            if(sorttest.equals(sortp)) //O(n)
                ans.add(i);
        }
        return ans;
    }
    public static void main(String[] args) {
        Solution Launcher = new Solution();
        Launcher.start();
    }

    public void start() {

        System.out.println(findAnagrams("cbaebabacd" ,"abc"));
        System.out.println(findAnagrams("abab" ,"ab"));
    }
}

