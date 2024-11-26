//Time complexity : O(n)
//Space complexity : O(n)

class Solution {
    static int[] twoSum(int[] nums, int target) {
 HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        
        for(int i=0; i<nums.length; i++){
            int difference = target-nums[i];
            
            if(map.containsKey(difference)){
                result[0] = map.get(difference);
                result[1] = i;
            }
            else{
                map.put(nums[i],i);
            }
        }
        return result;
}
}