class Solution {
    public int[] twoSum(int[] nums, int target) {

    //Approach 1

    //Space Complexity : O(1)
    //Time Complexity : O(n^2)

    //     int i, j;
    //     int[] res = new int[2];
    //     for (i = 0; i < nums.length; i++) {
    //         for (j = i+1; j < nums.length; j++) {
    //             if(nums[i]+nums[j] == target) {
    //                 res[0] = i;
    //                 res[1] = j;
    //             } 
    //         }
    //     }
    // return res;

    //Approach 2
    //Space Complexity : O(n)
    //Time Complexity : O(n)
    int n = nums.length;
    Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
    int[] res = new int[2];
    for(int i = 0; i < n; i++) {
        hm.put(nums[i],i);
    }
    
    for(int i = 0; i < n; i++){
        if(hm.containsKey(target - nums[i]) && hm.get(target - nums[i]) != i) {
            return new int[]{i, hm.get(target - nums[i])};
        }
    }
    return new int[]{};
}
}