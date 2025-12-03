import java.util.Arrays;
import java.util.List;

public class wordbreak {
    public static void main(String[] args) {

        System.out.println("fdfd".substring(1, 4));
    }

    // solution 1;
    public boolean wordBreak(String s, List<String> wordDict) {
        int[] map = new int[s.length() + 1];
        Arrays.fill(map, -1);
        map[s.length()] = 1;

        if (help(s, wordDict, 0, map) == 1) {
            System.out.println(Arrays.toString(map));
            return true;
        } else {
            System.out.println(Arrays.toString(map));
            return false;
        }
    }

    int help(String s, List<String> wordDict, int cur, int[] map) {
        for (String w : wordDict) {
            if (cur + w.length() <= s.length()) {
                int temp = 3;
                temp = map[cur + w.length()];
                if (temp == -1)
                    temp = help(s, wordDict, cur + w.length(), map);
                if (temp == 0) {
                    map[cur] = 0;
                    continue;
                }
                if (s.substring(cur, cur + w.length()).equals(w)) {
                    map[cur] = 1;
                    break;
                } else
                    map[cur] = 0;
            } else if (cur + w.length() > s.length()) {
                map[cur] = 0;
            }
        }
        return map[cur];
    }

    // solution 2:
    public boolean wordBreak2(String s, List<String> wordDict) {
        boolean[] map = new boolean[s.length() + 1];
        map[s.length()] = true;
        for (int i = s.length(); i > 0; i--) {
            for (String w : wordDict) {
                if (i + w.length() <= s.length()) {
                    if (s.substring(i, i + w.length()).equals(w))
                        map[i] = map[i + w.length()];
                }
                if (map[i])
                    break;
            }
        }
        return map[0];
    }

}
/*
 * help(){
 * if
 * for(w: wordDict){
 * if(w.length < s equal w )
 * map[cur+w.length ] = true ;
 * }
 * }
 */
