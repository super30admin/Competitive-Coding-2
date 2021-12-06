#include <vector>
#include <unordered_map>

using namespace std;

//Time complexity : O(n)
//Space complexity : O (n)

//Approach:
//          Save index of each value in the array
//          Calculate target - current value
//          Find resultant value in the hashmap

class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        
        unordered_map<int,int> hash_map;
        
        for(int i = 0; i < nums.size(); i++)
        {
            int need = target - nums[i];
            if(hash_map.find(need) != hash_map.end())
            {
                return {hash_map[need], i};
            }
            hash_map[nums[i]] = i;
        }
        
        return {};
    }
};