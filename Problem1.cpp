//Time complexity - O(n)
//Space complexity - O(n)

class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
       unordered_map<int,int> mp;
        vector<int> ret;

		for(int i=0;i<nums.size();i++){
			if(mp.find(target-nums[i]) == mp.end()){
				mp[nums[i]] = i;
			}else{
				ret.push_back(i);
                ret.push_back(mp[target-nums[i]]);
                return ret;
			}
		}
        return ret;
    }
};
