"""
Use a hashmap to store every number's value and the index
For each number, find its complement = (target - num)
If the complement is in map, return its index and current index.
"""
"""
Time Complexity: O(n) — one pass through the input array
Space Complexity: O(n) — to store hashmap
"""

class Problem1:
    def twoSum(self,nums,target):
        num_map = {}

        for i, num in enumerate(nums):
            complement = target - num
            if complement in num_map:
                return [num_map[complement], i]
            num_map[num] = i

if __name__=="__main__":
    nums = [2, 7, 11, 15]
    target = 9
    obj = Problem1()
    print(obj.twoSum(nums,target))

    