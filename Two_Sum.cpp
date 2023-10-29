#include<unordered_map>
class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int, int> results;
        int n=nums.size();
        for(int i=0;i<n;i++){
            int difference = target-nums[i];
            if(results.count(difference))return {results[difference],i };
            results[nums[i]]=i;
        }
        
    return {-1,-1};
    }
};
