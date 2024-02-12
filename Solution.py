class Solution(object):
    def knapsack(self, n, w, weights, profits):
        """
        time = O(nw)
        space = O(nw)
        """
        dp = [[0] * (w+1) for _ in range(n+1)]
        for i in range(1, n+1):
        	for j in range(1, w+1):
        		if weights[i] < j: # if the weight is more than limit, take the max from previous row.
        			dp[i][j] = dp[i-1][j]
        		else:
        			dp[i][j] = max(dp[i-1][j], profits[i] + dp[i][j-weights[i]]) # else, take the max of the two cases: with the element and without the element
        return dp[-1][-1]

    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        time: O(n)
        space: O(n)
        """
        elem2idx = {}
        for i in range(len(nums)):
            diff = target - nums[i]
            if diff in elem2idx:
                return [i, elem2idx[diff]]
            elem2idx[nums[i]] = i
        return []