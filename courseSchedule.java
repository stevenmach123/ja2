import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class courseSchedule {

    Map<Integer,Set<Integer>> m ;
    List<Integer> cl ;
    boolean visit[]; 
    boolean status[];
    
   public boolean canFinish(int numCourses, int[][] prerequisites) {
        int [][] pre = prerequisites ;
        m = new HashMap<>();
        if(prerequisites.length ==0) return true;

        for(int i=0;i< pre.length; i++){
            m.putIfAbsent(pre[i][0], new HashSet<Integer>()) ;
            m.get(pre[i][0]).add(pre[i][1]); 
            
        }
        
        visit = new boolean[numCourses];
        status = new boolean[numCourses];
        
        for(int node=0;node<numCourses;node++ ){
            if(!visit[node] && !direct(numCourses,pre,node) )
                return false;
        }
        return true;

    } 
    boolean direct(int numCourses,int[][] pre,int node){
        if(visit[node]){
            if(status[node]) return true;
            else return false;
        }
        visit[node] = true;
        if(!m.containsKey(node)){
            status[node] =true; 
            return true;
        }
        Iterator<Integer> nodes = m.get(node).iterator();
        while(nodes.hasNext()){
            int parent = nodes.next(); 
            if(!direct(numCourses,pre,parent)) return false;
        }
        
        status[node] =true;
        return true;
    }


    

    public boolean canFinish4(int numCourses, int[][] prerequisites) {     
       for(int[]pair :prerequisites){
             m.putIfAbsent(pair[1],new HashSet<Integer>());
             m.get(pair[1]).add(pair[0]);
        }
        Integer[] check = new Integer[numCourses];
        for(int node=0;node < check.length;node++){
            if(m.get(node) !=null &&check[node] !=1 && !direct(check,node))
                return false;
        } 
        return true;
       
    }
    boolean direct(Integer[] check,int node){
        if(check[node]==2)
            return false;
        check[node] = 2; 
        for(Integer child :m.get(node)){
            if(m.get(child) != null &&check[child] !=1  && !direct(check,child)){
             return false; 
            }
        }
        check[node] =1;

        return true;
    }
  

    
        
    




}
