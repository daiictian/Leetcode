class Solution {
    public int[] findPermutation(String s) {
          List<Integer> yo = new ArrayList<Integer>();
        for(int i=1; i <= s.length()+1; i++){
            yo.add(i);
        }
        int[] result = new int[yo.size()];
        int index = -1;
        int contD = 0;
        int contI = 0;
        if(s.charAt(0) == 'D'){
            contD++;
        }else{
            contI++;
        }
        for(int i=1; i < s.length(); i++){
            if(s.charAt(i) == 'D'){
                contD++;
                int hehe = 0;
                while(hehe < contI){
                   // System.out.println("hehe " + hehe + " " + yo.get(hehe));
                    result[++index] = yo.remove(0);
                    hehe++;
                }
                contI = 0;
               
            }else{
                contI++;
                 while(contD > 0){
                    result[++index] = yo.remove(contD);
                    contD--;
                }
                contD = 0;
                
            }
           // System.out.println(yo);
        }
                while(contD >= 0){
                    result[++index] = yo.remove(contD);
                    contD--;
                }
        int hehe = 0;
        while(hehe < contI){
                   // System.out.println("hehe " + hehe + " " + yo.get(hehe));
                    result[++index] = yo.remove(0);
                    hehe++;
                }
        return result;
    }
}
