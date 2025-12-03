import java.util.Arrays;

public class canPlaceFlower {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
       
        int rp = -1; 
        int lp = -1;
        int nf = flowerbed.length;
        int flower[] = new int[nf+1]; 
        for(int i=0;i< nf;i++ ){
            flower[i] = flowerbed[i];
        }
        while(rp <= nf){
            while( rp < nf && flower[rp+1] == 0){
                rp++;
            }
            var diff = rp - lp ;
            n -= diff/2; 
            if(rp >= nf ){
                break;
            }
            while(rp < nf && flower[rp+1]==1){    
                rp++;
            }
            rp++;
            lp = rp; 
        }
        if(n == 0)
            return true;
        return false;
        
    }
}
/*
int rp = -1; 
int lp = -1;

while( lp  <= nums.length ){
    var diff = rp - lp ;
    n -= diff/2;
    if(n <= 0)
        return true;
    
    while( nums[lp]  == 0 )
        lp++;
    while( nums[rp]  == 0 )
        rp++;
    
    
}
if(n == 0)
    return true;
return false;

*/ 