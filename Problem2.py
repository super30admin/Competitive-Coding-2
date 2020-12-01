# 2 sum when input array is sorted
# Time Complexity - O(N)

# Space Complexity - O(1)

# Approach
# I use the two pointer technique with low set to 0 and high set to last element. If the sum of elements indicated
# by the pointers is greater than the target I decrement the high pointer and in reverse case I increment the low
# pointer.

class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        low = 0
        high = len(numbers) - 1

        while (low < high):
            sum = numbers[low] + numbers[high]
            if sum == target:
                return [low + 1, high + 1]
            elif sum < target:
                low += 1
            else:
                high -= 1

