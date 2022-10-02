package number_of_dice_rolls_with_target_sum;

import java.util.Arrays;

class Solution {
    int mod;
    int[][] dp;

    public int numRollsToTarget(int d, int f, int target) {
        mod = (int) 1e9 + 7;
        dp = new int[d][target + 1];
        for (int[] row : dp) Arrays.fill(row, -1);
        int ret = backtrack(0, d, f, target);
        return ret;
    }

    int backtrack(int ord, int d, int f, int target) {
        if (ord == d) {
            if (target == 0) return 1;
            else return 0;
        }
        if (dp[ord][target] != -1) return dp[ord][target];
        int sum = 0;
        for (int i = 1; i <= f; i++) {
            if (target - i < 0) break;
            sum += backtrack(ord + 1, d, f, target - i);
            sum %= mod;
        }
        dp[ord][target] = sum;
        return sum;
    }
}
