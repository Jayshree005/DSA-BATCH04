class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        if (rows == 0) return "";
        int n = encodedText.length();
        int cols = n / rows;
        char[][] matrix = new char[rows][cols];
        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = encodedText.charAt(index++);
            }
        }
        StringBuilder result = new StringBuilder();
        
        for (int j = 0; j < cols; j++) {
            int i = 0, k = j;
            while (i < rows && k < cols) {
                result.append(matrix[i][k]);
                i++;
                k++;
            }
        }
        return result.toString().stripTrailing();
    }
}