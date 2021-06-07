// Time Complexity : O(n)
// Space Complexity :  O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this - 

class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        
        int len = nums.size();
        int i;
        int idx1, idx2;
        vector<int> ret_vect;
        unordered_map<int, int> sum_map;
        
        for(i = 0; i < len; i++)
        {
            //Element Not found
            if(sum_map.find(nums[i]) == sum_map.end())
                sum_map.insert(pair<int, int>(target - nums[i], i));
            //Element Found
            else
            {
                idx1 = sum_map[nums[i]];
                idx2 = i;
                break;
            }
        }

        ret_vect.push_back(idx1);
        ret_vect.push_back(idx2);
        
        return ret_vect;
    }
};