'''
1 Two sum
https://leetcode.com/problems/two-sum/description/

Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have EXACTLY ONE solution, and you may not use the same element twice. You can return the answer in any order.

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

2. Sort and Binary Search
Time: O(N log N), Space: O(1)

3. Hashing
Time: O(N), Space: O(N)

4. Two Pointer
Time: O(N log N), Space: O(1)
'''

def two_sum_1(nums, K):
    '''
    Brute Force
    '''
    N = len(nums)
    if N <= 1:
        return []
    result = set()
    for i in range(N):
        a = nums[i]
        for j in range(i+1, N):
            b = nums[j]
            if a + b == K:
                result.add(tuple(sorted([a, b])))
                return result
    return result

def two_sum_2(nums, K):
    '''
    Sort and Binary Search
    '''
    def binary_search(A, s, e, tgt):
        if len(A) == 0:
            return -1
        while s <= e:
            mid = s + (e-s)//2
            if A[mid] == tgt:
                return mid
            elif A[mid] < tgt:
                s = mid + 1
            else:
                e = mid - 1
        return -1

    N = len(nums)
    if N <= 1:
        return []

    result = set()
    nums = sorted(nums)
    for i in range(N): # O(N)
        tgt = K - nums[i]
        if i < N-1:
            index = binary_search(nums, i+1, N-1, tgt) # O(log N)
            if index != -1:
                result.add(tuple(sorted([nums[i], tgt])))
                return result
    return result

def two_sum_3(nums, K):
    '''
    Hashing
    '''
    N = len(nums)
    if N <= 1:
        return []
    result = set()
    h = set()
    for i in range(N):
        tgt = K - nums[i]
        if tgt in h:
            result.add(tuple(sorted([nums[i], tgt])))
            return result
        h.add(nums[i])
    return result

def two_sum_4(nums, K):
    '''
    Two Pointer
    '''
    N = len(nums)
    if N <= 1:
        return []
    result = set()
    nums = sorted(nums)
    left, right = 0, N-1
    while left < right:
        sum = nums[left] + nums[right]
        if sum == K:
            result.add(tuple([nums[left], nums[right]]))
            left += 1
            right -= 1
            return result
        elif sum > K:
            right -= 1
        else:
            left += 1
    return result



def two_sum(nums, target, method):
    if method == 1: # brute force
        pairs = two_sum_1(nums.copy(), target)
    elif method == 2: # sort and binary search
        pairs = two_sum_2(nums.copy(), target)
    elif method == 3: # hashing
        pairs = two_sum_3(nums.copy(), target)
    elif method == 4: # two-pointer
        pairs = two_sum_4(nums.copy(), target)
    else:
        print(f" Invalid method ")

    return list(pairs)

def run_tests():
    # return actual numbers instead of indices
    tests = [([2,7,11,15], 9, [(2, 7)]),
             ([2,7,11,15], 26, [(11, 15)]),
    ]


    for test in tests:
        nums, K, ans = test[0], test[1], test[2]
        for method in [1, 2, 3, 4]:
            pairs = two_sum(nums, K, method)
            print(f"\nnums = {nums}")
            print(f"Target sum = {K}")
            print(f"Method {method}: Pairs = {pairs}")
            print(f"Pass: {all([t in ans for t in pairs])}")

    print(f"\nDONE")

run_tests()