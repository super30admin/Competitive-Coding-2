class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        //storing the nums and index until i get the difference from target in the map
        for(int i=0;i<nums.length;i++){
            int diff = target-nums[i];
            if(map.containsKey(diff)){
               return new int[]{map.get(diff),i};
            }
            map.put(nums[i],i);
        }
        return new int[]{-1,-1};
    }
}

//time :O(n) we iterate in worst case all elements where n is num of elements
//space : O(1) because we take constant time for 2 elements in new array
