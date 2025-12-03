import java.util.LinkedList;

public class plusOne {
    public int[] plus(int[] digits) { 
        LinkedList<Integer> store = new LinkedList<>();
       
        int reminder=-1; 
        int add; 
        for(int i=digits.length-1;i>=0;i--){
        
            if(i== digits.length-1){
                add= digits[i]+1 ;
            }
            else{
                add = digits[i]+ reminder;
            }
            reminder = add/10;  
            store.addFirst(add%10);

        }
        int[] result = new int[store.size()];
        if(reminder ==1)
            store.addFirst(1);
        
        for(int i=0;i<store.size();i++ ){
            result[i] = store.get(i);
        }
        return result;
        
    }
     public int[] plus2(int[] digits) {  
        int[] result;
        int reminder=-1; 
        int add;
        boolean sheer_nine = true; 
        for(int i=0;i<digits.length;i++){
            if(digits[i] !=9) sheer_nine =false; 

        }
        if(sheer_nine){
            result = new int[digits.length+1]; 
            result[0]=1;
            for(int i=1;i<digits.length;i++ )
                result[i] =0; 
            return result;
        } 
       
        result = new int[digits.length];
        for(int i=digits.length-1;i>=0;i--){ 
            int sumo;
            if(i== digits.length-1){
                sumo= digits[i]+1 ;
            }
            else{
                sumo= digits[i]+ reminder; 
            }
            reminder =sumo/10;
            add = sumo%10;
            result[i] = add;

        }
        
        return result; 



     }

}
