//Time Complexity : O(n)
//Space Complexity: O(n)

class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) 
    {
        vector<int> ans;
        unordered_map<int,int> map;
        int diff = 0 ;       
            
            for (int i = 0; i< nums.size(); i++)
            {
                diff = target - nums[i] ;
                
                if (map.find(diff) != map.end() && map.find(diff)->second != i )
                {
                    ans.push_back(i);
                    ans.push_back(map.find(diff)->second);
                    return ans;
                }
                map[nums[i]] = i; 
            }            
            
      return ans; //error
    }
};
