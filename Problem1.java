class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        if (nums == null || nums.length < 2) {
            return new int[] {-1, -1};
        }

        int[] result = new int[2];

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for(int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];

            if(map.containsKey(nums[i])) {
                result[0] = map.get(nums[i]);
                result[1] = i;
                return result;
            } else {
                map.put(diff, i);
            } 
        }

        return new int[] {-1, -1};

    }
}