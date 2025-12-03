import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class Twitter {
     //https://leetcode.com/problems/design-twitter/solutions/82825/java-oo-design-with-most-efficient-function-getnewsfeed/
     //https://leetcode.com/problems/design-twitter/solutions/4834522/optimal-approach-in-c-using-priority-queues-beats-100/
    Map<Integer,Set<Integer>> followers;
    Map<Integer,List<Post>> posts;
    int time =1;

    public Twitter() {
        followers = new HashMap<>(); 
        posts =  new HashMap<>(); 
    }
    public void postTweet(int userId, int tweetId) {
        posts.putIfAbsent(userId, new LinkedList<>());
        posts.get(userId).add(new Post(tweetId,time++));
    }
    
    public List<Integer> getNewsFeed(int userId) {
         Set<Integer> mf = followers.get(userId);
         mf.add(userId); 
        Integer[] myfollowers = mf.stream().toArray(Integer[]::new);
        List<Integer> result= new LinkedList<>() ;
        
        int arr_pt[] = new int[myfollowers.length]; 
        for(int i =0; i<myfollowers.length  ;i++){
            arr_pt[i] = posts.get(myfollowers[i]).size()-1;
        }
        for(int f=0;f<10;f++){
            int time =0; 
            int post_id =-1;
            for(int i =0; i<myfollowers.length  ;i++){
                if(arr_pt[i]>=0 && posts.get(myfollowers[i]).get(arr_pt[i]).time > time){
                    time =posts.get(myfollowers[i]).get(arr_pt[i]).time;
                    post_id  = posts.get(myfollowers[i]).get(arr_pt[i]).id;
                    arr_pt[i]--;
                }
                
            }
            if(post_id !=-1)
                result.add(post_id);
        }

        return result; 
    }
    
    public void follow(int followerId, int followeeId) {
        followers.putIfAbsent(followerId, new HashSet<>()); 
        followers.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        followers.putIfAbsent(followerId, new HashSet<>()); 
        followers.get(followerId).remove(followeeId); 
        
    }

    class Post{
        int id = 0;
        int time =0;
        public Post(int id,int time){
            id = this.id;
            time =this.time;
        }
        
    }


}
