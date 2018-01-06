/*
This solution uses below approach.
Encoding part:
1. First concatenate all the Strings in the given list.
2. For each string, find the size of string and append each size at the end of the String formed in step 1, separated by #.
3. Append the number of Strings at the end of the String thus formed in step 2.

For example, if the list is [#1#, vishal#, #],
Then after executing Step1, the resulting String will be #1#vishal##.
Now we can see that the size of the Strings in the given list are 3,7 and 1 respectively. So, after executing Step 2, the resulting string will be #1#vishal###3#7#1#
Finally, in step 3, we can see that the size of list is 3, So the resulting String after executing Step 3 will be 
#1#vishal###3#7#1#3

Decoding part:
1. Find the number of Strings to be returned in the list. This will also give the number of #'s to be checked from end to find the size of each of the String in the list.
2. Once each of the String size is found, iterate over the encoded String from start and keep adding the substring of length equal to the ones found in step 1.

*/
class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        List<Integer> counter = new ArrayList<Integer>();
        for(String s : strs){
            sb.append(s);
            counter.add(s.length());
        }
        sb.append("#");
        for(Integer x : counter){
            sb.append(String.valueOf(x) + "#");
        }
        sb.append(String.valueOf(strs.size()));
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<Integer> counter = new ArrayList<Integer>();
        List<String> result = new ArrayList<String>();
        if(s.equals("0")){
            return result;
        }
        StringBuilder sb = new StringBuilder();
        int index = s.length()-1;
        while(s.charAt(index) != '#'){
            sb.append(s.charAt(index));
            index--;
        }
        //System.out.println("SSSSSS " +s);
        index--;
        sb.reverse();
        int count = Integer.valueOf(sb.toString());
        int c = 0;
        sb = new StringBuilder();
        while(c != count){
            if(index >= 0 && s.charAt(index) != '#'){
                sb.append(s.charAt(index));
            }else{
                sb.reverse();
                counter.add(0,Integer.valueOf(sb.toString()));
                sb = new StringBuilder();
                c++;
            }
            index--;
        }
        int start = 0;
        int end = 0;
        for(Integer yoyo : counter){
            end = end + yoyo;
            result.add(s.substring(start,end));
            start = end;
        }
        return result;

    }
}
