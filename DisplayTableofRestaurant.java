
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;






public class DisplayTableofRestaurant {

class cr implements Comparator<Integer>{
    private Map<Integer,Map<Integer,String>> map;
    public cr(Map<Integer,Map<Integer,String>> map){
        this.map = map; 
    }
    public cr(){}

    @Override
    public int compare(Integer s1,Integer s2){
        return s1.compareTo(s2);
    }
} 
class b implements Comparator<String>{
    @Override
    public int compare(String s1,String s2){
        
        return s1.compareTo(s2);
    }
} 
   

    public  List<List<String>> displayTable(List<List<String>> orders) {
        Set<String> set = new TreeSet<>(new b());
        Map<Integer,Map<String,Integer>> table = new TreeMap<Integer,Map<String,Integer>>();
        List<List<String>> res = new LinkedList<List<String>>();
        List<String> firstRow  = new LinkedList<>();
        
        for(List<String> li : orders){
            set.add(li.get(2));
            String food = li.get(2);
            Integer tnum = Integer.parseInt(li.get(1));
            table.putIfAbsent( tnum,new HashMap<>());
            table.get(tnum).putIfAbsent(food, 0);
            Map<String,Integer> m = table.get(tnum);
            m.put(food,m.get(food)+1);
                     
        }
        firstRow.addAll(set);
        firstRow.add(0,"Table");
        res.add(firstRow);
        for(Map.Entry<Integer,Map<String,Integer>> entry :table.entrySet()){
            ArrayList<String> lw = new ArrayList<>();
            Map<String,Integer> map  = entry.getValue();
            lw.add(entry.getKey()+"");
            for(String food :res.get(0)){
                
                if(food !="Table"){
                    if(map.get(food) !=null)
                        lw.add(map.get(food)+"");
                    else 
                        lw.add("0");
                }
            }
            res.add(lw);


        }
        return res;
           
        




    }
        
    




    }

