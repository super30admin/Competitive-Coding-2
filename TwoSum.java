//Time complexity: O(n) 
//Space complexity: O(n)  | Size of hashmap in the worst case
//Program ran successfully
/*
    Algorithm: 1. Find the difference between the target and each element in the array
               2. While traversing the array, put each element in a hashmap
               3. Search for the difference value in the hashmap
               4. Return the index of elements when you find the difference in the hashmap
*/


class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] result = new int[2];
        for(int i = 0; i < nums.length; i++){
            int diff = target - nums[i];
            if(map.containsKey(diff)){
                result[0] = map.get(diff);
                result[1] = i;
                return result;
            }
            map.put(nums[i],i);
        }
        return result;
    }
}
