// Time Complexity : O(N) 
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {

        unordered_map<int,int> map;
        vector<int> res;

        for(int i=0;i<nums.size();i++)
        {
            map[nums[i]] = i;
        }

        for(int i=0;i<nums.size();i++)
        {
            int sub = target - nums[i];
            if(map.find(sub)!= map.end())
            {
                if(map[sub] != i)
                {
                    res.push_back(i);
                    res.push_back(map[sub]);
                    return res;
                }
            }
        }
        return res;

    }
};
