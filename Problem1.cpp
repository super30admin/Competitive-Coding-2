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