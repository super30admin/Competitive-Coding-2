//TWO-SUM

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes

//using hashmap
#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;
//use hashmap to check if target - value is in the map
class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int, int> twosum;
        for (int i = 0; i < nums.size(); i++) {
            int val = target - nums[i];
            if (twosum.find(val) != twosum.end()) {
                return vector<int>{twosum[val], i};
            }
            twosum[nums[i]] = i;
        }
        return vector<int>{-1,-1};
    }
};