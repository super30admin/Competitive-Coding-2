// TC: O(n)
// SC: O(n)

// 1: We use a HashMap with a key:value pair of the number from the input array: the index at which it is present
// 2: For each element in the array, we determine whether the difference from the target is present in the array
// 3: If the difference does not exist, we insert the current number into the array along with its index
class Solution {
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i<nums.length; i++){
            int item = target - nums[i];
            if(map.containsKey(item)){
                return new int[]{i, map.get(item)};
            }
            else{
                map.put(nums[i], i);
            }
        }
        return new int[]{-1,-1};

    }
}