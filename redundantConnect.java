import java.util.HashSet;
import java.util.Set;

public class redundantConnect {
    // same thing, but made elegant

    // https://leetcode.com/problems/redundant-connection/solutions/5322912/dfs-bfs-dis-joint-set/
    // https://leetcode.com/problems/redundant-connection/solutions/123819/from-dfs-to-union-find/
    class UnionFind {
        int[] union;

        public UnionFind(int n) {
            union = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                union[i] = i;
            }
        }

        int find(int a) {
            if (union[a] != a)
                union[a] = find(union[a]);
            return union[a];
        }

        void merge(int a, int b) {
            union[find(a)] = b; // or union[find(a)] = find(b);
        }

    }

    public int[] findRedundantConnection(int[][] edges) {
        Set<Integer> sv = new HashSet<>();
        for (int[] edge : edges) {
            sv.add(edge[0]);
            sv.add(edge[1]);
        }
        UnionFind u = new UnionFind(sv.size());
        for (int[] edge : edges) {

            if (u.find(edge[0]) != u.find(edge[1])) {
                u.merge(edge[0], edge[1]);
            } else
                return new int[] { edge[0], edge[1] };
            // System.out.println(Arrays.toString(u.union));
        }
        return new int[] {};

    }
}
