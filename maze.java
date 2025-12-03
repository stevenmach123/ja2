
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
public class maze {
    class Pair{
        int row;
        int col;
        public Pair(int row,int col){
            this.row = row; this.col = col;
        }
        int distance =0;
        public Pair(){}
        
    }
    public class Goal{
        int row; int col;
        boolean goal =false; 
    } 

       
    public ArrayList<Integer[]>  checkAdj(Integer[] e){
        ArrayList<Integer[]> path = new ArrayList<Integer[]>();
        path.add(new Integer[]{e[0]+1,e[1]});
        path.add(new Integer[]{e[0]-1,e[1]});
        path.add(new Integer[]{e[0],e[1]+1});
        path.add(new Integer[]{e[0],e[1]-1}); 
       
        
        return path;
    }
    public boolean goal(Integer[] e,int row, int col){
        if(e[0]==0|| e[0]== row-1 || e[1]==0 || e[1]== col-1){
            return true;
        }
        return false;
    }
   
    public int maze1(char[][] maze,int[] entrance){
        Queue<Integer[]> q = new LinkedList<>();
        int row = maze.length;
        int col = maze[0].length;
       
        boolean[][] check = new boolean[row][col];
        Pair[][] prev_path = new Pair[row][col];
       
       
        Integer[] ent = new Integer[]{entrance[0],entrance[1]};
        Goal end = new Goal();
        q.add(ent);
        check[ent[0]][ent[1]] = true;
        prev_path[ent[0]][ent[1]] = new Pair();
        while(!q.isEmpty()){
            if(end.goal){
                break;
            }
            ent = q.remove();
            System.out.println(ent);
            for( Integer[] path : checkAdj(ent) ){
             if(  path[0]< maze.length && path[0] > -1 && path[1] < maze[0].length && path[1] > -1 && maze[path[0]][path[1]] == '.'  && !check[path[0]][path[1]] ){
                  
                check[path[0]][path[1]] = true;
                q.add(path);
                prev_path[path[0]][path[1]] = new Pair(path[0],path[1]);
                prev_path[path[0]][path[1]].distance = prev_path[ent[0]][ent[1]].distance+1; 
                if(goal(path,row,col)){
                    end.row = path[0];
                    end.col= path[1];
                    end.goal = true ;
                }
            

             }
    
            }               
        
        }
        
        System.out.println(end.row+" "+end.col);
        if(end.goal){
            return  prev_path[end.row][end.col].distance; 
        }
        else{
            return -1;
        }

    


    }

    public int maze2(char[][] maze,int[] entrance){
        Queue<Integer[]> q = new LinkedList<>();
        int row = maze.length;
        int col = maze[0].length;
       
        boolean[][] check = new boolean[row][col];
        Pair[][] prev_path = new Pair[row][col];
       
       
        Integer[] ent = new Integer[]{entrance[0],entrance[1]};
        Goal end = new Goal();
        boolean start = true;
        q.add(ent);
        check[ent[0]][ent[1]] = true;
        prev_path[ent[0]][ent[1]] = new Pair();
        while(!q.isEmpty()){

            
           
          
            ent = q.remove();
            System.out.println(ent[0].toString()+" "+ent[1].toString());
            
          

            if(!check[ent[0]][ent[1]]  || start ){
                
                for( Integer[] path : checkAdj(ent) ){
                
                if(  path[0]< maze.length && path[0] > -1 && path[1] < maze[0].length && path[1] > -1 && maze[path[0]][path[1]] == '.'  && !check[path[0]][path[1]] ){
                    
                
                    q.add(path);
                    prev_path[path[0]][path[1]] = new Pair(path[0],path[1]);
                    prev_path[path[0]][path[1]].distance = prev_path[ent[0]][ent[1]].distance+1; 
                
                

                }
        
                }
            }
                check[ent[0]][ent[1]] = true;
                if(!start ){
                    if(goal(ent,row,col)){
                        end.row = ent[0];
                        end.col= ent[1];
                        end.goal = true ;
                    }
                    if(end.goal){
                        break;
                    }
                }
                start =false;
              
            
           
        
        }
        
        
        System.out.println(end.row+" "+end.col);
        if(end.goal){
            return  prev_path[end.row][end.col].distance; 
        }
        else{
            return -1;
        }



    }



    // similar to maze1, more organized
    boolean adj(char[][]maze,int nr,int nc,int r, int c){
        if(r < 0 || r >=nr || c <0 || c>=nc || maze[r][c] == '+'){
            return false;
        }
        return true;
    }
    public int maze11(char[][] maze,int[] entrance){ 
        Deque<Integer[]>  s = new LinkedList<Integer[]>();
        int nr= maze.length;int nc=maze[0].length;
        int[][] moves = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        int total =0;
        int[][] prev_step  = new int[nr][nc];
        s.add(new Integer[]{entrance[0],entrance[1]});
        while(!s.isEmpty()){
            Integer[] mymove = s.pop() ;
            
            for(int[] move : moves){
                int r= mymove[0] + move[0]; int c = mymove[1] + move[1];
                if(adj(maze,nr,nc,r,c)){
                    maze[mymove[0]][mymove[1]] = '+'; 
                    prev_step[r][c] = prev_step[mymove[0]][mymove[1]] +1;
                    s.add(new Integer[]{r,c} );
                    if(r==0 || c==0 || r == nr-1 || c ==nc-1 )
                        return prev_step[r][c];
                }
                  
            }
            

        }
        return -1;

    }















}
