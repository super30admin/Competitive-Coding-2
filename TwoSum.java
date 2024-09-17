//Brute Force
// Time Complexity : O(n^2) where n is the length of nums array
// Space Complexity : O(1)

//CODE

class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (target == (nums[i] + nums[j])) {
                    return new int[] { i, j };
                }
            }

        }
        return new int[] {};
    }
}

// Using HashMap

// Time Complexity : O(n) where n is the length of nums array
// Space Complexity : O(n) -> hashmap space

// CODE

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i); // putting key and their idexes in hashmap
        }

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int rem = target - num; // [3,2,4] target = 6 -> for i=0; rem = 6-3 = 3 ; now we need to check whether 3
                                    // exists in hashmap or not and if it exists we will get the index of that

            if (map.containsKey(rem)) {
                int index = map.get(rem);
                if (index == i)
                    continue; // if hashmap considers the same key as of i
                return new int[] { i, index };
            }
        }
        return new int[] {};

    }
}
