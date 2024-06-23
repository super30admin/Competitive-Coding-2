//Time O(n)
//Space O(n)
//Leetcode: yes
//issue seen: none

class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int, int> mp;
        vector<int> ans;

        for(int i=0;i <nums.size(); i++){
            int diff = target - nums[i];
            if(mp.find(diff) == mp.end()){
                mp[nums[i]] = i;
            } else if(i != mp[diff]){
               ans.push_back(i);
               ans.push_back(mp[diff]);
               return ans;
            }
        }
        return {-1, -1};
        
    }
};
