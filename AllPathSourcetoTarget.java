import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class AllPathSourcetoTarget {
    public List<List<Integer>> path1(int[][] graph) {
        
        Stack<List<Integer>> sta = new Stack<>();  
        List<List<Integer>> result = new  LinkedList<List<Integer>>();
       
        sta.add(new ArrayList<Integer>(Arrays.asList(0))  );  
        while(!sta.isEmpty() ){
            List<Integer>  va = sta.pop();
     
            for(int target: graph[va.get(va.size()-1) ] ){
                List<Integer> path = new LinkedList<>(va); 
                path.add(target);
                if(target == graph.length -1  ){
                    result.add(path);
                }
                else{
                    sta.push(path);  
                }
                
                
            }
        
            
        }
        

        return result;
        

        
    }

    public List<List<Integer>> path2(int[][] graph) {
        return list2(graph,0);
        

    }
    List<List<Integer>> list2(int[][] graph,int tar){
        List<List<Integer>> result = new  LinkedList<List<Integer>>();

        if(tar == graph.length-1 ){
            result.add(new LinkedList<Integer>(Arrays.asList(tar)) );
            return result;
        }

        for(int target: graph[tar]){
            
            List<List<Integer>> a = list2(graph,target); 

            for(List<Integer> path: a ){
               
                path.add(0,tar);
                result.add(path);
            }
    

        }
        return result;
 
        
    }
    
    // enhance version of path1 
    public List<List<Integer>> path11(int[][] graph){
        Stack<List<Integer>> s = new Stack<>();
        List<List<Integer>> result  = new LinkedList<>();
        
        s.push(Arrays.asList(0));
        while(!s.isEmpty()){
            List<Integer> node = s.pop();  
            int tar = node.get(node.size()-1);
            if(tar == graph.length-1){
                List<Integer> com = new LinkedList<>(node);
                result.add(com) ;
                continue;
            }
            for(Integer new_node : graph[tar] ){
                List<Integer> com = new LinkedList<>(node);
                com.add(new_node);
                s.push(com);
            }
            
        }

        return result;
        
    }


   

       
}
