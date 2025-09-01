// Problem - Two sum
//  Time Complexity : O(n)
//  Space Complexity : O(n)
//  Did this code successfully run on Leetcode : Yes
//  Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// 1. We take a hashmap and check if it exists in our map, if not we add target
// - nums[i] in our map
// 2. If the number exists in our map, that means we have previously encountered
// a number which gives us the target
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
  vector<int> twoSum(vector<int> &nums, int target) {
    unordered_map<int, int> u;
    for (int i = 0; i < nums.size(); i++) {
      if (u.count(nums[i]) > 0) {
        return {u[nums[i]], i};
      }
      u[target - nums[i]] = i;
    }

    return {};
  }
};
