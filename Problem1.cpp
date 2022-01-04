class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int,int> map;
        vector<int> v;
        for(int i=0;i<nums.size();i++){
            
            auto it = map.find(target-nums[i]);
            if(it != map.end()){
               v.push_back(it->second);
                v.push_back(i);
            }
            map[nums[i]] = i;
        }
        return v;
    }
};
