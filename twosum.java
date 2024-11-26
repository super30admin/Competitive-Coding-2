// TC : O(n)
// SC : O(n)

class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i=0;i<nums.length;i++){  // putting all elements in the hashmap
            map.put(nums[i],i);
        }
        
        for(int i=0;i<nums.length;i++){
            int difference = target - nums[i];      // calculating complement of each number
            
            if(map.containsKey(difference) && map.get(difference)!=i){  // if complement is present in map and its index not equal to index of current element
                return new int[] {i,map.get(difference)};  // return indices of current element and its complement
            }
        }
        return new int[] {};  // if not present
    }
}