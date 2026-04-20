import java.util.*;

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) return b[1] - a[1];
            return a[0] - b[0];
        });
        List<Integer> tails = new ArrayList<>();
        
        for (int[] envelope : envelopes) {
            int h = envelope[1];
                        int idx = Collections.binarySearch(tails, h);
                        if (idx < 0) {
                idx = -(idx + 1);
            }
                        if (idx == tails.size()) {
                tails.add(h);
            } else {
                tails.set(idx, h);
            }
        }
        
        return tails.size();
    }
}