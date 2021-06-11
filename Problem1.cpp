//hashmap solution, O(n) TC, O(n) SC 
class Solution {
public:
        vector<int> twoSum(vector<int>& nums, int target) {
          //create hashmap
            unordered_map<int, int> hashmap;
          //loop around
            for (int i = 0; i < nums.size(); i++) {
                if (hashmap.find(target - nums[i]) != hashmap.end()) {
                return {hashmap[target - nums[i]], i};
            }
                        hashmap[nums[i]]=i;
   
        }
        return {-1, -1};  
        }
};

