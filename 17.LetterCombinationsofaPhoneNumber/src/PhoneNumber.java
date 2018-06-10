import java.util.List;
import java.util.LinkedList;

class A {
    public List<String> letterCombinations(String digits) {
        LinkedList<String> ans = new LinkedList<String>();
		LinkedList<int[]> w
        //System.out.print(ans.peek().length());
        if(digits.isEmpty()) return ans;
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        System.out.print(ans.peek().length());
        for(int i =0; i<digits.length();i++){
            int x = Character.getNumericValue(digits.charAt(i));
            while(ans.peek().length()==i){// backtrack to the i depth --> DFS search.
                String t = ans.remove();// First in First out stack.
                //System.out.print(t);
                //System.out.print(ans);
                for(char s : mapping[x].toCharArray())// iterate in an array is faster than string.
                    ans.add(t+s); //"strin"+'g'="string".
            }
        }
        System.out.println(ans.toString());
        return ans;

    }
    public static void main(String [] args){
        A Launcher = new A();
        Launcher.start();
    }
    public void start(){
        String s = "9";
        letterCombinations(s) ;
    }
}