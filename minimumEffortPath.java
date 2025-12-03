
import java.util.Arrays;
import java.util.PriorityQueue;

public class minimumEffortPath {
    // dijikstra 
    public int effort(int[][]heights){
        int rx = heights.length;int cx =heights[0].length; 

        int[][] dist = new int[rx][cx];
        int act[][]  = new int[][]{{0,-1},{0,1},{1,0},{-1,0}};
        for(int i=0;i<rx;i++){
            Arrays.fill(dist[i],Integer.MAX_VALUE); 
        }
        PriorityQueue<Integer[]>  que= new PriorityQueue<>((a,b)-> a[2]-b[2]);
        que.add(new Integer[]{0,0,0});
        dist[0][0]=0;
        
        while(!que.isEmpty()){
            Integer[] cur =que.poll();
            int rp =cur[0];int cp=cur[1];
            
            for(int[] move: act ){
            
                int rn = rp+move[0];int cn= cp+move[1];
                if(rn <0 || rn>=rx || cn <0 || cn >=cx)
                    continue;
                
                int distDiff = Math.max(dist[rp][cp], Math.abs(heights[rn][cn] -heights[rp][cp]));
                //System.out.println(rp+" "+cp+" "+distDiff);
                if(distDiff < dist[rn][cn]){   
                    dist[rn][cn] = distDiff;
                    que.add(new Integer[]{rn,cn,distDiff});
                }
            }
        }
        
        return dist[rx-1][cx-1];
        
        

    }



    // similar to effort, but modify when to check dist with temp dist
    public int effort2(int[][] heights) {
        int moves[][] =new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        int dist[][] = new int[heights.length][heights[0].length];
        for(int i=0;i<heights.length;++i){
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        }

        PriorityQueue<Integer[]> queue = new PriorityQueue<>((a,b)->a[2]-b[2]);

        queue.offer(new Integer[]{0,0,0});
    
        while(!queue.isEmpty()){
            Integer[] state = queue.remove();
            if(state[2] >= dist[state[0]][state[1]] )
                continue;
            dist[state[0]][state[1]]  = state[2];
            for(int[] move : moves ){
                 int nr = state[0] + move[0] ;
                 int nc =   state[1] + move[1];
                 if(nr < 0 || nr >=  heights.length|| nc < 0 || nc >= heights[0].length )
                    continue;
                int val  =Math.abs(heights[state[0]][state[1]]-heights[nr][nc]);
                queue.offer(new Integer[]{nr,nc,Math.max(val,dist[nr][nc] )}); 
                 
            }

        }
        return dist[heights.length-1][heights[0].length-1];
        
    }



    public int effort21(int[][] heights) { 
        int[][] dist = new int[heights.length][heights[0].length] ;
        PriorityQueue<Integer[]> pq  = new PriorityQueue<>((a,b)->a[2]-b[2]);
        int moves[][] = {{0,1},{1,0},{-1,0},{0,-1}};
        pq.add(new Integer[]{0,0,heights[0][0]});
        for(int i=0;i<heights.length;++i){
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        }
        while(!pq.isEmpty()){
            Integer[] cur = pq.poll();
            int cur_r= cur[0]; int cur_c = cur[1];
            
            for(int[] move: moves ){
                int nr = cur_r +move[0];
                int nc = cur_c+move[1];
                if(nr < 0|| nr >= heights.length || nc <0 || nc >= heights[0].length )
                    continue;
                int diff = Math.abs(heights[nr][nc] - heights[cur_r][cur_c]);
                if(dist[nr][nc] > diff ){
                    dist[nr][nc] = diff;
                    pq.add(new Integer[]{nr,nc,dist[nr][nc]});
                }
                
            }
            
        }
        return dist[heights.length-1][heights[0].length-1];
    }


    






    
}
