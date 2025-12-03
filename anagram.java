import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class anagram {
    public List<List<String>> groupAnagrams1(String[] strs) { 
        if (strs == null || strs.length == 0) return new ArrayList<>();

        Map<String,List<String>> col = new HashMap<>();
         
        for(String word:strs){
            char  key[] = new char[26]; 
            Arrays.fill(key,' ');
            
            for(char letter : word.toCharArray()){      
                if(key[letter-'a'] != ' '){
                    key[letter-'a']++; continue;
                }
                key[letter-'a'] = letter; 
                
            }   

            col.putIfAbsent(String.valueOf(key), new ArrayList<String>());
            col.get(String.valueOf(key)).add(word);
        
        }
      
        return new ArrayList<List<String>>(col.values());

    }


    public List<List<String>> groupAnagrams(String[] strs){
        if (strs == null || strs.length == 0) return new ArrayList<>();
        Map<String,List<String>> col = new HashMap<>();
        for(String word:strs){ 
            char[] ar = word.toCharArray();
            Arrays.sort(ar);
            col.putIfAbsent(String.valueOf(ar), new ArrayList<String>());
            col.get(String.valueOf(ar)).add(word); 
        }

        return new ArrayList<List<String>>(col.values());
    }
    
   





}
