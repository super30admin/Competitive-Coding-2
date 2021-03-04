// TC - O(n), SC - O(n)

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Take a hashmap to keep track of numbers we come across in array and its corresponding index
        HashMap<Integer, Integer> map = new HashMap<>();
        // Iterate array from 0 to nums.length
        for(int i = 0; i < nums.length; i++){
            // calculate difference between target and nums[i], if difference value is present in map, return current index and difference index from map else put the current value and index in map
            if(map.containsKey(target - nums[i])){
                return new int[] {i, map.get(target - nums[i])};
            }else{
                map.put(nums[i], i);
            } 
        }
        return new int[0];
    }
// }

// Time Complexity is O(n^2) 
// class Solution {
//     public int[] twoSum(int[] nums, int target) {
        
//         for(int i = 0; i < nums.length - 1; i++){
//             for(int j = i+1; j < nums.length; j++){
//                 if(nums[i] + nums[j] == target){
//                     return new int[] {i, j};
//                 }
//             }
//         }
        
//         return new int[0];
//     }
// }