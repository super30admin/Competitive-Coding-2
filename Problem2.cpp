// We iterate through the array while maintaining a HashMap to store each number and its index.
// For every element nums[i], we compute the complement target - nums[i] and check if it already exists in the map.
// If it exists, we return the pair of indices; otherwise, we store the current number for future lookups.

 // Time Complexity:
O(n) — Each number is processed and looked up in the map at most once.

 // Space Complexity:
  O(n) — In the worst case, we store all n numbers in the HashMap.

  class Solution {
      
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> mp = new HashMap<>();

        for(int i =0; i< nums.length;++i){
            int x = target - nums[i];
            if(mp.containsKey(x)){
                return new int[]{mp.get(x),i};
            }
            mp.put(nums[i],i);
        }
        return new int[]{0,0};
    }
}

