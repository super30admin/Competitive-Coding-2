class Solution {
    public int[] twoSum(int[] nums, int target) {
        int find = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        for(int i = 0; i < nums.length; i++){
            find = target - nums[i];    // to get the target value after substraction
            if(map.containsKey(find)){      //to find the find variable from subtraction
                result[1] = i;
                result[0] = map.get(find);
                return result;
            }
            map.put(nums[i], i);
        }
        return result;
    }
}