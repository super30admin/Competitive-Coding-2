// TC: O(n)
// SC: O(n);
// Did it run on leetcode: yes
// we use a hashmap to store the number and its index. we keep searching for target - nums[i] in the map,
// if we find the match that means we got the number. we just need to store those indexes.


class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        if(nums.empty() || nums.size()==0){
            return {};
        }
            unordered_map<int,int>map;
            vector<int>ans;
            for(int i=0;i<nums.size();i++)
            {
                if(map.find(target - nums[i])!=map.end())
                {
                    ans.push_back(map[target-nums[i]]);
                    ans.push_back(i);
                    return ans;
                }
                else
                {
                    map.insert({nums[i],i});
                }
            }
            return ans;
            
        }
};