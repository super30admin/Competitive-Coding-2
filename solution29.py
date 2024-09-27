#Time Complexity:O(n)
#Space Complexity:O(n)
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        dict={}														#Creating a hash map
        for i in range(len(nums)):									#for every element in the list
            rem=target-nums[i]										#calculate the reminder after the element is subtracted from target
            if nums[i] in dict:										#if the element is already in hashmap
                return i,dict[nums[i]]								#return the current index and the value from the hashmap
            else:
                dict[rem]=i 										#if element not in hashmap add the reminder and current index to the hashmap