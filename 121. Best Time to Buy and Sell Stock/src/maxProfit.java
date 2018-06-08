class A {
    // Better Approach: is very easy, no need to record the best buy day or the best sell day.
    //Just store the current best buy price.

    public int maxProfit(int[] prices) {
        int max= 0 ;
        if(prices.length==0)
            return 0 ;
        int minbuyprice = prices[0];

        for(int i = 0 ;i < prices.length  ;i++)
        {
            if(prices[i]<minbuyprice )
                minbuyprice =prices[i];
            else
                //   max = Math.max(prices[i]-minbuyprice,max);
                max = max > prices[i]-minbuyprice ? max : prices[i]-minbuyprice ;
        }
        return max ;
    }

    //My Approach : use two for loops. one the compute the best sell day for every buy day i.
    //Another loop is to compare for res in different buy day.

    public int maxProfit1(int[] prices) {
        int res = 0;
        int n = prices.length;
        if( n < 2) return 0;
        int[] sellday = new int[n-1];
        sellday[n-2] = n-1;
        if( n >= 3 ){
            for(int i = n-3; i >= 0; i--){
                if(prices[i+1] > prices[sellday[i+1]])
                    sellday[i] = i+1;
                else sellday[i] = sellday[i+1];
             }
        }
        for(int i = 0; i < n-1; i++)
            res = Math.max( prices[sellday[i]] - prices[i],res );
        return res;
    }

    public static void main(String [] args){
        A Launcher = new A();
        Launcher.start();
    }
    public void start(){
        int[] prices = new int[]{1,10,1,5,4,3,2};
        int[] prices1= new int[]{7,1,5,3,6,4};
        int[] prices2 = new int[]{2,1,2,1,0,0,1};

        System.out.println(maxProfit(prices));
        System.out.println(maxProfit(prices1));
        System.out.println(maxProfit(prices2));
    }
}