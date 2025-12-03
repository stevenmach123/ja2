
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class minAreaRect {

    public int area(int[][] points){
        int area =Integer.MAX_VALUE;
        Map<Integer,Set<Integer>> map = new HashMap<>();
        for(int[] p :points){
            if(!map.containsKey(p[0]) ){
                map.put(p[0],new HashSet<Integer>(){{add(p[1]); }});
            }  
            else{
               map.get(p[0]).add(p[1]);}

        }

        for(int a=0;a< points.length;a++){
            for(int b=0;b< points.length;b++){
                if(points[a][0]==points[b][0] || points[a][1] == points[b][1] )
                    continue;
                
                if(!map.get(points[a][0]).contains(points[b][1]) || !map.get(points[b][0]).contains(points[a][1]) )
                    continue;
                area = Math.min(area,Math.abs(points[a][0]-points[b][0])  *Math.abs(points[a][1]-points[b][1]));    

            }
        }

        return  area == Integer.MAX_VALUE ? 0 : area; 
            
    }


    public int area2(int[][] points){
        int area =Integer.MAX_VALUE;
        Map<Integer,Set<Integer>> map = new HashMap<>(); 
        for(int[] p :points){
            if(!map.containsKey(p[1]) ){
                map.put(p[1],new HashSet<Integer>(){{add(p[0]); }});
            }  
            else
               map.get(p[1]).add(p[0]);
        }
    
    
        for(int[] p1 :points ){
            for(int[] p2:points){
                if(p1[0]!= p2[0] || p1[1] == p2[1])
                    continue;
            
                for( Integer x :map.get(p1[1]) ){
                    if(map.get(p2[1]).contains(x))
                       area = Math.min(area,Math.abs(p2[0]-x )*Math.abs(p2[1]-p1[1])) ;   
                }


            }
        }


        return  area == Integer.MAX_VALUE ? 0 : area; 


    }

    public int area2_2(int[][] points){ 
        int area =Integer.MAX_VALUE;
        Map<Integer,Set<Integer>> map = new HashMap<>();
        for(int[] p :points){
            if(!map.containsKey(p[0]) ){
                map.put(p[0],new HashSet<Integer>());
            }  
        
            map.get(p[0]).add(p[1]);

        }
        
        for(int[] p1 :points ){
            for(int[] p2:points){
                if(p1[1]!= p2[1] || p1[0] == p2[0])
                    continue ;

                for( Integer y :map.get(p2[0]) ){
                    if(map.get(p1[1]).contains(y))
                        area = Math.min(area,Math.abs(p2[1]-y )*Math.abs(p2[0]-p1[0])) ;   
 
                }   
                
            
            }
        }

        return  area == Integer.MAX_VALUE ? 0 : area; 



    }






    


}
