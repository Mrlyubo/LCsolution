class Solution {
    public int numJewelsInStones(String J, String S) {
        boolean[] Jmap = new boolean[128];
        char[] Sarr = S.toCharArray();
        int cnt = 0;
        for(char j: J.toCharArray())
            Jmap[j] = true;
        for(char s: Sarr)
            if(Jmap[s])
                cnt++;
        return cnt;
    }
    public static void main(String[] args) {
        Solution Launcher = new Solution();
        Launcher.start();
    }

    public void start() {
        System.out.println("3:"+numJewelsInStones("aA","aAAbbbb"));
        System.out.println("0:"+numJewelsInStones("z","ZZ"));

    }
}

