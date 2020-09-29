//time complexity:O(n)
//space complexity:O(n)
//executed on leetcode: yes
//approach:using hashmap
//any issues faced? no
class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        vector<int>res;
        map<int,int>map;
        for(int i=0; i<nums.size(); i++)
        {
            int val=target-nums[i];
            if(map.find(val)!=map.end() && map[val]!=i)
            {
                res.push_back(i);
                res.push_back(map[val]);
                break;
            }
            else
            {
                map[nums[i]]=i;
            }
        }
        return res;
    }
};