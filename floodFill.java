public class floodFill {
    private int det_color;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        det_color = image[sr][sc];
        help(image,image.length,image[0].length,sr,sc,color); 
        
        return image; 
       
    }
    public void help(int[][] image,int mr,int mc,int sr,int sc,int color ){
        if(det_color != image[sr][sc]) return; 
        if(image[sr][sc ]== color) return ;
        int moves[][] = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};


        image[sr][sc] =color;
        for(int[] act: moves){
            int next_r =  sr+act[0];
            int next_c = sc +act[1]; 
            if(next_r<0 || next_r>=mr || next_c <0 || next_c>=mc)
                continue;      
            help(image,mr,mc,next_r,next_c,color); 
        } 
    }

}
