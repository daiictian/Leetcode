class Trie {

    /** Initialize your data structure here. */
    class TrieNode{
        TrieNode[] children;
        Character value;
        boolean isEnd;
        public TrieNode(Character c){
            children = new TrieNode[26];
            value = c;
        }
    }
    TrieNode root;
    public Trie() {
        root = new TrieNode(null);
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode curr = root;
        for(int i=0; i < word.length(); i++){
            char c = word.charAt(i);
            if(curr.children[c-'a'] == null){
                curr.children[c-'a'] = new TrieNode(c);
                curr = curr.children[c-'a'];

            }else{
                curr = curr.children[c-'a'];
            }
        }
        curr.isEnd = true;

    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode curr = root;
        for(int i=0; i < word.length(); i++){
            char c = word.charAt(i);
            if(curr.children[c-'a'] == null){
                return false;

            }else{
                if(curr.children[c-'a'].value == c){
                    curr = curr.children[c-'a'];
                }else{
                    return false;
                }
            }
        }
        return curr.isEnd;

    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(int i=0; i < prefix.length(); i++){
            char c = prefix.charAt(i);
            if(curr.children[c-'a']== null){
                return false;

            }else{
                if(curr.children[c-'a'].value == c){
                    curr = curr.children[c-'a'];
                }else{
                    return false;
                }
            }
        }
        return true;

    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
