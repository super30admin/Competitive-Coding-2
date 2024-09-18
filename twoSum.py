# time Complexity: O(n)
# space complexity: O(n)
def twoSum(self, nums: List[int], target: int) -> List[int]:

        map = dict()
        
        for i in range(len(nums)):
            if target - nums[i] in map:
                return [i,map[target-nums[i]]]
            else:
                map[nums[i]] = i