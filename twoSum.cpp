#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;

class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int,int> map;
        
        
        for(int i=0;i<nums.size();i++){
            int dif = target-nums[i];
            if(map.find(dif)!=map.end()){
                if(map[dif]!=i){
                return {i,map[dif]};
                }

            }
            else{
                map.insert({nums[i],i});
            }


        }

        return {-1,-1};
        
    }
};