import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<List<String>>();
        return rec(s,0,result);

    }

    private List<List<String>> rec(String s, int start, List<List<String>> result){
        if(start == s.length()){
            //result.remove(result.size()-1);
            return new ArrayList<List<String>>();
        }
        if(start == s.length()-1){
            List<String> yo = new ArrayList<String>();
            yo.add(String.valueOf(s.charAt(start)));
            result.add(0,yo);
            return result;
        }
        Set<List<String>> temp = new HashSet<List<String>>();
        for(int i= start; i < s.length(); i++){
            if(isP(s,start,i)){
                String s2 = s.substring(start,i+1);
                List<List<String>> yoyo = rec(s,i+1,result);
                for(List<String> ss : yoyo){
                    List<String> achha = new ArrayList<String>(ss);
                    achha.add(0,s2);
                    temp.add(achha);
                }
                if(yoyo.size() == 0){
                    List<String> achha = new ArrayList<String>();
                    achha.add(0,s2);
                    temp.add(achha);
                }
            }
        }
        return new ArrayList<List<String>>(temp);
    }

    private boolean isP(String s, int start, int end){
        if(start >= end){
            return true;
        }
        if(s.charAt(start) == s.charAt(end)){
            return isP(s,start+1,end-1);
        }else{
            return false;
        }

    }




}
