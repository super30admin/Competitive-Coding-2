//
// Created by shazmaan on 7/15/2019.
//

#include <iostream>
#include <algorithm>
#include <vector>
#include <map>

using namespace std;

class Solution{
public:
    vector<int> prob(vector<int>& nums, int target){
        map<int,int> hashmap; vector<int> ret;
        for(int x = 0; x<nums.size(); x++){
            if(hashmap.empty()||hashmap.find(nums[x])==hashmap.end()){
                hashmap.insert(pair<int,int>(target-nums[x],x));
            }else{
                ret.push_back(hashmap[nums[x]]);ret.push_back(x);
            }
        }
        return ret;
    }
};

int main(){
    Solution s;
    vector<int> vec{2,7,11,15};
    cout<<s.prob(vec,9).at(1)<<endl;
    return 0;
}