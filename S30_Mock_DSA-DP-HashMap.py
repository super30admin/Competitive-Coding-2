# Two Sum_Solution

# using hashmap 
# create empty hash table
# Iterate over the list of nums and index using enumerate()
# For each number, we will calculate target - num, if the complement is already in the hash table, it means we've seen a number that,  when added to the current, equals the target, we return index and current
# if complement not found, store the current and index in the hash table

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        hash_map = {}

        for i, num in enumerate(nums):  
            complement = target - num

            if complement in hash_map:
                return [hash_map[complement], i]

            hash_map[num] = i  


# 0/1 KnapSack_Solution

class Solution:

    def knapSack(self, capacity, wt, val):
        n = len(val)
        
        # it would create independent rows. All lists / rows will point to different memory address.
        dp = [[0 for i in range(capacity + 1)] for i in range(n + 1)]

        for i in range(1, n + 1):
            for w in range(capacity + 1):
                if wt[i - 1] <= w:  # If the current item's weight is less than or equal to the capacity
                    dp[i][w] = max(val[i - 1] + dp[i - 1][w - wt[i - 1]], dp[i - 1][w])
                else:
                    dp[i][w] = dp[i - 1][w]

        return dp[n][capacity]