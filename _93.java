import java.util.ArrayList;
import java.util.List;
/*
The idea is to find solution in the given String by placing three dots (at all possible locations in the string) 
and adding to result if any such placement is valid as per the syntax of an IP address
 */
class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<String>();
        if(s.length() > 12){
            return result;
        }
        return rec(s,result,0,3);

    }

    private List<String> rec(String s, List<String> result, int start, int count){

        if(start >= s.length()){
            return new ArrayList<String>();
        }

        if(count == 0){
            if(s.substring(start,s.length()).length() > 3)return new ArrayList<String>();
            if(s.substring(start,s.length()).length() > 1 && s.substring(start,s.length()).charAt(0) == '0')return new ArrayList<String>();
            int x = Integer.valueOf(s.substring(start,s.length()));
            if(x >= 0 && x <= 255){
                result.add(s.substring(start,s.length()));
                return result;
            }else{
                return new ArrayList<String>();
            }
        }

        List<String> achha = new ArrayList<String>();
        for(int i=start; i < s.length(); i++){
            String s2 = s.substring(start,i+1);
            if(s2.length() > 3 || s2.length() == 0) continue;
            if(s2.length() > 1 && s2.charAt(0) == '0') continue;
            int x = Integer.valueOf(s2);
            if(x >= 0 && x <= 255){
                List<String> ss = rec(s,result,i+1,count-1);
                if(ss.size() >0){
                    for(String yoyo : ss){
                        String yoyo2 = String.valueOf(s2) + "."+yoyo;
                        achha.add(yoyo2);
                    }
                    ss.remove(0);
                }
            }
        }
        return achha;

    }
}
