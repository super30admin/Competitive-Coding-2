class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        
        map = {}
        
        for a in range(0,len(nums)):
            req = target - nums[a]
            if req in map:
                return[a,map[req]]
            else:
                map[nums[a]] = a