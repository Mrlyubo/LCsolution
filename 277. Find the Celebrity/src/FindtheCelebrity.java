import javax.management.relation.Relation;

/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

 class A  {
     /**Each time the first pass can reduce one candidate:
     If candidate knows i, then i is possible and candidate is reduced.
     If candidate doesn't know i, then candidate is still possible and i is reduced.
     Then in the second pass we judge if the candidate is valid.
      */
      boolean[][] party = new boolean[][]{
                {false,false,true,true,true},
                {true,false,true,true,true},
                {false,false,false,true,true},
                {false,false,false,false,true},
                {false,false,false,false,false},
        };

        public boolean knows(boolean[][] party,int a, int b){
            return party[a][b];
        }

        public int findCelebrity(int n) {//
            int candidate = 0;
            for(int i = 1; i < n; i++){
                if(knows(party,candidate, i))
                    candidate = i;
            }
            for(int i = 0; i < n; i++){
                if(i != candidate && (knows(party,candidate, i) ||
                        !knows(party,i, candidate)))
                    return -1;
            }
            return candidate;
        }

        public static void main(String [] args){
            A Launcher = new A();
            Launcher.start();
        }
        public void start(){
            int n =5;
            System.out.println( findCelebrity(n) );
        }
 }

