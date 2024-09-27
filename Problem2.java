// Time Complexity : O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NO

class Problem2{

public int[] twoSum(int[] nums, int target) {

        /* Brute force approach, time complexity O(N^2)
        for (int i=0; i<nums.length-1; i++){

            for(int j = i+1; j<nums.length; j++)

                if(nums[i] + nums[j] == target)
                    return new int[] {i,j};

        }
         throw new IllegalArgumentException("None");
         */

        //approach using hashmap
        HashMap<Integer,Integer> map = new HashMap<>();


        for(int i=0; i<nums.length; i++){

        //adding values to the map
        map.put(nums[i], i);
        }

        //to find the pairs
        for(int i=0; i<nums.length; i++){

        int c = target-nums[i];

        if(map.containsKey(c) && map.get(c) !=i){
        return new int[]{map.get(c), i} ;
        }

        }
        return new int[] {-1,-1};
        }
}