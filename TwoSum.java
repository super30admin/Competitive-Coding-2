// Time Complexity : O(n) single iteration over all elements
// Space Complexity : O(n) because HashMap used to store the n occurances for processing
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        //null check
        if( nums.length == 0 || nums == null ) return new int[] {-1,-1};
        
        HashMap<Integer, Integer> map = new HashMap<>(); 
        
        int rSum = 0; //initializing running sum
        
        for(int i = 0; i < nums.length; i++) { //looping over the given array
            map.put(nums[i], i); //storing index as value in map
        }
        
        for( int i = 0; i < nums.length; i++ ) { //looping over the given array
            int compliment = target - nums[i]; //calculate compliment for current element
            if(map.containsKey(compliment) && map.get(compliment) != i) {
                return new int[] {i,map.get(compliment)};
                
            }
        }
        return new int[] {-1,-1};
    }
}