"""
Runtime Complexity: O(n) - because we iterate 'n' elements in the list and add it to hashmap.
Space Complexity: O(n) -  new hashmap was created to store 'n' elements.
Yes, the code worked on leetcode.
The idea behind the algorithm is to iterate all the elements and add it to hashmap with value as key and index as the value,
we calculate the difference and check if it is present in hashmap or not. If there is a match in hashmap we return its index else we have not found two 
elements that sums upto the target, therefore we return -1
"""

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        num_hash={}
        for i, num in enumerate(nums):
            match= target- num
            if match in num_hash:
                return [num_hash[match],i]
            num_hash[num]=i