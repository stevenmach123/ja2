
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
public class taskScheduler {
    
    public int interval1(char[] tasks, int n){
    
        PriorityQueue<Map.Entry<Object,Integer>> que  = new PriorityQueue<>( (a,b) ->b.getValue()- a.getValue());
        Map<Object,Integer> uni = new HashMap<>();
       
        for(char label: tasks ){
            if(uni.containsKey(label)){
                uni.replace(label,uni.get(label)+1);
            }
            else {
                uni.put(label,1);
            }
        }
        que.addAll(uni.entrySet()); 
        int count =0;
        while(!que.isEmpty()){
            int k;
            List<Map.Entry<Object,Integer>> temp = new ArrayList<Map.Entry<Object,Integer>>();
            for(k=n+1; k> 0 && !que.isEmpty(); k--){
                Map.Entry<Object,Integer> task =  que.poll();
                task.setValue(task.getValue()-1);
                temp.add(task);
                count++;
            }
            for(Map.Entry<Object,Integer> l : temp ){
                if(l.getValue() >0) que.add(l);
            }
            

            count = que.isEmpty()?count:count+ k;


        }
            
    

        return  count;
         
    }
    public int interval2(char[] tasks, int n){
        PriorityQueue<Integer> que= new PriorityQueue<>((a,b)->b-a);
        Map<Object,Integer> uni = new HashMap<>();
       
        for(char label: tasks ){
            if(uni.containsKey(label)){
                uni.replace(label,uni.get(label)+1);
            }
            else {
                uni.put(label,1);
            }
        }
        que.addAll(uni.values());
        Map<Integer,Integer> cooldown= new HashMap<>();
        int cool = n+1;
        int count =0;
        int que0 =0; 
        while(!que.isEmpty() || !cooldown.isEmpty()){
            if(cooldown.containsKey(count-cool)){
           
                que.add(cooldown.remove(count-cool));
            }
            
            if(!que.isEmpty()){
               int va=  que.poll();
               if(count>= 0 && que.size()==0) que0++;
                    
               if(va >0) cooldown.put(count,va-1);
            }
            count++;

        }
        if(cool >= uni.size() ){
            return count -cool;
        } 
        else{
            if(que0 >1) return count-cool;
            return count-uni.size();
        }
        




    }
    
    
    
}
 class Pair {
    char key;
    int appear;
    Pair(char key, int appear){
        this.key = key;
        this.appear = appear;
    }
  }
