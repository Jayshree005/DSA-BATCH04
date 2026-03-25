class Solution {
    public int mostWordsFound(String[] sentences) {
        int maxWords = 0;
        for (String s : sentences) {
            int count = 1;
            for (char c : s.toCharArray()) {
                if (c == ' ') {
                    count++;
                }
            }
            maxWords = Math.max(maxWords, count);
        }
        return maxWords;
    }
}