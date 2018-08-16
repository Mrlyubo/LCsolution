    public static void main(String[] args) {
        Solution Launcher = new Solution();
        Launcher.start();
    }

    public void start() {

    }

    public void printarray (int[] A) {
        System.out.print("{");
        for(int i: A)
            System.out.print(i+",");
        System.out.println("}");
    }
