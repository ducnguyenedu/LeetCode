package DungeonGame;

import java.io.IOException;

public class Solution {

    static int[][] dp;

    public static int calculateMinimumHP(int[][] dungeon) {

        dp = new int[dungeon.length][dungeon[0].length];
        int x = leastNeededBlood(0, 0, dungeon);
        return x;

    }

    public static int leastNeededBlood(int i, int j, int[][] board) {

        if (i == board.length - 1 && j == board[0].length - 1) return board[i][j] > 0 ? 1 : 1 - board[i][j];
        if (i >= board.length || j >= board[0].length) return Integer.MAX_VALUE / 2;
        if (dp[i][j] != 0) return dp[i][j];
        int re = leastNeededBlood(i + 1, j, board);
        re = Math.min(leastNeededBlood(i, j + 1, board), re);

        dp[i][j] = Math.max(1, re - board[i][j]);
        System.out.println(re + " " + i + " " + j);
        return dp[i][j];
    }

    public static void main(String[] args) throws IOException {
        int[][] dungeon = {{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}};
        calculateMinimumHP(dungeon);
    }
}
