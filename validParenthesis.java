
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class validParenthesis {
    public boolean valid(String s) {
        Deque<Character> st = new ArrayDeque<>();
        List x = Arrays.asList('(','[','{');
        for(char l: s.toCharArray()){
            if(x.contains(l))
                st.push(l);
            else{
                Character c = st.peek();
                if(c != null){
                    if(c=='(' && l==')' || c=='[' && l==']'|| c=='{' && l=='}')
                        st.pop();
                    else return false;
                }
                else
                    return false;
            }
            
        }
        if(!st.isEmpty())
            return false;
        return true;
        
    }   
}
