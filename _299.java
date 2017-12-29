import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by vishal on 29/12/17.
 */
class Solution {
    public String getHint(String secret, String guess) {
        int numAs = 0;
        int numBs = 0;
        Map<Character,Integer> M = new HashMap<Character,Integer>();
        for(int i=0; i < secret.length(); i++){
            M.put(secret.charAt(i),M.getOrDefault(secret.charAt(i),0)+1);
        }
        Set<Integer> visited = new HashSet<Integer>();
        for(int i=0; i < guess.length(); i++){
            if(guess.charAt(i) == secret.charAt(i)){
                visited.add(i);
                numAs++;
                int x = M.get(secret.charAt(i));
                x--;
                M.put(secret.charAt(i),x);
            }
        }

        for(int i=0; i < guess.length(); i++){
            if(M.containsKey(guess.charAt(i)) && M.get(guess.charAt(i)) > 0 && visited.add(i)){
                int x = M.get(guess.charAt(i));
                x--;
                M.put(guess.charAt(i),x);
                numBs++;
            }
        }
        return String.valueOf(numAs)+"A"+String.valueOf(numBs)+"B";



    }
}
