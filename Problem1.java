/*

TC: O(n)
SC: O(n)

*/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int l = 0;
        int r = n -1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            int complement = target - nums[i];
            if(map.containsKey(complement)){
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{0,0};
    }
}


/*

TC: O(n^2)
SC: O(1)

*/

/**

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        for(int i = 0; i < n - 1; i++){
            for(int j = i + 1; j < n; j++){
                if(nums[i]+nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{0,0};
    }
}
*/