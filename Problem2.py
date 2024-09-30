#Two Sum
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        Map = {}
        for i in range(0, len(nums)):
            a = nums[i]
            diff = target - a
            if diff in Map:
                return [i,Map[diff]]
            else:
                Map[a] = i


            


            

            
        