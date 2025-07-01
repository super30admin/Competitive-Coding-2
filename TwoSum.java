// TC - O(n)
// SC - O(n)

// We solve this problem by iterating through array and creating map of target and index
// at last we return array of index which add to target
class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        
        // base case
        if(nums==null || nums.length==0){
            return null;
        }

        int[] result = new int[2];

        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            if(!map.containsKey(target-nums[i])){
                map.put(nums[i], i);
            }
            else{
                result[1] = map.get(target-nums[i]);
                result[0] = i;

                return result;
            }
        }

        return null;

    }
}