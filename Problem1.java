/*
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        caching = {}
        for i in range(len(nums)):
            compliment = target - nums[i]
            
            if compliment in caching:
                return [i, caching[compliment]]
            
            if nums[i] not in caching:
                caching[nums[i]] = i
*/

// Time - O(n) where n is array size
// Space - O(n)
// Approach - I maintained the numbers in hashmap and everytime check if its compliment is present in hashmap or not

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i=0; i<nums.length; i++){
            int compliment = target - nums[i];
            
            if (map.containsKey(compliment)){
                return new int[] {i, map.get(compliment)};
            }
            if (!map.containsKey(nums[i])){
                map.put(nums[i], i);
            }
        }
        return new int[] {-1, -1};
    }
}