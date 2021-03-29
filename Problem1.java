/** Leetcode Question - 1 - Two Sum */
/**Algorithm:
 * Create a hashmap and get the difference between the target and the the element in the array
 * If the element is array is present in the hashmap, return the value of the hashmap key and the current index
 * else put the difference as the key and the index as the value
 */
/**TC- O(N) - Number of elements in the array
 * SC- O(N) - Worst case scenario if the target value is ot achieved
 */

class Solution {
    public int[] twoSum(int[] nums, int target) {
        if(nums.length == 0 || nums == null){
            return new int[] {-1,-1};
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i =0; i<nums.length; i++){
            int n = target - nums[i];
            if(!map.containsKey(nums[i])){
                map.put(n,i);
            }
            else{
                return new int[] {map.get(nums[i]),i};
            }
        }
        return new int[] {-1,-1};
    }
}