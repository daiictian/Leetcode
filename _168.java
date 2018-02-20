class Solution {
    public String convertToTitle(int n) {
        char[] chars = new char[27];
        StringBuilder sb = new StringBuilder();
        char x = 'A';
        for(int i=1; i < chars.length; i++){
            chars[i] = x;
            x++;
        }
        
        return rec(n,chars);
    }
    
    private String rec(int n, char[] map){
        if(n <= 26){
            return String.valueOf(map[n]);
        }
        int x = n%26;
        if(x == 0){
            x = 26;
        }
        int y = (n - x)/26;
        return rec(y,map)+String.valueOf(map[x]);
    }
}
