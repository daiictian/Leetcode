/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */
/*
If A knows B, then A is definitely not the celebrity(possibly B)
If A does not know B :
a) If B knows A, then B is definitely not the celebrity(possibly A)
b) If B does not know A, then both are not the celebrity

The above logic is handled in first for loop.

To verify if the first loop found the correct celebrity, we just run over the people again (in the second for loop) to check if the other n-1 people know the assumed celebrity.

Also, it might be possible that we did not find any celebrity in the first loop and could have overflown the number of people. In that case we need to return -1.
*/
public class Solution extends Relation {

    public int findCelebrity(int n) {
        Integer celebrity = 0;
        for(int i=1; i < n; i++){
            if(knows(celebrity,i)){
                celebrity = i;
            }else{
                if(!knows(i,celebrity)){
                    celebrity = i+1;
                }
            }
        }
        boolean know = true;
        if(celebrity >= n){return -1;}
        if(celebrity < n && knows(celebrity,0) && celebrity != 0) return -1;
        for(int i=0; i < n; i++){
            if(celebrity == i) continue;
            if(!knows(i,celebrity)) return -1;
        }


        return celebrity;

    }
}
