
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class permutation {
    List<List<Integer>> list =  new ArrayList<List<Integer>>();
    public List<List<Integer>> permute(int[] nums) {
        Arrays.sort(nums);
        List<Integer>  l = Arrays.stream(nums).boxed().collect(Collectors.toList());
        List<Integer> sub= new ArrayList<>(); 
        help(l,nums.length,sub) ;
        return list;

    }
    void help(List<Integer> l,int iter,List<Integer> sub){
        if(iter == 0){
            list.add(sub);
        }
        
        for(int i=0;i<iter;i++){
            List<Integer> newlist = new ArrayList<>(sub);
            newlist.add(l.get(0));
            int val = l.remove(0);
            help(l,iter-1,newlist);
            l.add(l.size(), val);
        }


    }


    // bottom up
     List<List<Integer>> help2(ArrayList<Integer> x){
        
        if(x.size() ==1)
            return  Arrays.asList(Arrays.asList(x.get(0)));
        List<List<Integer>> temp_list = new LinkedList<>();
        
        for(int i=0;i<x.size();i++){
            int val = x.remove(0);
            for(List<Integer> l : help2(x)){
                ArrayList<Integer> b = new ArrayList<>(l); 
                b.add(val);
                temp_list.add(b);
            }
            x.add(val);
        }
        
        return temp_list;
    }
    public List<List<Integer>> permute2(int[] nums) {
        ArrayList<Integer> x = (ArrayList) Arrays.stream(nums).boxed().collect(Collectors.toList());
        return help2(x);
        
    }








   
    
   


    

}
