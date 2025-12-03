import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class graphValidTree {
    public boolean validTree(int n, int[][] edges) {
        var map = new HashMap<Integer,Set<Integer>>() ;
        var visited = new HashSet<Integer>();
        if(edges.length == 0)
            return true;
        for(int[] edge :edges){
            map.putIfAbsent( edge[0], new HashSet<Integer>());
            map.putIfAbsent(edge[1], new HashSet<Integer>());
            map.get(edge[0]).add(edge[1]);map.get(edge[1]).add(edge[0]); 
        }
        Queue<Integer[]> que = new LinkedList<Integer[]>()  ;
        que.add(new Integer[]{0,-1});   
        while(!que.isEmpty()){
           var result =  que.poll() ;
           visited.add(result[0]);
            var adj_elements = map.get(result[0]);
            for(var node :adj_elements){
                if(!visited.contains(node) ){
                    que.add(new Integer[]{node,result[0]});
                }
                else if(node != result[1] ){
                    return false;
                }
            }
        }
        System.out.println(visited);
        return true && visited.size() == n;

    }
}










/*
 def validTree(self, n, edges) :
    if not n:
        return True
    adj = { i: [] for i in range(n) }
    for n1, n2 in edges:
        adj [n1] -append (n2)
        adj [n2] -append (n1)
    visit = set()
    def dfs(i, prev):
        if i in visit:
            return False
        visit.add(i) 
        for j in adj[i]:
            ifj== prev：
                continue
            if not dfs(j, i):
                return False
        return True
    return dfs (0, -1) and n == len(visit)


 */