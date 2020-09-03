//T : O(N)
//S: O(N)

class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        
        map<int, int> store;
        
        vector<int> res;
        for(int i=0;i<nums.size();i++){ //2
            if(store.find(target-nums[i])!=store.end()){ // 9-2 = 7
                res.push_back(i);
                res.push_back(store[target-nums[i]]); 
                
            }else{
                store[nums[i]] = i; //2 // 0
            }
        }
        
        return res;
        
        
    }
};