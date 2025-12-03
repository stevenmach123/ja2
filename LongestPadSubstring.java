public class LongestPadSubstring {
    public String longestPalindrome(String s) {
        int max =0; 
        String res= "";
        int n = s.length();
        for(int i=0;i<n;i++){
            int l=i-1;
            int r= i+1; int count =1; boolean cut =false; 
            String temp =Character.toString(s.charAt(i));
            while(l>=0 && s.charAt(l) == s.charAt(i) ){
                temp = Character.toString(s.charAt(l)) + temp;
                count++; l--;
            }
            while(r<n && s.charAt(r) == s.charAt(i) ){
                temp = temp+Character.toString(s.charAt(r));
                count++;r++; 
            }
            while(l>=0 && r < n){    
                if(s.charAt(l) != s.charAt(r))break;  
                
               
            count +=2;
            temp = Character.toString(s.charAt(l))+ temp  + Character.toString(s.charAt(r));
            l--;r++;
                       
            }
            
            //System.out.println(temp+" "+count);
              
            if(count > max){
                res =temp;
                max=count;
            }

        }
        
        return res;
    
       /*  aa   ab  aab bac  mababac */ 
    } 
   


    public String pad(String s){
        int p1 =0;
        String word="";
        char[] ss = s.toCharArray();
        
        while(p1< s.length()){
            int pt1 =p1 ;
            int pt2 = p1;
            while(pt2 <s.length() ){
                if(ss[pt1] != ss[pt2]){             
                    break;
                }
                pt2++;
            }
            pt2--;
             
            while(pt2 <s.length() && pt1 >=0 ){
                if(ss[pt1] != ss[pt2]){    
                    break;
                }
               pt2++;
               pt1--;
            }
            pt1++;pt2--;
        
            if(pt2 - pt1+1 > word.length()){
                  word = s.substring(pt1,pt2+1);  
            }
            p1++;

        }
        return word;
    }




}
