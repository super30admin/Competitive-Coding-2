// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        vector<int>result;
        map<int,int> hashmap;
        for(int i=0;i<nums.size();i++){
            hashmap.insert(pair<int,int>(nums[i],i));
        }
        for(int i=0;i<nums.size();i++){
            int complement = target-nums[i];
            if(hashmap.find(complement)!=hashmap.end() && hashmap[complement]!=i){
                result.push_back(i);
                result.push_back(hashmap[complement]);
                return result;
            }
        }
        return {};
    }
};
