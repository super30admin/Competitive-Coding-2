// WE will be using  ahashmap to store the element in the map. While entering the element into the map we check to see if the complement of the number is present in the map. If yes we will be able to return that index and the current index as the two sum indices.

// Time complexity: O(n)
//Space Complexity: O(n)
class Problem2 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            int diff = target-nums[i];
            if(map.containsKey(diff)){
                return new int[] {map.get(diff),i};
            }
            map.put(nums[i],i);
        }
        return new int[] {};
        
}
}