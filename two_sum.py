# Time Complexity:- O(n)
# Space Complexity:- O(n)
# Approach:- In brute force approach we would have used two loops to select one element and and search the entire array if there is another element that sums up to 
# the target element. But an optimized Approach is that we can store the elements we are already seeing in a hashmap :- {element:its index} and then when iterating 
# over the elements in the array we can check in the hashmap to find if the target-element exists in the array or not which eliminates the second iteration and gives 
# a O(n) time complexity Solution.
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        my_dict={}
        for i,v in enumerate(nums):
            if target-v in my_dict:
                return [my_dict[target-v],i]
            my_dict[v]=i