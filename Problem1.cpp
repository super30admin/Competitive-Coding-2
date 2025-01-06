// Author: Subhed Chavan
// Batch: December 24
// Problem Statement: 1. Two Sum
// Approach: Using HashMap
// Time Complexity: O(n)

class Solution
{
public:
    vector<int> twoSum(vector<int> &nums, int target)
    {

        // int -> element and int -> index
        unordered_map<int, int> mp;
        vector<int> res = {-1, -1};

        for (int i = 0; i < nums.size(); i++)
        {
            int currElement = nums[i];

            // Find the difference between target and current element
            int diff = target - currElement;

            // Check if difference has occured before
            if (mp.find(diff) != mp.end())
            {
                // If occured return indexes for two numbers
                res = {mp[diff], i};
                return res;
            }
            else
            {
                // Add current element to HashMap
                mp[nums[i]] = i;
            }
        }

        return res;
    }
};