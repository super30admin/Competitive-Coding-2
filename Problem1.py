'''
1 Two sum
https://leetcode.com/problems/two-sum/description/

Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice. You can return the answer in any order.



Example 1:
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

Example 2:
Input: nums = [3,2,4], target = 6
Output: [1,2]

Example 3:
Input: nums = [3,3], target = 6
Output: [0,1]

Solution:
1. Brute force:
Time: O(N^2), Space: O(1)

2. Hashing
Time: O(N), Space: O(N)
'''
from collections import defaultdict
def two_sum(A, T):
    N = len(A)
    h = defaultdict(int)

    start, end = -1, -1
    for i in range(N):
        b = T - A[i]
        if b in h:
            start = h[b]
            end = i
        else:
            h[A[i]] = i

    return [start, end]

def run_two_sum():
    A = [2, 7, 11, 15]
    T = 9
    print(two_sum(A, T))

    A = [2, 7, 11, 15]
    T = 26
    print(two_sum(A, T))

run_two_sum()