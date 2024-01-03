#time complexity: O(n)
#space complexity: O(n)
#approach: using hashmap to store the difference and index of the element
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
            Hashmap = {}  # value : index 

            for i,n in enumerate(nums):
                diff = target - n
                if diff in Hashmap:
                    return[Hashmap[diff], i]
                Hashmap[n] = i
            return