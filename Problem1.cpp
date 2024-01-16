//Question: 1.Two Sum

// Time Complexity : O(n)
// Space Complexity : O(1)
// Any problem you faced while coding this : no.
// Did this code successfully run on Leetcode : yes

// Your code here along with comments explaining your approach
// We store all the elements of array input along with their indexes into map. Then for each element we calculate complement
// and verify if that element is present in map. If present then we return the index of the array element and complement element.

#include<vector>
#include<unordered_map>

class Solution {
public:
    std::vector<int> twoSum(std::vector<int>& nums, int target) {
        std::unordered_map<int, int> map;
        for(int i = 0; i < nums.size(); i++)
        {
            map[nums[i]] = i;
        }

        for(int i = 0; i <nums.size(); i++)
        {
            int complement = target - nums[i];
            if(map.find(complement) != map.end() && map[complement] != i)
            {
                return {i, map[complement]};
            }
        }
        return {};
    }
};