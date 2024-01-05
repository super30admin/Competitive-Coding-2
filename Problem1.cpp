// Time Complexity : O(n log n)

// Space Complexity : O(1)

// Did this code successfully run on Leetcode : YES

// Appoarch: First created pairs with nums[i] and index, the sorted those
// pairs then used two pointer method to check if pairs are equal to target.

#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    vector<int> twoSum(vector<int> &nums, int target)
    {
        int n = nums.size();
        int start = 0;
        int end = n - 1;
        vector<pair<int, int>> ans;
        for (int i = 0; i < n; i++)
        {
            ans.push_back({nums[i], i});
        }
        sort(ans.begin(), ans.end());
        while (start < end)
        {
            if (ans[start].first + ans[end].first == target)
            {
                return {ans[start].second, ans[end].second};
            }
            else if (ans[start].first + ans[end].first < target)
            {
                start++;
            }
            else
            {
                end--;
            }
        }
        return {-1, -1};
    }
};