
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class characterReplacement {
     //Bruce force solution (time limited)
    public int replace(String s, int k){
        char[] c = s.toCharArray();
        int total =0;
        for(int i=0;i < c.length;i++){
          int z =i;
          
          while(z<c.length){ 
            
            Set<Character> set =new HashSet<>();
            boolean find =false;
            for(int ct=i; ct< z+1;ct++ ){
                set.add(c[ct]);
            }
            //System.out.println(i+" "+z+1);
            for(Character ch :set ){   
                    int tempk = 0;
                    int count =0;         
                    for(int t=i; t<z+1; t++){
                        if(ch == c[t]  )
                            count++;    
                        if(ch != c[t] ){
                            if(tempk <k)
                                count++;
                            tempk++; 
                        }
                         
                    }
                   if(count == z+1-i ){
                        total=Math.max(count,total);
                        if(tempk >k )
                            find =true;
                   }
                
            }
            if(find)
                break;
            z++;
        }

        }
        
        return total;
    }






    public int replace2(String s, int k){
        char[] c = s.toCharArray(); 
        Map<Character,Integer> m = new HashMap<>(); 
        
        
        int l =0;
        int total=0;
        int maxf =0;
        for(int r=0;r<c.length;r++ ){
            m.putIfAbsent(c[r],0);

            m.replace(c[r],m.get(c[r])+1); 
            int val = m.get(c[r]);
            
            maxf = Math.max(maxf,val);
            while(r-l+1 -maxf >  k){
                m.replace(c[l],m.get(c[l])-1);  
                int val2  =  m.get(c[l]);
                maxf = Math.max(maxf,val2);
                l++ ;
            }
            //System.out.println(l+" "+r);
            total = Math.max(r-l+1,total);
            
        }
        return total;

    }




}
