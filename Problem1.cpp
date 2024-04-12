// t - c: n
// s - c: n
class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int, int> nmap;
        int n = nums.size();
        for(int i = 0; i < n; i++)
        {
            nmap[nums[i]] = i;
        }
        for(int i = 0; i < n; i++)
        {
            if(nmap.find(target - nums[i]) != nmap.end())
            {
                if(nmap[target - nums[i]] == i)
                    continue;
                return {i,nmap[target - nums[i]]};
            }
        }
        return {0,0};
        
    }


        
    };
