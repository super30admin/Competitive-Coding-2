# Competitive-Coding-2

Please submit the interview problems posted in slack channel here. The problems and statements are intentionally not shown here so that students are not able to see them in advance

## Problem: Knapsack problem
# As the problem is divided into sub problems which are solved repeatedly we use dynamic programming. 
# We decide whether to pick a weight or not.
# Case 0: When we don't choose the weight we use the value from the cell above.
# Case 1: When we choose the weight we take the MAX of values from the cell above and compare previous 
# row value
# Return the last value in the dp matrix.

## Problem: Two Sum
# Create a map to store the element & index of the array, in case we have duplicates we will store the 
# element in a second map along with its index.
# Take the difference of the target and the current number, if the difference exists we will return the
# indices for both elements from the first map
# If the current number and the difference is the same then we look for it in the second map and return
# index of the first number from first map and second number from second map.
# If it doesn't exist we return [-1,-1]
