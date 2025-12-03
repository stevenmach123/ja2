public class MinStringLengthAfterRemove {
    public int minLength(String s) {
        while(true){
           int idx1 =  s.indexOf("AB", 0);
           int idx2 =  s.indexOf("CD", 0);
           if(idx1 >= 0){
             s= s.substring(0,idx1)+s.substring(idx1+2,s.length());
            continue;
           }
           if(idx2 >= 0){
              s= s.substring(0,idx2)+s.substring(idx2+2,s.length());
             continue;
           }
           if(idx1 <0 && idx2  <0);
                break;
        }
        return s.length();
        

    }
}
