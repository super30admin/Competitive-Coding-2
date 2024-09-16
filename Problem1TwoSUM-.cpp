//TC-O(N)
//SC-O(N)
class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        int n=nums.size();
        vector<int>res(2,-1);
        unordered_map<int,int> h;
        for(int i=0;i<n;i++){
            if(h.find(target-nums[i])!=h.end()){
                res[1]=i;
                res[0]=h[target-nums[i]];
            }
            h[nums[i]]=i;
        }
        return res;
    }
};