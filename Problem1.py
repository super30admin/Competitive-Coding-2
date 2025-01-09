def twoSum(nums, t):
    prevMap = {} # num -> index
    for i, n in nums:
        d = t - n
        if d in prevMap:
            return [prevMap[d], i]
        prevMap[n] = i
        
    # T: O(n), S: O(n)