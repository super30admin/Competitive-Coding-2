// Time Complexity : O(n) --> Iterate through the entire array once 
// Space Complexity : O(n) --> Hashmaps
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Figuring out efficient algorithm


// Your code here along with comments explaining your approach

/*
1. Create a hashmap with complement as the key and value as the index
2. Return the vector that stores list of index when key is matched
*/

#include <iostream>
#include <algorithm>
#include <vector>
#include <unordered_map>

using namespace std;

class Solution{
public:
    vector<int> twoSum(vector<int>& nums, int target){
        unordered_map<int, int> mp; 
        vector<int> returnValue;
        
        for(int i = 0; i<nums.size(); i++){
            if(mp.empty()||mp.find(nums[i])== mp.end())
                mp.insert(pair<int,int>(target-nums[i],i));
            else
            {
                returnValue.push_back(mp[nums[i]]);
                returnValue.push_back(i);
            }
            
        }
        
        return returnValue;
    }
};

int main(){
    Solution s;
    vector<int> vec{2,7,11,15};
    cout<<s.twoSum(vec,9).at(1)<<endl;
    return 0;
}