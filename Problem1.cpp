#include<iostream>
#include<vector>
#include<unordered_map>
using namespace std;
/*
Using hash map we can track eaach number and choose the right number to reach the target
Declare a variable cmp = target - nums[i] which gives the remaining number left to reach the target
return empty array if you did not find any pair that satisfies the target 
*/
class Solution{
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int,int> map;
        for(int i=0;i<nums.size();i++){
            int cmp = target - nums[i];
            if(map.find(cmp) != map.end()) return {map[cmp], i};
            else map[nums[i]] = i;
        }
        return { };
    }
};
