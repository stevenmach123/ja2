
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class numberOfIsland {
    public int num1(char[][] grid) {
        int[] a = new int[1];
        
        int r= grid.length;
        int c= grid[0].length;
        int count =0;
        for(int x=0;x<r; x++  ){
            for(int y=0;y<c;y++){
                if(grid[x][y] == ' ' || grid[x][y] =='0' )
                    continue;
                num1(grid,x,y);
                count++;

            }
        }

        return count;
    } 
    void num1(char[][] grid,int r,int c){
        int dir[][] = new int[][]{{0,-1},{-1,0},{0,1},{1,0}};
        grid[r][c] = ' ';
        for(int i=0;i<dir.length;i++){
            int y = r + dir[i][1]; 
            int x = c +dir[i][0] ;
            if(x> grid[0].length || x <0 || y>= grid.length || y<0 || grid[y][x]=='0' || grid[y][x] == ' ')
                continue;
            num1(grid,y,x);
            
        }


    }



    public int numIslands(char[][] grid) { 
        int nx= grid.length;
        int ny= grid[0].length;
        
        int[][] distance = new int[][]{{0,-1},{-1,0},{0,1},{1,0}};
        UnionFind uf = new UnionFind(nx, ny);
        for(int x=0;x<nx; x++  ){
            for(int y=0;y<ny;y++){
                if(grid[x][y]=='0'){ continue;   }

                int[] past_act = null;
                for(int[] act: distance ){
                    int gx = x + act[0]; int gy = y +act[1];
                    int node1 =uf.linear(x,y) ;
                    int node2 = uf.linear(gx,gy);
                    if(gx<0 || gx >=nx || gy<0 || gy >=ny || grid[gx][gy] =='0' )
                        continue; 
                      
                    uf.pass_node(node1, node2, past_act);   
                    int[] prev = past_act;  
                    past_act =  act;  
                    if(prev == null && past_act !=null)
                        uf.merge(node1,node2);

                }


            }
        }
        int u  = 0;
        int count =0;
         for(int x=0;x<nx; x++  ){
            for(int y=0;y<ny;y++){
                if(grid[x][y] =='0'){ u++; continue;}
                if(uf.map[u]== u) count++;

                u++;
            }
         }



        int s= 0; 
        int l=0;
        for(int x=0;x<nx; x++  ){
             l = s+ny; 
            int[] v = new int[ny];
            System.arraycopy(uf.map,s, v, 0, ny);
            List<Integer>  vr = Arrays.stream(v).boxed().collect(Collectors.toList() );
            System.out.println(vr);
            s= l;
        } 
        return count; 


        

    }
    class UnionFind{
        int  map[];
        int nx;
        int ny; 
        public UnionFind(int nx,int ny){
    
            this.nx =nx;
            this.ny=ny;
            map = new int[nx*ny];
             
            int u =0;
            for(int i =0;i<map.length;i++){
                map[i] = u++;
            }
            
           
        }
        int linear(int x,int y){
            return x*ny + y; 
        }
        void pass_node(int node1,int node2, int[] past_act){
            if(past_act!=null && find(node1) !=find(node2) ){
                if(node1 ==12 && node2== 7 ){
                    System.out.println(map[node1]+" "+map[node2]);
                    System.out.println(find(node2));
                }
                map[find(node2)] = map[node1];
            
            }
        }
        int find(int v){          
            if(v!= map[v]){
               map[v]  = find(map[v]);
            }
            return map[v];
        } 
        void merge(int node1, int node2){
            if(find(node1) ==find(node2)){
                return;
            }
            
            map[node1] = map[find(node2)];

            

        }
    }







    /*
      0 1 2 3
      4 5 6 7
      8 9 10 11

      1  1  1  1
      1  1  1  1
      */





}
