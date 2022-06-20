// Time Complexity: O(n)
// Space Complexity: O(n)
// Did this code successfully run on Leetcode : yes

class Solution {
    public int findPairs(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        int count = 0;
        for (int n : map.keySet()) {
            if (k > 0 && map.containsKey(n + k) || k == 0 && map.get(n) > 1)
                count++;
        }
        return count;
    }
}