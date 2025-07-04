'''
1. Two Sum

Problem Name: Interview Problem : Two elements sum to target

Source Link: https://leetcode.com/problems/two-sum/
'''

# Time Complexity : O(n^2) for brute force, O(n) for optimized approach
# Space Complexity : O(1) for brute force, O(n) for optimized approach
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Yes, understanding the problem statement and implementing the optimized approach correctly.

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        # Brute Force Approach
        # Time Complexity : O(n^2)
        # Space Complexity : O(1)
        # n = len(nums) # humne nums ki length store ki hai in n (We stored the length of nums in n)
        # for i in range(n): # yeh loop i ko 0 se lekar n-1 tak iterate karega (This loop will iterate i from 0 to n-1)
        #     for j in range(i+1, n): # yeh loop j ko i+1 se lekar n-1 tak iterate karega (This loop will iterate j from i+1 to n-1)
        #         if nums[i] + nums[j] == target: # agar nums[i] aur nums[j] ka sum target ke barabar hai (if the sum of nums[i] and nums[j] is equal to target)
        #             return [i,j] # toh hum i aur j ki index return karte hain (then we return the indices i and j)
        # return [] # agar koi pair nahi mila toh empty list return karte hain (if no pair is found, we return an empty list)


        # Optimized Approach
        # Time Complexity : O(n)
        # Space Complexity : O(n)
        # Sol 1
        # map_num_to_index = {} # humne ek dictionary banayi hai jisme numbers ko unki index ke saath store karte hain (We created a dictionary to store numbers with their indices)
        # for i in range(len(nums)): # yeh loop nums ke har element ko iterate karega (This loop will iterate through each element of nums)
        #     map_num_to_index[nums[i]] = i # humne current number ko uski index ke saath dictionary mein store kiya (We store the current number with its index in the dictionary)
        # # ab hum har number ke liye check karte hain ki kya uska complement (target - current number) dictionary mein hai (Now we check for each number if its complement (target
        # for i in range(len(nums)): # yeh loop nums ke har element ko iterate karega (This loop will iterate through each element of nums)
        #     complement = target - nums[i] # complement ko target se current number ko subtract karke nikaalte hain (We calculate the complement by subtracting the current number from the target)
        #     if complement in map_num_to_index and map_num_to_index[complement] != i: # agar complement dictionary mein hai aur uski index current index se alag hai (if the complement is in the dictionary and its index is different from the current index)
        #         return [i, map_num_to_index[complement]] # toh hum current index aur complement ki index return karte hain (then we return the current index and the index of the complement)
        #     map_num_to_index[nums[i]] = i  # yeh line unnecessary hai, kyunki humne already current number ko index ke saath store kiya hai (This line is unnecessary since we already stored the current number with its index)
        # return [] # agar koi pair nahi mila toh empty list return karte hain (if no pair is found, we return an empty list)
        # Sol 2
        # Using a single pass with a dictionary
        num_to_index = {} # humne ek dictionary banayi hai jisme numbers ko unki index ke saath store karte hain (We created a dictionary to store numbers with their indices)
        for i, num in enumerate(nums): # yeh loop nums ke har element ko index ke saath iterate karega (This loop will iterate through each element of nums with its index)
            '''
            how enumerate works:
            enumerate(nums) will give us pairs of (index, value) for each element in nums
            For example, if nums = [2, 7, 11, 15],
            enumerate(nums) will yield (0, 2), (1, 7), (2, 11), (3, 15)
            where i is the index and num is the value at that index.
            This allows us to keep track of both the index and the value in a single loop.
            '''
            complement = target - num # complement ko target se current number ko subtract karke nikaalte hain (We calculate the complement by subtracting the current number from the target)
            if complement in num_to_index: # agar complement dictionary mein hai (if the complement is in the dictionary)
                return [num_to_index[complement], i] # toh hum complement ki index aur current index return karte hain (then we return the index of the complement and the current index)
            num_to_index[num] = i # humne current number ko uski index ke saath dictionary mein store kiya (We store the current number with its index in the dictionary)
        return [] # agar koi pair nahi mila toh empty list return karte hain (if no pair is found, we return an empty list)       