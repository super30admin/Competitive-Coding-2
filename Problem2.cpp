//Time Complexity : O(N), where n is the size of the vector.
//Space Complexity : O(N), where n is the size of the map.
class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int,int> map;
        vector<int> result;
        for(int i=0; i<nums.size(); i++){
            if(map.count(target-nums.at(i))>0){
                int index = map[target-nums.at(i)];
                result.push_back(index);
                result.push_back(i);
            }
            map.emplace(nums.at(i),i);
        }
        if(result.size()==0){
            result.push_back(-1);
            result.push_back(-1);
        }
        return result;
    }
};