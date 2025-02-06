// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        int sz = nums.size();
        unordered_map<int ,int> mp;

        for (int i = 0; i<sz; i++) {
            int rem = target - nums[i];
            if (mp.find(rem)!=mp.end()){
                return {i, mp[rem]};
            }
            mp[nums[i]] = i;
        }
        return {-1, -1};
    }
};