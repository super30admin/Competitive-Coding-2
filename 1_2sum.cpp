// Time Complexity : O(N)
// Space Complexity :O(N)

class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        if(nums.empty() || nums.size() == 0){
            vector<int> x;
            return x;
        }
        vector<int> v;
        unordered_map<int,int> m;
        for(int i=0;i<nums.size();i++)
        {
            if(m.find(target-nums[i])!=m.end())
            {
                v.push_back(m[target-nums[i]]);
                v.push_back(i);
                return v;
            }
            else
                m[nums[i]]=i;
        }
       return v;
        
    }
};
