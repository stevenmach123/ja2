public class jumpGame {
    // https://leetcode.com/problems/jump-game/solutions/2375320/interview-scenario-recursion-memoization-dp-greedy/
    public boolean canJump1(int[] nums) {
        // TC: N^2
        // SC: N
        boolean dp[] = new boolean[nums.length];
        if (nums.length == 1)
            return true;
        for (int i = nums.length - 2; i >= 0; i--) {
            int reach = i + nums[i];
            boolean des = false;
            for (int b = i + 1; b <= reach && b < nums.length; b++) {

                if (b == nums.length - 1 || dp[b])
                    des = true;
            }
            dp[i] = des;
        }
        return dp[0];
    }

    /*
     * if do recursive in stack
     * TC: N^2
     * SC: N+N
     */

    public boolean canJump2(int[] nums) {

        int des = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] - des >= 0)
                des = i;

        }
        if (des == 0)
            return true;
        else
            return false;

    }

}
