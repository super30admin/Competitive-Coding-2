class Problem1 {
    //tc : O(n^2); sc: O(1)
    public int[] twoSumBruteForce(int[] nums, int target) {
        int[] res = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    res[0] = i;
                    res[1] = j;
                }

            }
        }
        return res;
    }
    //tc: O(nlogn); sc: O(1)
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Arrays.sort(nums);
        int i = 0, j = nums.length - 1;
        while (i < j) {
            if (nums[i] + nums[j] == target) {
                res[0] = i;
                res[1] = j;
                return res;
            }
            else if (nums[i] + nums[j] < target)
                i++;
            else
                j--;
        }
        return res;
    }

    //Time Complexity: O(n); sc: O(n)
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff)) {
                res[0] = map.get(diff);
                res[1] = i;
                return res;
            }
            map.put(nums[i], i);
        }
        return res;
    }
}