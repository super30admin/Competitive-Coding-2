// Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
// You may assume that each input would have exactly one solution, and you may not use the same element twice.
// You can return the answer in any order.
// Example 1:
// Input: nums = [2,7,11,15], target = 9
// Output: [0,1]
// Output: Because nums[0] + nums[1] == 9, we return [0, 1].



class Solution {
    public int[] twoSum(int[] nums, int target) {
        // will always have a answer
        // array has 2 elements atleast
        if(nums == null || nums.length == 0 )  return new int[]{-1,-1};
        int temp;
        HashMap<Integer , Integer> hashMap = new HashMap<>();
        for(int i =0 ; i < nums.length ; i++){ //[2,7,11,15] , 17 ... 
            temp = target - nums[i]; // trmp = 17-15 = 2 ; 17-7=10
            if(hashMap.containsKey(temp)){ // false; false
                return (new int[]{hashMap.get(temp) , i}); // 
            }
            else{ 
                hashMap.put(nums[i] , i); // 2,0; 7,1
            }
            
            
        }
        return new int[]{-1,-1};
    }
}

// TC - O(n) , Space O(n)
