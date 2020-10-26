//Time complexity : O(n) - n is the size of the input vector 'nums'
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach:
/*
 1. Create a map with key as nums[i] and value as index 'i'
 2. Check if tareget-nums[i] is present in the map. If present, then
    store value of index 'i' and the value of key 'target-nums[i]' in a vector.
 */

class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int, int> map;
        unordered_map<int, int>::iterator itr;
        vector<int> res;
        for(int i = 0; i < nums.size(); i++) {
            map[nums[i]] = i;
        }
        
        for(int i = 0; i < nums.size(); i++) {
            itr = map.find(target-nums[i]);
            if(itr != map.end() && itr->second != i){
                res.push_back(i);
                res.push_back(itr->second);
                return res;
            }
        }
        return res;
    }
};
