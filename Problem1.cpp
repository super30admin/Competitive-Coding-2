/*Time complexity:
It is O(n) as we are traversing through the array only once.
The search operation in the Hash Map is O(1). So the total time complexity is O(n)
*/

/*Space Complexity:
It is O(n) as we are creating a hash map 
*/

/*Approach:
There are many ways to do this problem. Some of them are brute force, binary search,
two pointers, hashmap, etc. We have used the single pass hash map approach.

The intution behind this approach is if  2 + 1 = 3 then 3 - 2 = 1. We have followed this
thing in making our solution. We created a hash map to store the difference between
the target and the element at the current index. If this difference is already in the
hash map it means that the current element and the value of the difference 
key in the hash map makes the target sum. We can return their index to get our result.
If the difference is not seen in the hash map then the current element is stored in
the hashmap as key and its index as the value.
*/

//The code ran perfectly on leetcode.

class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        
        unordered_map<int, int> temp;
        for(int i = 0; i<nums.size(); i++){
            if(temp.find(target - nums[i]) != temp.end()) return {temp[target - nums[i]], i};
            else temp[nums[i]] = i;
        }
        
        return {};
        
    }
};

