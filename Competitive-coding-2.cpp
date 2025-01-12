// Time Complexity : O(N)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution
{
public:
    vector<int> twoSum(vector<int> &nums, int target)
    {
        vector<int> res;
        if (nums.empty())
        {
            return res;
        }

        // to store the difference for re-access to match the target sum
        unordered_map<int, int> diffMap;

        for (int i = 0; i < nums.size(); i++)
        {
            int diff = target - nums[i];
            // if the difference is present in the Hashmap
            // return the result
            if (diffMap.find(diff) != diffMap.end())
            {

                res.push_back(diffMap[diff]);
                res.push_back(i);
                return res;
            }
            else
            {
                diffMap[nums[i]] = i;
            }
        }
        return res;
    }
};