//Time: O(n)
//Space: O(n)


class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        int[] result = new int[2];
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>(); //Creating hashmap
		for(int i=0; i<nums.length; i++) {
			if(!hm.containsKey(target-nums[i])) { //Adding it to hashmap only if the difference does not exists
				hm.put(nums[i], i);
			} else {                            //If difference exists , numbers found
				result[1] = i;
				result[0] = hm.get(target-nums[i]);
			}
		}
		return result;
        
    }
}