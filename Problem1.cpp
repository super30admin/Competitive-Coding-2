class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int,int>h;
        for(int i =0;i<nums.size();i++)
        {
            int comp = target -nums[i];
            if(h.find(comp)!=h.end())
             return{h[comp],i};
            else
              h[nums[i]]=i; 
        }
        return {-1,-1};
        
    }
};