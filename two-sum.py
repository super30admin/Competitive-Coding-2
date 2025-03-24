'''
This function solves the two-sum problem by using a hash table to track the indices of elements as they're processed.
For each element, it checks if the complementary number (target - current number) exists in the hash table.
If it exists, it returns the indices of the complementary number and the current number, ensuring a solution in O(n) time.

Time Complexity: O(n)
Space Complexity: O(n)
'''

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        mydict = {}

        for index, num in enumerate(nums):
            diff = target - num

            if diff in mydict:
                return [mydict[diff], index]
            else:
                mydict[num] = index