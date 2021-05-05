// two-sum

// Time complexity-O(n)
// space complexity O(n);
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no

// iterate over each element and calculate the difference between that element and target
// if difference exist in the hash map return the curr element index and the index of the element found in the hash_map

class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        vector<int> result;
        unordered_map<int,int>hash_map;
        
        for( int i=0;i< nums.size();i++){
            int diff= target-nums[i];
            
            if(hash_map.find(diff) == hash_map.end()){
                hash_map[nums[i]] = i;
            }
            else{
                result.push_back(i);
                result.push_back(hash_map[diff]);
                break;
            }
        }
        
        return result;
    }
};