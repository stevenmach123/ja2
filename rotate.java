
public class rotate {
    int[][] hard_copy(int[][] matrix){
        int sq[][] = new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            //sq[i] = new int[matrix[0].length];
            System.arraycopy(matrix[i], 0, sq[i], 0, matrix[0].length);

        }
        return sq;
    }
    void ver_reverse(int[][] matrix){
        int n =matrix.length;
        for(int i= 0; i<n;i++){
            for(int j =0;j< n/2;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-j-1];
                matrix[i][n-j-1] = temp; 

            }
        }
        
    }
    void hori_reverse(int[][] matrix){
        int n =matrix.length; 
        for(int i = 0; i<n;i++){
            for(int j =0;j< n/2;j++){
                int temp =  matrix[j][i];
                matrix[j][i] =  matrix[n-j-1][i]; 
                matrix[n-j-1][i] = temp;

            }
        }
        
        
    }
    void swap(int[][] matrix ,int a1,int a2, int b1,int b2){
        int temp= matrix[a1][a2];
        matrix[a1][a2] = matrix[b1][b2];
        matrix[b1][b2] = temp;
        
    }
    public int[][] turn1(int[][] matrix){
        int n =matrix.length; 
        ver_reverse(matrix);
        for(int i=0; i<n;i++){
            for(int j=0;j<n-i;j++){
                swap(matrix,i,j,n-j-1,n-i-1);
                


            }
        }

        return matrix;
        
    }
  
    public int[][] turn2(int[][] matrix){
        int n =matrix.length; 
        hori_reverse(matrix); 
        for(int i= 0; i< n;i++){
            for(int j=i;j<n;j++){
                swap(matrix,i,j,j,i );
                
            }
                
        }
        
        return matrix;
    }

    public int[][] turn3(int[][] matrix){ 
        int n =matrix.length;  
        for(int i= 0; i< n;i++){
            for(int j=i;j<n;j++){
                swap(matrix,i,j,j,i );
                
            }
                
        } 
        ver_reverse(matrix);
        return matrix;

    }

    public int[][] turn4(int[][] matrix){  
        int n =matrix.length;   
        for(int i=0;i<n/2;i++){
            for(int j=i;j<n-i-1;j++){
                swap(matrix,n-j-1,i, i,j); 
                swap(matrix,n-j-1,i, j,n-i-1); 
                swap(matrix,n-j-1,i, n-i-1,n-j-1);

            }


        }
        return matrix;
    }

    public int[][] turn5(int[][] matrix){  
        int n =matrix.length;   
        for(int i=0;i<n/2;i++){
            for(int j=i;j<n-i-1;j++){
                swap(matrix,i,j,  n-i-1,n-j-1);
                swap(matrix,i,j, n-j-1,i);
                swap(matrix,j,n-i-1, n-i-1,n-j-1);
            }
        }


        return matrix;
    }
    public int[][] turn5_1(int[][] matrix){  
        int n =matrix.length; 
        for(int i=n;i>n/2;i--){
         
            for(int j=n-i ; j < i-1; j++){
                
                swap(matrix,j ,i-1, n-j-1,n-i);
                swap(matrix,j, i-1, n-i,j);
                swap(matrix,n-j-1,n-i, i-1,n-j-1);
                
            }
        
        }
        return matrix;
    }
    public int[][] turn5_2(int[][] matrix){   
        int n =matrix.length; 
        for(int i=0; i<n/2;i++){
            for(int j=n-i-1; j>=i+1; j--){
                //System.out.print(j);
                swap(matrix,n-i-1,j, i,n-j-1);
                swap(matrix,n-i-1,j, n-j-1,n-i-1 );
                swap(matrix, j,i, i,n-j-1);

            }
            System.out.println();
        }
        return matrix;

        
    }
    

   


   
}
