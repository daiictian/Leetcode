/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    List<Integer> res;
    Iterator<Integer> haha;
    public NestedIterator(List<NestedInteger> nestedList) {
        
        res = new ArrayList<Integer>();
        rec(nestedList,0);
        haha = res.iterator();
    }

    @Override
    public Integer next() {  
        return haha.next();
    }

    @Override
    public boolean hasNext() {
        return haha.hasNext();
    }
    
    private void rec(List<NestedInteger> nestedList, int id){
        if(id >= nestedList.size()) return;
        NestedInteger yo = nestedList.get(id);
        if(yo.isInteger()){
            res.add(yo.getInteger());
        }else{
            List<NestedInteger> alpha = yo.getList();
            rec(alpha,0);
        }
        rec(nestedList,id+1);
        
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
