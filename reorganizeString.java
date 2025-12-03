
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
public class reorganizeString {
   // https://leetcode.com/problems/reorganize-string/solutions/3950350/easy-java-solution/


   // my way, kinna slow :)
   public String reorganize(String s) {

    PriorityQueue<Pair> pq = new PriorityQueue<>((Pair a, Pair b) -> b.appear - a.appear);
    Map<Character,Integer> v = new HashMap<>(); 
   
    String result = ""; 
    for(char c : s.toCharArray()){
        v.putIfAbsent(c, 0);
        v.replace(c,v.get(c)+1);
    }
    v.forEach((key,value)->{
        pq.add(new Pair(key,value));
});

    while(!pq.isEmpty()){
        List<Pair> temp  =new LinkedList<>(); 
        if(pq.size()==1 && pq.peek().appear>1)
            return "";
        for(int i =0;i<2;i++){
            if(pq.isEmpty())
                break;
            Pair p  = pq.poll();
           
            int val = v.get(p.key)-1;
            v.replace(p.key, val);
            temp.add(new Pair(p.key,val));
            result += p.key;
        }
        temp.forEach((u)->{
            if( u.appear > 0)
                pq.add(u);
        });
        
    }
    return result;
        
   }


   public String reorganize2(String s){

        PriorityQueue<Pair> pq = new PriorityQueue<>((Pair a, Pair b) -> b.appear - a.appear);
        Map<Character,Integer> v = new HashMap<>(); 
        String result = ""; 
        for(char c : s.toCharArray()){
            v.putIfAbsent(c, 0);
            v.replace(c,v.get(c)+1);
        }
        v.forEach((key,value)->{
            pq.add(new Pair(key,value));
        });
        Pair prev=null;
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            p.appear--;
            result  += p.key;
            if(prev.appear >0 && prev !=null){
                pq.add(prev);
            }
            prev = p;
        }
        return result;

   }





   class Pair{
     char key;
     int appear;
     Pair(char key,int appear){
        this.key  =key;
        this.appear = appear;
     }
   }
}
