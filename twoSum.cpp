//Time complexity:  O(n)
//space complexity: O(n)
class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int ,int> um;  // store the number (key) and the index (value)
        vector<int> answer;
        
        for(int i=0;i<nums.size();i++){
            if (um.find(target-nums[i])==um.end()) { //the element is not present in the map
                um[nums[i]]=i; 
            } else { 
                //we find the result
                answer.push_back(um[target-nums[i]]); //index of the first number
                answer.push_back(i); //index of second number
               break;  
            }
        }
        
        return answer;
    }
};