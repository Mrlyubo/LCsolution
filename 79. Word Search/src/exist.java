

class A {

    public boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++)
            for( int j = 0; j < board[i].length; j++){
                    if( DFSMarkings(board, word,i,j,0) )
                        return true;
            }
        return false;
    }
    public boolean DFSMarkings(char[][] board, String word, int i, int j, int idx){
        if(idx == word.length())
            return true;
        if(i < 0 || j < 0 ||i>= board.length|| j>=board[i].length ||board[i][j] != word.charAt(idx) )
            return false;
        board[i][j] ^= 256; // it changes the character to non alphabet not to be matched with any possible input character.
        boolean exist =
            DFSMarkings(board, word, i,j+1,idx+1)||
            DFSMarkings(board, word, i,j-1,idx+1)||
            DFSMarkings(board, word, i+1,j,idx+1)||
            DFSMarkings(board, word, i-1,j,idx+1);
        board[i][j] ^= 256;//After the subroutines ran, it uses ^ again to put the original character back.
        return exist;
    }
    public static void main(String [] args){
        A Launcher = new A();
        Launcher.start();
    }
    public void start(){
   /*     char[][] board  =
                {
                        {'A','B','C','E'},
                        {'S','F','C','S'},
                        {'A','D','E','E'}
                };
        String word = "ABCD";
        System.out.println("false: "+exist(board,word));
        String word1 = "ABCCED";
        System.out.println("true: "+exist(board,word1));
        String word2 = "SEE";
        System.out.println("true: "+exist(board,word2));
*/
        char[][] board1  =
                {
                        {'a','b'},
                        {'c','d'}
                };
        String word11 = "abcd";
        System.out.println("false: "+exist(board1,word11));

        /*char[][] board2  =
                {
                        {'a','a'},

                };
        String word22 = "aaa";
        System.out.println("false: "+exist(board2,word22));*/

    }
}