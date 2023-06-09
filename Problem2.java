class Solution {
    public int[] twoSum(int[] nums, int target) {

      /* HashSet Solution TC=O(n) SC=O(n)*/
        HashMap<Integer,Integer> myMap = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            // check if the complement of current element is present in the hashset
            // Search is O(1) hence try finding target - currentElement
            if(myMap.containsKey(target-nums[i])){
                return new int[]{myMap.get(target-nums[i]),i};
            }else{
                myMap.put(nums[i],i);
            }
        }
        return new int[]{-1,-1};
    }
}  