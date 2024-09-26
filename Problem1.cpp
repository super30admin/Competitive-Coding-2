//Time Complexity - O(N)
//Space complexity -o(N)
class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int,vector<int>>m;
        vector<int>v;
        int n = nums.size();
        for(int i=0;i<n;i++){
            m[nums[i]].push_back(i);
        }
        for(int i=0;i<n;i++){
            if(m[target-nums[i]].size()>1){
                v.push_back(m[nums[i]][0]);
                v.push_back(m[nums[i]][1]);
                break;
            }
            else if(m[target-nums[i]].size()==1&&m[target-nums[i]][0]!=i){
                v.push_back(i);
                v.push_back(m[target-nums[i]][0]);
                break;
            }
        }
        return v;
    }
};