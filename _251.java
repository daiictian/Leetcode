public class Vector2D implements Iterator<Integer> {
    
    List<Integer> result;
    List<List<Integer>> nested;
    Iterator<Integer> itr;
    public Vector2D(List<List<Integer>> vec2d) {
        result = new ArrayList<Integer>();
        nested = vec2d;
        expand();
    }
    
    private void expand(){
        int index = -1;
        for(List<Integer> list : nested){
            for(int i=0; i < list.size(); i++){
                result.add(list.get(i));
            }
        }
        itr = result.iterator();
    }

    @Override
    public Integer next() {
        return itr.next();
    }

    @Override
    public boolean hasNext() {
        return itr.hasNext();
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */
