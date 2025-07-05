class Solution {
    public int[] twoSum(int[] nums, int target) {
        //Using hashmap to store number and its index  as it is required to return
        //The idea is as the array has only one solution, for every element, if its a solution then (target-element) will be in the array, so we find it and return the indices of that pair
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i=0;i< nums.length;i++){
            //for every element, calculating the difference between the element and target, and checking if its in hashmap or not
            int dif = target - nums[i];
            if(!hm.containsKey(dif)){
                //If not, storing in hashmap
                hm.put(nums[i], i);
            }else{
                //If yes, then we found the set and returning it
                return new int[]{hm.get(dif),i};
            }
        }
        return new int[]{-1,-1};
    }
}
