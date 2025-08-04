// Time Complexity: O(n)
//Space Complexity : O(n)

//Leet Code Execution : Yes-
// Started with Brute Force of using 2 loops and then optimized using hashMap
class Solution {
    public int[] twoSum(int[] nums, int target) {

        // Start with HashMap, Save Index and Element 
        // The Start subrating element and check if its present in hashMap, 
        // If present then retrun the index of both elements

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length ; i++){
            map.put(nums[i], i);
        }
        for(int i=0;i<nums.length;i++){
            int k =target - nums[i];
            if(map.containsKey(k) && map.get(k) !=i){ // check for edge case if the element is returning same index
                return new int[]{i,map.get(k)};
            }
        }
        return new int[0];
    }
}