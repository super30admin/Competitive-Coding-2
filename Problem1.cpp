//TC : O(n) -> we are iterating over the array 
//SC : O(n) -> created a hashmap

class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) 
    {
        unordered_map<int, int> map1;
        vector<int> ans;
        for(int i=0;i<nums.size();i++){
            if(map1.find(target - nums[i])!=map1.end()){
                ans.push_back(i);
                ans.push_back(map1[target - nums[i]]);
                return ans;
            }
            map1[nums[i]]= i;
        }
        return ans;
    }
};