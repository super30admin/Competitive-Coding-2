//Time Complexity O(n)
// Space Complexity: O(n)

class Solution {
    public int[] twoSum(int[] nums, int target) {
       
       // Initializing hasmap to sotre numbers and index
        Map<Integer, Integer> hm = new HashMap<>();
        for(int i = 0; i<nums.length; i++){
            //find complement of the number
            int secondNumber = target - nums[i];
            //Check if the number is there in the hasmap or not
            if(hm.containsKey(secondNumber)){
                return new int[]{i,hm.get(secondNumber)};
            }
            // if number is not there, then add the current number in the hasmap
            hm.put(nums[i], i);
        }
        return new int[] {-1, -1};   
    }
}