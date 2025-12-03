class numofEnclaves{
    int grids[][] ; 
    int vals;int nr;int nc;
    public int num(int[][] grid) {
        nr = grid.length ; nc=grid[0].length;
        grids = grid; vals =nr*nc;
        int act[][] = new int [][]{{0,-1},{-1,0},{0,1},{1,0}};
        UnionFind uf = new UnionFind();
        for(int r=0;r< nr;r++){
            for(int c=0;c< nc;c++){   
                if(grids[r][c]==0) continue;
                for(int[] move:act){ 
                    int xr = r +move[0]; int xc = c+ move[1];
                    if( xr<0 || xr>=nr || xc <0|| xc>=nr || this.grids[xr][xc]==0) continue;
                    int node1 =idx(r,c);int node2 =idx(xr,xc);
                    uf.merge(node1,node2);

                }
            }
        }

          
        return uf.result(); 
    }
    class UnionFind{
        int res=0;
        int pos[];
        public UnionFind(){
            pos =new int[vals];
            for(int i= 0;i<vals;i++){
                pos[i] =i ;            
            }
            
        }
        int result(){      
            for(int r=0;r< nr;r++){
                for(int c=0;c< nc;c++){ 
                    int node = idx(r,c); 
                    int[] po = rc(find(node));
                    if(grids[r][c]==0|| po[0]==0||po[0]==nr-1||po[1]==0||po[1]==nc-1)
                        continue;
                    res++; 
                }
            }
            return res;
        }

        int find(int val){
            if(pos[val] ==val) return val;
            pos[val] = find(pos[val]);
            return pos[val];

        }
        void merge(int node1,int node2){
            if(find(node1) ==find(node2)) return;
            int[] rc = rc(find(node1));
            if(rc[0] ==0 || rc[0]== nr-1 || rc[1]==0 || rc[1]==nc-1) return ;
            pos[find(node1)] = node2; // pos[node1] or find(node1);
            
        }


    }
    int idx(int r,int c){
        return r*nc +c;
    }
    int[] rc(int node){       
        return new int[]{node/nc,node%nc};
    }



}