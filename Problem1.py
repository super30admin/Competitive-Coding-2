#Time Complexity : O(n) n-size of list, m-average size of each string in list
#Space Complexity :O(n)
#Did this code successfully run on Leetcode :Yes
#Any problem you faced while coding this :No



class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        hashMap= {}
        
        for i in range(len(nums)):
            diff = target -nums[i]
            if diff in hashMap:
                return [i, hashMap[diff]]
            else:
                hashMap[nums[i]] = i
