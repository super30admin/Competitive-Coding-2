// Two sum problem

// Time Complexity : O(n) where n is the length of the input array
// Space Complexity : O(n) where n is the length of the input array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Declare a hasmap that stores the elements in the nums array with value as index.
// For every element, calculate the difference between target and the element.
// Search for the difference in the hashmap, if it is present then return the current element index and the value of the element in the hashmap.


class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int,int> m;
        int n = nums.size();
        for(int i=0; i<n; i++){
            int dif = target - nums[i];
            if(m.count(dif)){
                return {i,m[dif]};
            }
            m[nums[i]] = i;
        }
        return {};
    }
};