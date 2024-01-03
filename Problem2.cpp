// Time Complexity : O(n), where n is size of nums.
// Space Complexity : O(n), where n is size of nums.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

#include <vector>
#include <unordered_map>
using namespace std;

class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        //key will be the nums[i] and values will be i
        unordered_map<int,int> umap;
        for(int i = 0;i<nums.size();i++)
        {
            if(umap.find(target-nums[i])!=umap.end())
                return {i,umap[target-nums[i]]};
            else
                umap[nums[i]] = i;
        }
        return {-1,-1};
        
    }
};