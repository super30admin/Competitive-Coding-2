/*
time Complexity -> O(N)where N is size of nums 
space complexity -> O(1) constant space 

*/

class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
    unordered_map<int,int>umap;//target-nums[i],index
    vector<int>result;
    for(int i = 0; i < nums.size();i++){
        if(umap.find(nums[i])!=umap.end())//i have found in map;
        {
            result.push_back(umap[nums[i]]);
            result.push_back(i);
            return result;
        }
        else umap[target-nums[i]]=i;
    }
        return result;
    }
};