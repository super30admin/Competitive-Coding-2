https://leetcode.com/problems/two-sum/

time = O(N) where N = size of array
space = O(K) where k= largest number in the array
For a given number - we know its pair - since we have the target
So we can either find this cuurent number in the hashmap - meaning we already have the index of its pair
Or we will store the current numbers index as a value for the pair's key.

class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int,int> hash;
        for(int i=0;i<nums.size();i++){
            int numToFind = target - nums[i];
            if(hash.find(nums[i])!=hash.end()){
                return {i, hash[nums[i]]};
            }
            hash[numToFind] = i;
        }
        return {0,0};
    }
};

