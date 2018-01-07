class Solution {
    class Comp implements Comparator<String>{
        public int compare(String s1, String s2){
            String a = s1+s2;
            String b = s2+s1;
            if(a.compareTo(b) > 0){
                return -1;
            }else{
                return +1;
            }
        }
    }
    public String largestNumber(int[] nums) {
        List<String> temp = new ArrayList<String>();
        for(int i=0; i < nums.length; i++){
            temp.add(String.valueOf(nums[i]));
        }
        Collections.sort(temp, new Comp());
        StringBuilder sb = new StringBuilder();
        for(String s : temp){
            sb.append(s);
        }
        String result = sb.toString();
        result = result.replaceAll("^0+","0");
        return result;
    }
}
