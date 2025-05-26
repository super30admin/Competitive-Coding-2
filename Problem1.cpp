// Time Complexity O(n)
// Space complexity O(n)
class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int, int> store;
        int n = nums.size();
        for (int i =0; i < n; i++) {
            int curr = target - nums[i];
            auto it = store.find(curr);
            if (it == store.end()) {
                store[nums[i]] = i;
            } else {
                return {it->second, i};
            }
        }
        return {-1, -1};
    }
};