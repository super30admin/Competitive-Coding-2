//T.C-O(n);
//S.C-O(n);
//passed all test cases
// the approach is to store the element in hashmap and check for target-element in it.
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int a[] = new int[2];
        a[0] = -1;
        a[1] = -1;
        for (int i = 0; i < nums.length; i++) {
            if (hm.size() != 0) {
                if (hm.containsKey(target - nums[i])) {
                    a[0] = hm.get(target - nums[i]);
                    a[1] = i;
                    return a;
                }
            }
            hm.put(nums[i], i);
        }
        return a;
    }
}