package Oct26;

class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        
        /* 
      Time Complexity: O(n) where n is no.of elements in the nums array. 
	  Because we may need to iterate through all n elements of nums array in worst case if we have a matching pair at the end of the array and we are doing lookups in hashmap with int key, for which time complexity is O(1).

	  Space Complexity: O(n)
	  Because we are using extra space of a hashmap which can have n number of entries at max in worst case.
	        
	  Did this code successfully run on Leetcode : Yes

	  Any problem you faced while coding this : No

      Approach:
        
        Hashmap used to save complement of each array element and its index.
        Before inserting an element in hashmap, check if hashmap already contains the element. If yes, return the result array. If no, add array element to hashmap and iterate further through the array.
     
        */ 
        
        // Result array
        int[] res = new int[2];
        
        // edge cases
        if (nums == null || nums.length == 0 ) {
            return res;
        }
        
        // creating a hashmap for entries to have key = current array element complement and value = current array element index 
        int numsLen = nums.length;
        Map<Integer, Integer> hm = new HashMap<>();
        
        // check if hashmap contains current array element
        //      if yes, return the index of the entry in hashmap and current index
        //      if no, add complement of current array element to hashmap with value = current index
        for (int i = 0; i < numsLen; i++) {
            int curElem = nums[i];
            int complement = target - curElem;
            if (hm.containsKey(curElem)) {
                res[0] = hm.get(curElem);
                res[1] = i;
                return res;
            } else {
                hm.put(complement, i);
            }
        }
        
        return res;
        
    }
}