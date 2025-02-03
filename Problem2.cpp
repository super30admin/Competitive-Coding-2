// Two Sum

// Time Complexity: O(n) where n is the number of elements in the array
// Space Complexity: O(n) where n is the number of elements in the array
// Code ran on Leetcode

//Approach:
//1. Create a map remap to store the elements of the array.
//2. Traverse through the array and check if the target - nums[i] is present in the map.
//3. If it is present, then return the index of the target - nums[i] and the current index.

class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        map<int,int> remap;
        vector<int> answer;
        for(int i = 0; i < nums.size(); i++){
            if(remap.find(target - nums[i]) != remap.end()){
                answer.push_back(remap[target-nums[i]]);
                answer.push_back(i);
                return answer;
            }
            else{
                remap[nums[i]] = i;
            }
        }
        return answer;
    }
};