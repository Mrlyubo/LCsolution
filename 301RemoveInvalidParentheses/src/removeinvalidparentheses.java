import java.util.*;

class A {

    public List<String> removeInvalidParentheses(String s) {
        // Approach 1# DFS+recursion.
        List<String> ans = new LinkedList<>(); // LinkedList is faster in add random element, ArrayList is faster in read random element.
        remove (s,ans,0,0, new char[]{'(',')'} );
        return ans;
    }
    public void remove (String s, List<String> ans, int last_i, int last_j, char[] par){
        for( int stack = 0, i = last_i; i <s.length(); i++){
            if(s.charAt(i) == par[0]) stack++;
            if(s.charAt(i) == par[1]) stack--;
            if(stack >= 0 ) continue;// if stack < 0 ,too many), remove par[1]=')'.
            for(int j = last_j; j <= i; j++){
                if(s.charAt(j)==par[1]&& (j == last_j || s.charAt(j-1)!= par[1])){
                    remove(s.substring(0,j)+s.substring(j+1),ans,i,j,par);
                }

            } return;
        }
        String reversed = new StringBuilder(s).reverse().toString();
        if(par[0]=='(')
            remove(reversed,ans,0,0,new char[]{')','('});
        else
            ans.add(reversed);
    }

    //Aproach #2  DFS ,No recursion.O(2^n). Use Set visited, Queue quene, ArrayList res;
    /** Aproach #2  DFS ,no recursion.O(2^n).
    public List<String> removeInvalidParentheses(String s) {

        List<String> res = new ArrayList<>();

        // sanity check
        if (s == null) return res;

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        // initialize
        queue.add(s);
        visited.add(s);

        boolean found = false;

        while (!queue.isEmpty()) {
            s = queue.poll();

            if (isValid(s)) {
                // found an answer, add to the result
                res.add(s);
                found = true;
            }

            if (found) continue;

            // generate all possible states
            for (int i = 0; i < s.length(); i++) {
                // we only try to remove left or right paren
                if (s.charAt(i) != '(' && s.charAt(i) != ')') continue;

                String t = s.substring(0, i) + s.substring(i + 1);

                if (!visited.contains(t)) {
                    // for each state, if it's not visited, add it to the queue
                    queue.add(t);
                    visited.add(t);
                }
            }
        }

        return res;
    }

    // helper function checks if string s contains valid parantheses
    boolean isValid(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') count++;
            if (c == ')' && count-- == 0) return false;
        }

        return count == 0;

    }*/


    public static void main(String [] args){
        A Launcher = new A();
        Launcher.start();
    }
    public void start(){
        String s = "()())()";
        System.out.print( removeInvalidParentheses(s) );
    }
}