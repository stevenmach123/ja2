import java.util.HashMap;
import java.util.Map;

class Trie{
    Map<Character,Trie> map = new HashMap<>();
    boolean end =false;
}

public class SearchAddWords {
    Trie root;
    public SearchAddWords() {
        root = new Trie(); 
    } 
    public void addWord(String word) {
        Trie cur =root;
        for(char c : word.toCharArray()){
            if(!cur.map.containsKey(c)){
                cur.map.put(c,new Trie());
            }
            cur = cur.map.get(c); 
                
        }
        cur.end = true;
        
    }

    public boolean search(String word) {
        int n=word.length();
        return help(word,root,0,n);
    
       
    } 
    boolean help(String word,Trie root,int i,int n){
        if(i ==n ){
            if(root.end) return true;
            else return false;
        } 
        char c = word.charAt(i);
         
        if(c != '.' ){
            if(!root.map.containsKey(c))
                return false; 
            return help(word,root.map.get(c),i+1,n);
        }else{
            boolean res = false; 
            for(Map.Entry<Character,Trie> sub: root.map.entrySet() ){
                res = res || help(word,sub.getValue(),i+1,n);
                
            }
            return res; 
        } 
    } 
            
        








        
        public void addWord2(String word) {
            Trie cur  = root; 
            for(char c : word.toCharArray()){
                cur.map.put(c,new Trie());
                cur = cur.map.get(c);
            }
            cur.end = true;
        }
       
        public boolean search2(String word) {
           return help2(root,word,0,word.length());
        
        }
        boolean help2(Trie node,String word,int idx,int n){    
            if(idx == n){
                return node.end;
            }
                
            if(word.charAt(idx) == '.'){ 
                for(Map.Entry<Character,Trie> val : node.map.entrySet()){
                    if(help2(val.getValue(),word,idx+1,n))
                        return true;
                }
                return false;
            }
            else{
                if(!node.map.containsKey(word.charAt(idx)))
                    return false;   

                Trie mytrie = node.map.get(word.charAt(idx));
                return help2(mytrie,word,idx+1,n);
            }
            

        }



















    }
    /* ab..c.e */

    


