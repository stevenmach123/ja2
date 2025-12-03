import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class wordSearchII {
     class Trie {
        String word;
        boolean end;
        Map<Character,Trie> map  = new HashMap<>();
     }
     Trie trie = new Trie();  
     List<String> result = new LinkedList<String>();
      public List<String> findWords(char[][] board, String[] words) {    
        for(String word :words){
            var root = trie;
            String m = ""; 
            for(char c :word.toCharArray()){
                m += c;
                root.map.putIfAbsent(c,trie);
                root.map.get(c).word = m;   
                root = root.map.get(c);
            }
            root.end =true;
            
        }
        for(int x = 0;x <board.length;x++){
            for(int y = 0;y <board[0].length;y++){
                if(trie.map.containsKey(board[x][y]))
                    dfs(board,trie,x,y);
            }
        }
        return result;
    }
    void dfs(char[][] board,Trie root,int x,int y){
        if(root.end){
            result.add(root.word);
        }
        var moves = new int[][]{{1,0},{-1,0},{0,1},{0,-1}}; 
        for(var move : moves ){ 
            int nx =x +move[0]  ;int ny = y + move[1];
            var c = board[nx][ny]; 
            if(root.map.containsKey(c)){
                var nroot = trie.map.get(c);
                dfs(board, nroot,nx,ny);
             }
        }
    }
}







/*



dfs(int x,int y,Trie root){
  if(trie.end){
     result.add(trie.word);
  }
  var moves = int[][]{{1,0},{-1,0},{0,1},{0,-1}}; 
  for(var move : moves ){
     int nx =x +move[0]  ;int ny = y + move[1];
     var c = board[nx][ny];
     if(trie.contains() ){
        nroot = trie.map.get()
        dfs( nroot)
     }
  }
  
}






for(){
}


dps(x,y,cur,list_words,board){
   c = board[x][y];
   for(w : list_words){
     w.length ==cur
     
   }
  new_list
  for(w : list_words){
     if(w[cur] == c){
       
     }
  }
  4 side
  dps( cur++,new_list)
  

}
*/
