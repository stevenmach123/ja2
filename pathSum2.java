
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
public class pathSum2 {

    

    public List<List<Integer>>path(TreeNode root, int targetSum){
        Queue<Map.Entry<List<Integer>,TreeNode>> que = new LinkedList<>();
        List<List<Integer>> paths = new ArrayList<>();
        if(root == null) return paths;
    

        que.add(new AbstractMap.SimpleEntry<List<Integer>, TreeNode>(new ArrayList<Integer>(),root));
        while(!que.isEmpty()){
            Map.Entry<List<Integer>,TreeNode> cur = que.remove();

            Integer[] ar0 = new  Integer[cur.getKey().size()];
            
            System.arraycopy(cur.getKey().toArray(), 0, ar0, 0, cur.getKey().size());
            //List<Integer> list = (LinkedList)Arrays.stream(ar0).boxed().collect(Collectors.toList()); // only for int[] to LinkedList
            // System.arraycopy: Object[] can't be copied into int[] 
            List<Integer> list = new LinkedList<>(Arrays.asList(ar0)); 
            list.add(cur.getValue().val);
                    
        
            if(cur.getValue().left != null){
                que.add( new AbstractMap.SimpleEntry<List<Integer>,TreeNode>(list,cur.getValue().left));
            }
            if( cur.getValue().right != null){
                que.add( new AbstractMap.SimpleEntry<List<Integer>,TreeNode>(list,cur.getValue().right));

            }
            if(cur.getValue().right == null &&cur.getValue().left ==null){
                int sum =0;
                for(int val: list){
                    sum +=val ;
                }
                if(sum ==targetSum)  paths.add(list);
                
            }
            


        }



        return paths;

    }







    //queue IMPLEMENT (just copy previous version)
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        Deque<Object[]> s  = new LinkedList<>() ;
        List<List<Integer>> path  = new LinkedList<>();
    
        if(root ==null)
            return new LinkedList<List<Integer>>();
            
        s.add(new Object[]{Arrays.asList(root.val),root });
        while(!s.isEmpty()){
            Object[] ob =  s.remove();
            TreeNode node = (TreeNode) ob[1];
            System.out.println(ob[0]);
            List<Integer> l;
            if(node.left != null){
                l = new LinkedList<Integer>((List<Integer>) ob[0]);
                l.add(node.left.val);
                s.add(new Object[]{l,node.left});
            }
            if(node.right != null ){
                l = new LinkedList<Integer>((List<Integer>) ob[0]);
                l.add(node.right.val); 
                s.add(new Object[]{l,node.right});
            }
            if(node.right == null && node.left == null){
                l = (List<Integer>)ob[0];
                int sum=0;
                for(int el : l)
                    sum += el;
                if(sum ==targetSum) 
                    path.add(l);
            }
                
    
        }
        return path;
        
        
        
    }







}
