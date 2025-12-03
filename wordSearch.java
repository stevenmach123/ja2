
public class wordSearch{

    boolean searchWord(char[][] board,String word){
       
        for(int r =0;r<board.length;r++){
            for(int c =0;c<board[0].length;c++){
                /*if(dps2(r,c,board,"",word)){
                    return true;
                }*/
                if(dps3(r,c,board,0,word)){
                    return true; 
                }
            }
        }
            
        return false;
    }

    boolean matchWord(String frag,String word){ 
        for(int i=0;i<frag.length();i++){
            if(frag.charAt(i)!= word.charAt(i)){
                return false; 
            }   
        }
        return true;
    } 

    boolean dps(int r,int c,char[][] dup_board,String frag,String word){
       
        if(r<0 || r== dup_board.length || c<0 || c== dup_board[0].length || !matchWord( frag + dup_board[r][c],word)){
            return false ;
        }

        String frag_word = frag + dup_board[r][c];
        if(frag_word.length() == word.length() )
            return true;

        char[][] new_board = new char[dup_board.length][];
        
        for(int t=0;t< new_board.length;t++){
            char[] ro = new char[dup_board[t].length];
            System.arraycopy(dup_board[t],0, ro, 0,dup_board[t].length);
            new_board[t] =ro;
        
        }
        
        new_board[r][c] =' ';
        
       /*  ArrayList<ArrayList<String>> a_old = new ArrayList<ArrayList<String>>(); 
         ArrayList<ArrayList<String>> a = new ArrayList<ArrayList<String>>();  
        for(int i=0;i< new_board.length;i++){
            ArrayList<String> is_old = new ArrayList<String>();
            ArrayList<String> is = new ArrayList<String>(); 
            for(int y=0;y< new_board[0].length;y++){
                is_old.add(Character.toString(dup_board[i][y]))  ;
                is.add(Character.toString(new_board[i][y]))  ;
            }
            a_old.add(is_old);
            a.add(is);
        }
       
        System.out.println("new: "+a); */



        boolean path =  dps(r+1,c,new_board,frag_word,word)    
        || dps(r-1,c,new_board,frag_word,word)
        || dps(r,c+1,new_board,frag_word,word)
        || dps(r,c-1,new_board,frag_word,word);
        
        return path;
    }





    boolean dps2(int r,int c,char[][] dup_board,String frag,String word){
       
        if(r<0 || r== dup_board.length || c<0 || c== dup_board[0].length || !matchWord( frag + dup_board[r][c],word)){
            return false ;
        }

        String frag_word = frag + dup_board[r][c];
        if(frag_word.length() == word.length() )
            return true;

        
        
        
        char temp =dup_board[r][c];
        dup_board[r][c] =' ';
        
       



        boolean path =  dps2(r+1,c,dup_board,frag_word,word)    
        || dps2(r-1,c,dup_board,frag_word,word)
        || dps2(r,c+1,dup_board,frag_word,word)
        || dps2(r,c-1,dup_board,frag_word,word);
        dup_board[r][c] =temp;

        return path;
    }



    boolean dps3(int r,int c,char[][] dup_board,int counter,String word){
       
        if(r<0 || r== dup_board.length || c<0 || c== dup_board[0].length || dup_board[r][c]!=word.charAt(counter)){
            return false ;
        }

        counter +=1; 
        if(counter== word.length() )
            return true;

    
      
        char[][] new_board = new char[dup_board.length][];
        
        for(int t=0;t< new_board.length;t++){
            char[] ro = new char[dup_board[t].length];
            System.arraycopy(dup_board[t],0, ro, 0,dup_board[t].length);
            new_board[t] =ro;
        
        }
        
        new_board[r][c] =' ';


        boolean path =  dps3(r+1,c,new_board,counter,word)    
        || dps3(r-1,c,new_board,counter,word)
        || dps3(r,c+1,new_board,counter,word)
        || dps3(r,c-1,new_board,counter,word);
        

        return path;
    }



  
  






}