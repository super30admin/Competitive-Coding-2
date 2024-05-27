// Two Sum Problem
// Given an array of integers numsand an integer target, return indices of the two numbers such that they add up to target.
// You may assume that each input would have exactly one solution, and you may not use the same element twice.
// You can return the answer in any order.

// Time Complexity : O(n)
// Space Complexity : O(n)

#include <iostream>
#include <vector>
#include <unordered_map>
class Solution {
public:
    std::vector<int> twoSum(std::vector<int>& nums, int target) {
        std::vector<int> result(2, 0);
        if (nums.empty() || nums.size() < 2) {
            return result;
        }
        std::unordered_map<int, int> hmap;
        for (int i = 0; i < nums.size(); ++i) {
            int num = nums[i];
            int diff = target - num;
            if (hmap.find(num) != hmap.end()) {
                result[0] = i;
                result[1] = hmap[num];
                return result;
            }
            else {
                hmap[diff] = i;
            }
        }
        return result;
    }
};

int main() {
    Solution solution;
    // Example 1
    std::vector<int> nums1 = { 2, 7, 11, 15 };
    int target1 = 9;
    std::vector<int> result1 = solution.twoSum(nums1, target1);

    if (!result1.empty()) {
        std::cout << "Example 1 Indices: " << result1[0] << ", " << result1[1] << std::endl;
    }
    else {
        std::cout << "Example 1 : No solution found." << std::endl;
    }

    // Example 2
    std::vector<int> nums2 = { 2, 11, 15, 19, 9, 7};
    int target2 = 9;
    std::vector<int> result2 = solution.twoSum(nums2, target2);

    if (!result2.empty()) {
        std::cout << "Example 2 Indices: " << result2[0] << ", " << result2[1] << std::endl;
    }
    else {
        std::cout << "Example 2 : No solution found." << std::endl;
    }

    return 0;
}
