// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// Maintain a hashmap with key as value @ index and the value as index
// At every element, search for the diff -> target - nums[i] in the map
// If found, retrieve the indices and populate the answer vector and return that

class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int, int> map;
        int n = nums.size();
        vector<int> ans(2);
        for(int i=0; i<n; i++) {
            int diff = target - nums[i];
            if(map.find(diff) != map.end()) {
                ans[0] = i;
                ans[1] = map[diff];
                break;
            }
            map[nums[i]] = i;
        }
        return ans;
    }
};