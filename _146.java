class LRUCache {
    int size;
    class DataNode{
        int key;
        int val;
        public DataNode(int ke, int va){
            val = va;
            key = ke;
        }
    }
    LinkedList<DataNode> cache;
    Map<Integer, DataNode> m;
    public LRUCache(int capacity) {
        size = capacity;
        cache = new LinkedList<DataNode>();
        m = new HashMap<Integer,DataNode>();
    }
    
    public int get(int key) {
        if(m.get(key) == null){
            
            return -1;
        }
        DataNode x = m.get(key);
        cache.remove(x);
        cache.offerFirst(x);
        //m.put(key,x);
        return x.val;
    }
    
    public void put(int key, int value) {
        if(cache.size() == size){
            //DataNode x = cache.get(size-1);
            //System.out.println("cache size " + cache.size() + " " + value);
            //System.out.println("removing " + cache.size() + " " + cache.get(size-1).val);
            if(m.get(key) == null){
            DataNode x = cache.removeLast();
            m.remove(x.key);
            DataNode dd = new DataNode(key,value);
            cache.offerFirst(dd);
            m.put(key,dd);
            }else{
                DataNode x = m.get(key);
                x.val = value;
                //DataNode y = cache.removeLast();
                //m.remove(y.key);
                cache.remove(x);
                cache.offerFirst(x);
                m.put(key,x);
                
            }
        }else{
            if(m.get(key) == null){
            DataNode dd = new DataNode(key,value);
            cache.offerFirst(dd);
            m.put(key,dd);
            }else{
                DataNode x = m.get(key);
                x.val = value;
                //DataNode y = cache.removeLast();
                //m.remove(y.key);
                cache.remove(x);
                cache.offerFirst(x);
                m.put(key,x);
            }
        }
        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
