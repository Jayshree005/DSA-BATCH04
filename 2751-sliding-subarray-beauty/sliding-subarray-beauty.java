class Solution {
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int n = nums.length;
        int[] result = new int[n - k + 1];

        // Sliding Window + HashMap
        HashMap<Integer, Integer> map = new HashMap<>();

        int left = 0;

        for (int right = 0; right < n; right++) {

            // Expand Window
            if (nums[right] < 0) {
                map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            }

            // Window size becomes k
            if (right - left + 1 == k) {

                // Find x-th smallest negative number
                int count = 0;
                int beauty = 0;

                for (int num = -50; num <= -1; num++) {
                    if (map.containsKey(num)) {
                        count += map.get(num);

                        if (count >= x) {
                            beauty = num;
                            break;
                        }
                    }
                }

                result[left] = beauty;

                // Shrink Window
                if (nums[left] < 0) {
                    map.put(nums[left], map.get(nums[left]) - 1);

                    if (map.get(nums[left]) == 0) {
                        map.remove(nums[left]);
                    }
                }

                left++;
            }
        }

        return result;
    }
}