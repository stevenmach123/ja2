
import java.util.HashSet;
import java.util.Set;

public  class longestSubstringWithout {
    public boolean dup(String s, int f,int z){
        Set<Character> c = new HashSet<>();
        for(char l: s.substring(z,f).toCharArray()){
             if(c.contains(l))
                 return true;   
             c.add(l);
        }
        return false;
     }
     public int lengthOfLongestSubstring(String s) {
        
          int f=1;
          int z=0;
          int max=0; 
          while(f<=s.length()){
             if(dup(s,f,z)){
                 z++;f++;
                 continue; 
             }
             while(f <= s.length() && !dup(s,f,z)){
                 max = Math.max(max,f-z);
                f++;
             }
          }
          return max;
     }


    
}
