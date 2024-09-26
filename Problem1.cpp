/*

Two sum
Time complexity : O(N)
Space Complexity : O(N) // for the hash table

*/

#include<vector>
#include<iostream>

using namespace std;

class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int,int> hash_set;
        for(int i{};i<nums.size();++i){
            if(hash_set.find(target-nums.at(i))!= hash_set.end()){
                return vector<int> {hash_set[target - nums.at(i)],i};
            }
            hash_set[nums.at(i)] = i;
        }
        return vector<int> {-1,-1};
    }
};