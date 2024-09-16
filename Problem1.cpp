// Time Complexity : O(n)
// Space Complexity : O(n) extra space used in the form of Hash Map
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

#include<iostream>
#include<vector>
#include<unordered_map>

using namespace std;

class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        
        vector<int> result;
        unordered_map<int,int> m1;  // using a map to store key value
        int temp;
        // traverse through the array once 
        
        for(int i = 0; i < nums.size(); i++){
            temp = target - nums[i];    // calculate the complement
            if(m1.find(temp) != m1.end()){   // check if its there in the map
                result.push_back(i);
                result.push_back(m1[temp]);//return i and the current value of the K:V
                return result;
            }
            else{
            m1[nums[i]] = i;   // complement to indice mapping
            }
        }
        
        return result;
    }
};