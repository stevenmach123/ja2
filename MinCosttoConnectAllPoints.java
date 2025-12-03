
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class MinCosttoConnectAllPoints {
     int distance(int[][] points,int a,int b){
        return Math.abs(points[a][0]-points[b][0]) + Math.abs(points[a][1]-points[b][1]);
     } 
    public int cost1(int[][] points){
        int n =points.length;
        HashSet<Integer>  mst = new HashSet<>();
        int[] pointd  =  new int[n];
        int cur = 0; 
        int total =0; 
        mst.add(0);
        for(int i=0;i< n;i++){
            pointd[i]= distance(points,0,i);
        }
        while(mst.size() != n ){
            int next =Integer.MAX_VALUE;
            for(int i=0;i< n;i++){
                if(mst.contains(i))
                    continue;
                if(pointd[i] <= next){
                    next =pointd[i];
                    cur = i;
                }

            }
            total +=pointd[cur]; 
            mst.add(cur);
            for(int i=0;i<n;n++){
                pointd[i] = Math.min(pointd[i],distance(points,cur,i));

            }

        }
        return total; 
    
    }

  






     
     public int cost2(int[][] points){
        int n =points.length;
        int total =0;
        int cur=0;
        HashSet<Integer>  mst = new HashSet<>();
        PriorityQueue<Map.Entry<Integer,Integer>> que = new PriorityQueue<>((a,b) ->a.getValue()-b.getValue());
        mst.add(0);
        
        while(mst.size() !=n){
        
            for(int i=0;i< n;i++){ 
                if(!mst.contains(i)){
                    que.add(new AbstractMap.SimpleEntry<Integer,Integer>(i,distance(points,cur,i)));
                }
            }
            while(mst.contains(que.peek().getKey()) ){
                que.poll();
            }
            Map.Entry<Integer,Integer> node =que.poll();
            if(node ==null) break; //not necessary since last node, can be top, alone, or below of others
            total +=node.getValue();
            cur = node.getKey();
            mst.add(cur);

        }

        return total;

     }

    


     public class U{
        int[] connect;
        public U(int n){
            connect = new int[n];
            for(int i=0;i<n;i++){
                connect[i] =i;
            }
        }
        int find(int a){
            if(connect[a] != a)
                connect[a] = connect[find(a)];
            return a;
        }
        boolean union(int a, int b){
            if(find(a) != find(b)){
                connect[find(a)] = connect[b] ;
                return false;
            }
            return true;
        }
        
     }

     public int cost3(int[][] points){
        int n =points.length;
        int total = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[2]-b[2] );
        
        U union = new U(points.length);
        for(int a =0;a<n-1;a++ ){
            for(int b=a+1 ;b<n ;b++){
                pq.add(new int[]{a,b,distance(points, a, b)});
            }
        }
        
        System.out.print(pq.stream().map(x->Arrays.stream(x).boxed().toArray(Integer[]::new) ).collect(Collectors.toList()));
    
            
    
        while(!pq.isEmpty()){
            int[] r= pq.poll();
            if(!union.union(r[0],r[1])){
                total += r[2];
            }
        }
        return total ;
        
     }










}
