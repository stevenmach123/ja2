
public class findTheIndexofFirstOccurence {
    //https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/solutions/3249783/java-easy-with-explanation/
    public int strStr(String haystack, String needle) {
        int slow =0;
        int fast =0; 
             
        for(;slow < haystack.length();slow++){
            fast =slow;
            int counter= 0;
            while(counter < needle.length() && fast < haystack.length()  && haystack.charAt(fast) ==  needle.charAt(fast-slow) ){
                fast++;
                counter++;
            }
            if(counter == needle.length())
                return slow;
            

        }
        return -1;
        
    }
}
