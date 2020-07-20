# Comepetitive-Coding-2

# Problem 1: https://leetcode.com/problems/two-sum/
An array is given in the question and you need to return the indices of two numbers such that they add up to a specific target. assume that there is only one solution for each input and you cannot use the same element twice. 



Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,

return [0, 1].

# Problem 2:0-1 Knapsack Problem | DP-10
we are given weights and values of n items. we need to put these items in a knapsack of capacity W to get maximum value in our knapsack.

or we can say that we are given two integers arrays val[0......n-1] and wt[0.....n-1] which represent values and weights associated with n items respectively. we are also given an integer W  which represents knapsack capacity.

find out the maximum value subset of val[] such that sum of the weights of this subset is smaller than or equal to W. but you cannot break an item, either pick the complete item or dont pick it(known as 0-1 property).

knapsack-problem