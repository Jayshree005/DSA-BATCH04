class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        int n = mat.length;
        int[][] curr = mat;
        for (int k = 0; k < 4; k++) {
            if (isEqual(curr, target)) return true;
            curr = rotate(curr);
        }
        return false;
    }
    private int[][] rotate(int[][] mat) {
        int n = mat.length;
        int[][] newMat = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                newMat[j][n - 1 - i] = mat[i][j];
            }
        }
        return newMat;
    }
    private boolean isEqual(int[][] a, int[][] b) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] != b[i][j]) return false;
            }
        }
        return true;
    }
}