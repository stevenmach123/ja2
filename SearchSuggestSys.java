
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
//https://leetcode.com/problems/search-suggestions-system/solutions/436151/java-python-3-simple-trie-and-binary-search-codes-w-comment-and-brief-analysis/
//https://leetcode.com/problems/search-suggestions-system/solutions/1242823/c-python-3-solutions-clean-concise/

public class SearchSuggestSys {
    public static void main(String[] args){
        String[] cc  = new String[]{"pr","prox","pro"}; 
        Arrays.sort(cc);
        System.out.println(Arrays.binarySearch(cc, "pro"));
    }

     public List<List<String>> suggests(String[] products, String searchWord) {
        List<List<String>> result = new LinkedList<>();
        Map<String,Set<String>>  v=  new HashMap<>();
        for(String product : products ){
            for(int i =0;i<product.length() ;i++){
                v.putIfAbsent(product.substring(0,i+1),new TreeSet<>());
                v.get(product.substring(0,i+1)).add(product);
            }
        }
       
        for(int i=0; i <searchWord.length();i++ ){
            String w  = searchWord.substring(0,i+1);
            List<String> l = new LinkedList<>();
            if(v.containsKey(w)){
                Iterator<String> it =  v.get(w).iterator() ;
                int ii = 3; 
                while(it.hasNext()){
                    if(ii == 0) 
                        break;
                    l.add(it.next());
                    ii-- ;
                }
            } 
            result.add(l);
        }
        return result;

    }
}
