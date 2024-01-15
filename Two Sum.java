// O(n) time and O(n) space
class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Arrays.sort(nums);
        // int l = 0;
        // int r = nums.length-1;
        // while(l < r){
        //     int sum = nums[l] + nums[r];
        //     if(sum == target) {
        //         return new int[]{l,r};
        //     } else if(sum < target){
        //         l++;
        //     } else r--;
        // }

        // return new int[]{-1,-1};

        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            int complement = target - num;
            if(map.containsKey(complement)){
                return new int[] {map.get(complement), i};
            } else {
                map.put(num,i);
            }
        }

        return new int[]{-1,-1};
    }
}
