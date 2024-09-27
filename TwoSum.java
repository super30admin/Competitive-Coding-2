//TC: O(n)
//SC : O(n)


class Solution {
    public int[] twoSum(int[] nums, int target) {



        Map<Integer , Integer> map = new HashMap<>();

        for (int i = 0; i< nums.length ; i++)
        {
            map.put(nums[i], i);
        }

        for (int i = 0 ; i<nums.length ; i++)
        {

            int compliment = target - nums[i];
            if (map.containsKey(compliment) &&  map.get(compliment) != i)
            {
                return new int[] {i , map.get(compliment)};
            }

        }

        return new int[]{-1,-1};


    }
}