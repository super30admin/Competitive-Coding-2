// Time complexity O(N)
// Space complexity O(N)

class Solution {
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> hmap = new HashMap<>();

        for( int i = 0; i < nums.length; i++) {

            int difference = target - nums[i];

            if(hmap.containsKey(difference)) {

                return new int[]{hmap.get(difference), i};

            }

            else {

                hmap.put(nums[i],i);

            }


        }

        throw new IllegalArgumentException("Indices not found");


    }
}