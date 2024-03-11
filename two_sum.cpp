// Time Complexity : O(n)  
// Space Complexity : O(1)   

/*
Leetcode : https://leetcode.com/problems/two-sum/description/

Given an array of integers nums and an integer target, 
return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, 
and you may not use the same element twice.
You can return the answer in any order.
*/

/*
Explaination : 
Using Map to store each element. and if target - arr[i] is already present in the MAP that means
we have found our solution.
*/

class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        std::unordered_map<int, int>tMap;

        for(int i = 0; i<nums.size(); i++){
            if(tMap.find(target-nums[i]) == tMap.end()){
                tMap[nums[i]] = i;
            } else {
                return {tMap[target-nums[i]], i};
            }
        }
        return {-1, -1};
    }
};