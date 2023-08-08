// Time Complexity: O(n)
// Space Complexity: O(n)

class Problem1 {
    public int[] twoSum(int[] nums, int target) {

        int[] valArr = new int[2];

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for(int i = 0; i < nums.length; i++)
        {
            int complement = target - nums[i];

            if(map.containsKey(complement))
            {
                valArr[0] = i;
                valArr[1] = map.get(complement);
                return valArr;
            }

            map.put(nums[i], i);
        }

        return valArr;
    }
}