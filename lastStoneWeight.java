
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class lastStoneWeight{
    int weight(int[] stones){
        List<Integer> li= Arrays.stream(stones).boxed().collect(Collectors.toList());
        Collections.sort(li);
        
        while(li.size() >1){
            int s1 = li.remove(li.size()-1);
            int s2 = li.remove(li.size()-1);
            li.add(Math.abs(s1-s2));
            Collections.sort(li); 
        }
        return li.get(0);
        

    }
   
    

}