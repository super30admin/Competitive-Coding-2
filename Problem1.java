// Time Complexity = O(N)  N = Length of Array
// Space Complecity = O(1)

class Problem1 {
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int[] res = new int[]{-1,-1};

        for(int i=0; i< nums.length; i++) {

            if(map.containsKey(target - nums[i])) {
                res[0] = map.get(target - nums[i]);
                res[1] = i;
            } else {
                map.put(nums[i], i);
            }
        }
        return res;
    }
}