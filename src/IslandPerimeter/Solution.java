package IslandPerimeter;

import java.io.IOException;

public class Solution {
    public static int islandPerimeter(int[][] grid) {
        if (grid == null ||
                grid.length == 0)
            return 0;
        int perimeter = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    perimeter += 4;
                    if (i > 0 &&
                            grid[i - 1][j] == 1) {
                        perimeter -= 2;
                    }
                    if (j > 0 &&
                            grid[i][j - 1] == 1) {
                        perimeter -= 2;
                    }
                }
            }
        }
        //System.out.println(perimeter);
        return perimeter;
    }
    public static void main(String[] args) throws IOException {
        int[][] grid = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
        islandPerimeter(grid);

    }
}
