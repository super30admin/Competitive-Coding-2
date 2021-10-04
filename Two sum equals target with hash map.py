# TC-O(n)
# SC-O(n)
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        hashmap={}
        for i in range(len(nums)):
            if nums[i] not in hashmap:
                hashmap[nums[i]]= i
        for i in range(len(nums)):
            find=target-nums[i]
            if find in hashmap:
                if i==hashmap[find]:
                    continue
                else:
                    return (i,hashmap[find])