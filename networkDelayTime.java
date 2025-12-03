
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class networkDelayTime {
   
   public int networkDelayTime(int[][] times, int n, int k) {
     Map<Integer,List<Integer[]>> m  = new HashMap<>();
     Deque<Integer[]> q  = new LinkedList<>();
      int graph[] = new int[n+1];Arrays.fill(graph, Integer.MAX_VALUE);
    
     for(int[] time :times){
        m.putIfAbsent(time[0],new LinkedList<>()) ;
        m.get(time[0]).add(new Integer[]{time[1],time[2]});
     }
     q.add(new Integer[]{k,0});
     while(!q.isEmpty()){
       Integer[] cur = q.poll();
       for(Integer[] node : m.get(cur[0]) ){
        int new_d  = cur[1]  + node[1];
        if(graph[node[0]] == Integer.MAX_VALUE || graph[node[0]] >new_d  ){
           graph[node[0]]  =new_d;
           q.add(new Integer[]{node[0],new_d});
        }
       }
       
     }
    int min =0;
    for(int i =1;i<n+1;i++ ){
      min = Math.max(min, graph[i]);
    }
    return min ==Integer.MAX_VALUE?-1: min;
     
   }




}


