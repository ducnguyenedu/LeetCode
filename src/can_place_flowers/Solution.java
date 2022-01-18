package can_place_flowers;

public class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int available = 0;

        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] != 0) continue;
            int prev = i == 0 || flowerbed[i - 1] == 0 ? 0 : 1;
            int next = i == flowerbed.length - 1 || flowerbed[i + 1] == 0 ? 0 : 1;

            if (prev == 1 || next == 1) continue;
            flowerbed[i] = 1;
            available++;

        }
        return available >= n;
    }
}