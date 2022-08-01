# Time complexity : O(n) --> n is the number of elements in the list
# Space complexity : O(n) --> n is the number of elements in the list
# Leetcode : Solved and submitted

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        # Find the length of the given List, create a hashmap to keep the key and value for the value at that index and it's complement
        n = len(nums)
        hashmap = {}
        
        # we then travers the matrix
        for i in range(n):
          
            # find the complement of the element at the current index and check if it is present in the hashmap
            # if present then return the current index and the index of the complement, else store the current value with it's index in the hashmap
            comp = target - nums[i]
            if comp in hashmap:
                return [i,hashmap[comp]]
            hashmap[nums[i]] = i
        
        """
        # Brute force solution - O(n^2)
        n = len(nums)
        for i in range(n):
            for j in range(1,n):
                if nums[i] + nums[j] == target:
                    return [i,j]
        """
