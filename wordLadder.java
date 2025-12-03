
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class wordLadder {

    Map<String,List<String>> v = new HashMap<>();

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        for(String word:wordList  ){
            for(int i=0 ;i<word.length();i++ ){
                String aa =word.substring(0, i) + "*"+ word.substring(i+1, word.length());
                v.putIfAbsent(aa, new LinkedList<>());
                v.get(aa).add(word);
            }

        }
         
        Deque<Pair> q = new LinkedList<>();
        Set<String> check = new HashSet<>();
        q.add(new Pair(beginWord,0));
        check.add(beginWord);
        while(!q.isEmpty()){
            Pair pair = q.poll();
            check.add(pair.word);
            if(pair.word.equals(endWord))
                return pair.step+1;
            for(int i=0 ;i< pair.word.length();i++){
                String aa =pair.word.substring(0, i) + "*"+ pair.word.substring(i+1, beginWord.length());
                if(v.containsKey(aa)){
                    for(String word : v.get(aa)){
                        if(!check.contains(word))
                            q.add(new Pair(word,pair.step+1));
                    }
                }

            }
            
        }
       
        
        return 0;
    }
    
    class Pair{
        String word;
        int step;
        Pair(String word,int step){
            this.word  =word;
            this.step =step;
        }
    }
   
   
        
}

