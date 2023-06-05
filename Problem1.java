class Solution {
    public int[] twoSum(int[] nums, int target) {
        //Logic is to store the array value along with the 
        //index in the hashmap.
        HashMap<Integer, Integer> map = new HashMap<>();
        int [] result = new int [2];
        for (int i =0;i<nums.length; i++)
        {
            int comp = target - nums[i];//So when we do this and try to get the remainder
            if (map.containsKey(comp))//we will check in the array if the remainder is there from the previous steps. if it is then return that value of the key stored and the new index we are currently iterating.
            {

                return new int[] {map.get(comp), i};
            }
            

            map.put(nums[i], i);

        }

        return result;

        
        
    }
}