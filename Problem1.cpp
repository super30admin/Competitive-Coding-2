/*Use an unordered map (mp) to store the elements of the array along with their indices.
Traverse the array and, for each element nums[i], check if target - nums[i] is already in the map. If yes, return the indices of both elements.
If not found, insert the current element along with its index into the map.
Return an empty vector if no such pair is found.

Time Complexity: O(N), where N is the size of the input vector. The algorithm iterates through each element once.
Space Complexity: O(N), where N is the size of the input vector. The space complexity is determined by the size of the unordered map, which stores elements and their indices.
*/
#include<bits/stdc++.h>
using namespace std;
class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int,int>mp;
        vector<int>result;
        for(int i=0;i<nums.size();i++){
            if(mp.find(target-nums[i])!=mp.end()){
                result.push_back(mp[target-nums[i]]);
                result.push_back(i);
            }else{
                mp.insert({nums[i],i});
            }
    }
            return result;
        }
};