#Time : O(n)
#Space : O(n)
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        hmap = dict()
        for i in range(len(nums)):
            search= target - nums[i]
            print(i)
            if search not in hmap:
                hmap[nums[i]] = i
            else:
                return [hmap[search],i]
