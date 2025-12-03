
public class sortColors {


    void swap(int tar,int x,int[] id, int[]num){
       
        int temp = num[id[tar]];
        num[id[tar]] = num[id[x]];
        num[id[x]]= temp;
    }


    int[] sort1(int colors[],int flag){
        
        int[] num = new int[colors.length];
        System.arraycopy( colors,0, num, 0, num.length);
        int id[] = new int[flag]; 
        
        int io =0;
        while(io<=flag/2){
            id[io]=0;
            io++;
        }
        while(io != flag){
            id[io]=num.length-1;
            io++;
        }
        int tar =  flag/2;
        
        while( id[tar] <= id[tar+1] ){
            
            for(int x =0; x< flag/2;x++){
                if(num[id[tar]] == x ){
                    swap(tar,x,id,num);
                    id[x]++;
                    for(int y=x+1; y<= flag/2;y++ ){
                        if(id[x]>id[y])
                            id[y]++;
                    }
                    
                   


                }
                
            }

             if(num[id[tar]] == tar){
                id[tar]++;
                continue;

             }

            for(int x=tar+1;x<flag;x++){
                if(num[id[tar]] ==x ){
                    swap(tar,x,id,num);
                    id[x]--;    
                    for(int y=x-1;y>tar;y--){
                        if(id[x] <id[y] ){
                            id[y]--;
                        }
                        
                    }
                
                }
                
           
            }


        }





        return num;



    }
}
