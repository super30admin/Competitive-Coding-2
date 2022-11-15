#Time complexity: O(n)
#Space complexity: O(n)

#Accepted on Leetcode

#Approach:
#Store elements in hashMap during first traversal (elem: index)
#During 2nd traversal, as soon as complement of element found in hashMap, return [indexOfElem, indexOfComplement]

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        hashMap = {}
        for i,x in enumerate(nums):
            hashMap[x] = i


        for i,x in enumerate(nums):
            if target - x in hashMap and hashMap[target-x]!= i:
                return [i, hashMap[target-x]]




        

        