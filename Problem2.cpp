class Solution {
    // TC - O(n)
    // SC - O(n)
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        
        unordered_map<int,int> umap;
        vector<int> indices;
        for (int i=0; i<nums.size();i++){
            if(umap.find(target-nums[i]) != umap.end()){
                indices.push_back(i);
                indices.push_back(umap[target-nums[i]]);
                return indices;
            }
            if(umap.find(nums[i]) == umap.end()){
                    umap[nums[i]] = i;
                    cout<< nums[i];
            }
        }
        return indices;
        
    }
};