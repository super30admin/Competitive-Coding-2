from typing import List


class Solution:

    def two_sum_one_pass_hash_table(self, nums: List[int], target: int) -> List[int]:
        """
            // Time Complexity : O(n)
                        'n' is the number of elements in the list
            // Space Complexity : O(1)
            // Did this code successfully run on Leetcode :
            // Any problem you faced while coding this :
        """
        if not nums:
            return []

        dic = {}
        for i in range(len(nums)):
            if target - nums[i] in dic:
                return [dic[target - nums[i]], i]
            else:
                dic[nums[i]] = i

    def two_sum_binary_search(self, nums: List[int], target: int) -> List[int]:
        """
            // Time Complexity :  O(nlogn + nlogn )or O(nlogn)
                         Sort + Binary search
                         in worst case need to binary search for each element
                         'n' is the number of elements in the list
            // Space Complexity : O(n+1) or O(n)
                        Tim sort requires O(n) space to sort.
        """
        if not nums:
            return []

        nums.sort()

        for idx, cur in enumerate(nums):
            low = idx + 1
            high = len(nums) - 1
            while low <= high:
                mid = (low + high) // 2
                if cur + nums[mid] == target:
                    return [cur, nums[mid]]
                elif cur + nums[mid] > target:
                    high = mid - 1
                else:
                    low = mid + 1

    def two_sum_two_pointers(self, nums: List[int], target: int) -> List[int]:
        """
            // Time Complexity :  O(nlogn + n )or O(nlogn)
                         Sort + scan using two pointers
                        'n' is the number of elements in the list
            // Space Complexity : O(n+1) or O(n)
                        Tim sort requires O(n) space to sort.
        """
        if not nums:
            return []

        low, high = 0, len(nums) - 1
        # time, space O(n)
        nums.sort()
        # time O(n) , space O(1)
        while low < high:
            if nums[low] + nums[high] == target:
                return [nums[low], nums[high]]
            elif nums[low] + nums[high] < target:
                low += 1
            else:
                high -= 1

    def two_sum_two_pass_hash_table(self, nums: List[int], target: int) -> List[int]:
        """
            // Time Complexity : O(2n) or O(n)
                        'n' is the number of elements in the list
            // Space Complexity : O(1)
        """
        if not nums:
            return []

        dic = {}
        for i in range(len(nums)):
            dic[nums[i]] = i
        for i in range(len(nums)):
            complement = target - nums[i]
            if complement in dic and dic[complement] != i:
                return [i, dic[complement]]

    def two_sum_brute_force(self, nums: List[int], target: int) -> List[int]:
        """
            // Time Complexity : O(n^2)
                        'n' is the number of elements in the list
            // Space Complexity : O(1)
        """
        if not nums:
            return []

        for i in range(len(nums)):
            for j in range(i + 1, len(nums)):
                if nums[i] + nums[j] == target:
                    return [i, j]


if __name__ == '__main__':
    h = Solution()
    print(h.two_sum_brute_force([3, 2, 4], 6))
    print(h.two_sum_one_pass_hash_table([3, 2, 4], 6))
    print(h.two_sum_two_pass_hash_table([3, 2, 4], 6))
    print(h.two_sum_two_pointers([3, 2, 4], 6))
    print(h.two_sum_two_pointers([-100, 54, 32, 532], -46))
    print(h.two_sum_two_pointers([2, 7, 11, 15], 9))
    print(h.two_sum_binary_search([3, 2, 4], 6))
    print(h.two_sum_binary_search([-100, 54, 32, 532], -46))
