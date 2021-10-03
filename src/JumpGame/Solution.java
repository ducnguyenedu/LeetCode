package JumpGame;

import java.io.IOException;

public class Solution {

    public static boolean canJump(int[] nums) {

        int lastGoodIndex = nums[nums.length - 1];
        //System.out.println(lastGoodIndex);
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastGoodIndex) {
                lastGoodIndex = i;
            }
        }
        return (lastGoodIndex == 0);
    }
    public static void main(String[] args) throws IOException {
        int[]nums = {2,3,1,1,4};
        canJump(nums);
    }
}
