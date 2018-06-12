class A {
    // Recursive Approach:  Time Limit Exceeded.
    public void wallsAndGates0(int[][] rooms) {
        int row = rooms.length;
        if(row == 0 ) return;
        int col = rooms[0].length;
        if(col == 0) return;
        for( int i = 0; i < row; i++)
            for(int j = 0; j < col; j++)
                dfs(rooms, i, j,0,0,0,0);
    }
    private void dfs(int[][] rooms, int i, int j,int v, int h, int curStep, int resStep){
        if( i < 0|| j < 0
          || i >= rooms.length || j >= rooms[0].length || rooms[i][j] == -1 )
            return;
        if(curStep > rooms.length*rooms[0].length)
            return;
        if(rooms[i - h][j - v] != 2147483647 && curStep >rooms[i - h][j - v])
            return;
        if(rooms[i][j] == 0) {
            rooms[i - h][j - v] = Math.min(rooms[i - h][j - v], curStep);
            resStep = rooms[i - h][j - v];
        }
        dfs(rooms, i,j+1,v+1, h, curStep+1,resStep);
        dfs(rooms, i,j-1,v-1, h, curStep+1,resStep);
        dfs(rooms, i+1,j,v, h+1, curStep+1,resStep);
        dfs(rooms, i-1,j,v, h-1, curStep+1,resStep);
    }


    // Recursive Approach[ search from the gate!!!!!]
    public void wallsAndGates(int[][] rooms) {
            int row = rooms.length;
            if(row == 0 ) return;
            int col = rooms[0].length;
            if(col == 0) return;
            for( int i = 0; i < row; i++)
                for(int j = 0; j < col; j++)
                    if(rooms[i][j] == 0) dfs1(rooms, i, j,0);
    }
    private void dfs1(int[][] rooms, int i, int j, int Step){
            if( i < 0 || i >= rooms.length ||
                j < 0 || j >= rooms[0].length ||
                rooms[i][j] < Step )// check if the step is the minimum step.
            return;
            rooms[i][j] = Step;
            dfs1(rooms, i,j+1,Step+1);
            dfs1(rooms, i,j-1,Step+1);
            dfs1(rooms, i+1,j,Step+1);
            dfs1(rooms, i-1,j,Step+1);
    }




    private void printarray(int[][] arr){
        for(int[] arr1: arr){
            System.out.print("[");
            for(int arr2: arr1)
                System.out.print(arr2+",");
            System.out.println("]");
        }
    }
    public static void main(String [] args){
        A Launcher = new A();
        Launcher.start();
    }

    public void start(){
        int m = 2147483647;
        int[][] rooms = {
                {m,-1,0,m},
                {m,m,m,-1},
                {m,-1,m,-1},
                {0,-1,m,m}
        };
        wallsAndGates(rooms);
        printarray(rooms);

        int[][] rooms1 = {};
        wallsAndGates(rooms1);
        printarray(rooms1);
    }
}