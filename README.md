# Competitive-Coding-2

Please submit the interview problems posted in slack channel here. The problems and statements are intentionally not shown here so that students are not able to see them in advance 


# Problem 1 (https://leetcode.com/problems/two-sum/description/)

In this problem my approach is check the difference of target and current element. If it is not already in the HashMap we can add it in the HashMap. First we will check if the current element is already in the hashmap or not. If it is already in the hashmap that means the other element of it's pair has already occured and we have stored it's index in the map. If it is there we will jus get the previous element index from the map and current element index and return it otherwise we will put the difference in the hashmap.

# Problem 2 (https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/)
This problem we will solve using dynamic programming. First we will update 0th row and column with 0 and then we will check if the current bucket size is less than the current capacity or not. If it is less than current capacity we will take the element from same column and above row. If it is equal to or greater than the current capacity then we will check the maximum between above value same column and the sum of value associated with that bucket and the element from above row which is current weight behind the columns - here same logic applied suppose we have current weight 1 and the capacity 5 then we will check the element from above bucket (i-1 row) and the column will be one before (j-1 column). Then we will take maximum and update it. At the end we will return the last element of the matrix.