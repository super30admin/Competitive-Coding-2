//T: O(N)
////S:O(N)
////Works on LC: Y
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i], i);
        }

        for(int i=0;i<nums.length;i++){
            int diff = target - nums[i];
            if(map.containsKey(diff)){
                int j = map.get(diff);
                if(i!=j)
                    return new int[] {i,j};
            }
        }

        return new int[] {0,0};
    }
}