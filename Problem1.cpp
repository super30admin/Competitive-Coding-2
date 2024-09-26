//time complexity : o(n)
//space complexity : o(n)

class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        
        unordered_map<int,int> map;
        
        int n = nums.size();
        
        for(int i = 0;i<n;i++) {
            map[nums[i]] = i;
        }
        
        vector<int> v;
        for(int i =0;i<n;i++) {
            
            if(map.find(target - nums[i]) != map.end() && map[target - nums[i]] != i) {
                 v.push_back(i);
                 v.push_back(map[target - nums[i]]);
                break;
        }
    }
               
      return v;
    }
};