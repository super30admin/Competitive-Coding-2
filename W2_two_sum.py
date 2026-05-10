class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        result = []
        hashmap = {}

        for i in range(len(nums)):
            complement = target - nums[i]

            if complement not in hashmap:
                hashmap[nums[i]] = i
            else:
                result.append(i)
                result.append(hashmap[complement])

        return result

# Time complexity: O(N), we visit each element once.
# Space complexity: O(N), if the pair is found at the last index, then the hashmap will have n-1 keys worst case

