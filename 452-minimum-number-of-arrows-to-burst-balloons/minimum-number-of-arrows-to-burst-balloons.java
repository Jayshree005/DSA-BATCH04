import java.util.Arrays; // Yeh import zaroori hai Arrays.sort ke liye

class Solution {
    public int findMinArrowShots(int[][] points) {
        // 1. Edge Case
        if (points.length == 0) return 0;

        // 2. Sorting using Lambda (End point ke basis par)
        // Integer.compare use karein taaki overflow na ho
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        int arrows = 1;
        int currentEnd = points[0][1];

        // 3. Greedy approach
        for (int i = 1; i < points.length; i++) {
            // Agar balloon ka start point currentEnd se bada hai, 
            // matlab naya arrow chahiye
            if (points[i][0] > currentEnd) {
                arrows++;
                currentEnd = points[i][1];
            }
            // Warna current arrow se kaam chal jayega (overlap)
        }

        return arrows;
    }
}