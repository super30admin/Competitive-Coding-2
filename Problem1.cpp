//Time Complexity - O(n^2)
//space Complexity - O(1)
//Did it run successfully on leetcode? - Yes
//Approach - Just picking every set of two elements and checking if it adds up to the sum 

class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        int i=0;
        int j=nums.size()-1;
        for(int i=0;i<nums.size();i++)
            for(int j=i+1;j<nums.size();j++)
        {
            if(nums[i]+nums[j]==target)
                return vector<int> {i,j};
        }
        return vector<int> {i,j};
    }
};