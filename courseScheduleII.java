import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class courseScheduleII{
    LinkedList<Integer> result = new LinkedList<>();
    boolean cycle = false;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer,List<Integer>>  graph = new HashMap<>();
       int flag[] = new int[numCourses]; 
       if(prerequisites.length ==0){
            for(int i=0;i<numCourses;i++)
                result.add(i);
            return result.stream().mapToInt(v->v.intValue()).toArray();
       }
       for(int[] edge:prerequisites){
           graph.putIfAbsent(edge[0],new LinkedList<>());
           graph.get(edge[0]).add(edge[1]);
       }
       for(int course=0;course < numCourses;course++){
            if(!cycle)
                dps(graph,flag,course);
            else 
                return new int[]{};
       }
       return result.stream().mapToInt(v->v.intValue()).toArray();
    }
    public void dps(Map<Integer,List<Integer>> graph ,int[]flag,int course){
        if(graph.get(course) == null){
            if(!result.contains(course))
                result.addFirst(course);
            return;
        } 
        if(flag[course] == 2 || cycle ){
            cycle =true;
            return;
        }
        if(flag[course] == 1 ){
            return;
        }       
        flag[course] =2;  
        for(int node:graph.get(course)){
            dps(graph,flag,node);
        }
        flag[course] = 1;
        result.add(course);   
    }
}

 /*
    ar[] 
    map 
    for((s,d):prerequisites ){
        dps()
    }
    dps( ){
        //edge 
            //push ar[]
            
    }
    
*/