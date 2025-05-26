# Time complexity: O(n)
# Space complexity: O(n)

def sum_target(nums, target):
    num_map = {}
    for i, num in enumerate(nums):
        if target - num in num_map:
            return [num_map[target - num], i]
        num_map[num] = i

    return []







# Time complexity: O(n)
# Space complexity: O(n)

def productArray(nums):
    n = len(nums)
    prefix = [1] * n
    suffix = [1] * n
    output = [1] * n

    for i in range(1, n):
        prefix[i] = prefix[i - 1] * nums[i - 1]

    for i in range(n - 2, -1, -1):
        suffix[i] = suffix[i + 1] * nums[i + 1]

    for i in range(n):
        output[i] = prefix[i] * suffix[i]

    return output
