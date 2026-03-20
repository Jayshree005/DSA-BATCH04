import java.util.*;

class Solution {

    public int[][] minAbsDiff(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] ans = new int[m - k + 1][n - k + 1];

        for (int i = 0; i <= m - k; i++) {
            for (int j = 0; j <= n - k; j++) {

                List<Integer> list = new ArrayList<>();

                for (int x = i; x < i + k; x++) {
                    for (int y = j; y < j + k; y++) {
                        list.add(grid[x][y]);
                    }
                }

                ans[i][j] = getMinDiff(list);
            }
        }

        return ans;
    }

    private int getMinDiff(List<Integer> list) {
        Collections.sort(list);

        int minDiff = Integer.MAX_VALUE;

        for (int i = 1; i < list.size(); i++) {

            if (list.get(i).equals(list.get(i - 1))) continue;

            minDiff = Math.min(minDiff, list.get(i) - list.get(i - 1));
        }

        return minDiff == Integer.MAX_VALUE ? 0 : minDiff;
    }
}