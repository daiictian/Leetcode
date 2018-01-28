class Solution {
    class Interval{
        int index;
        int start;
        int end;
        public Interval(int i, int s, int e){
            index = i;
            start = s;
            end = e;
        }
        public String toString(){
            return "[" + String.valueOf(start)+","+String.valueOf(end)+"]";
        }
    }
    class IntervalComp implements Comparator<Interval>{
        public int compare(Interval i1, Interval i2){
            return i1.start - i2.start;
        }
    }
    public String addBoldTag(String s, String[] dict) {
        List<Interval> intervals = new ArrayList<Interval>();
        int i  = 0;
        for (String str : dict) {
        	int index = -1;
        	index = s.indexOf(str, index);
        	while (index != -1) {
        		intervals.add(new Interval(i,index, index + str.length()));
        		index +=1;
        		index = s.indexOf(str, index);
        	}
        }
       // System.out.println(intervals);
        Collections.sort(intervals, new IntervalComp());
        LinkedList<Interval> merged = new LinkedList<Interval>();
        for (Interval interval : intervals) {
            if (merged.isEmpty() || merged.getLast().end < interval.start) {
                merged.add(interval);
            }
            else {
                
                merged.getLast().end = Math.max(merged.getLast().end, interval.end);
                
            }
        }
        
        StringBuilder result = new StringBuilder();
        Integer start = 0;
        Integer end = 0;
        int ind = 0;
        for(Interval ivl : merged){
            for(int j=end; j < ivl.start; j++){
                result.append(s.charAt(j));
            }
            result.append("<b>" + s.substring(ivl.start,ivl.end)+"</b>");
            end = ivl.end;
        }
        for(int j=end; j < s.length(); j++){
                result.append(s.charAt(j));
            }
        
        return result.toString();
        
        
        
    }
}
