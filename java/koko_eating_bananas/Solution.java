package koko_eating_bananas;

public class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int k = 1;
        while (true) {
            if (canFinish(piles, k, h))
                break;
            k *= 2;
        }
        int a = k / 2;
        int b = k;
        while (b - a > 1) {
            int m = (a + b) / 2;
            if (canFinish(piles, m, h))
                b = m;
            else
                a = m;
        }
        return b;
    }

    boolean canFinish(int[] piles, int k, int h) {
        int count = 0;
        for (int pile : piles) {
            count += (pile - 1) / k + 1;
            if (count > h) return false;
        }
        return true;
    }
}