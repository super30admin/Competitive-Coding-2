
# TC : O(n) - We iterate through the array twice, each taking O(n) time

# SC : O(n) - In the worst case, we store all numbers in the hash map
        
# Approach:
#     1. Use a hash map to store each number and its index
#     2. For each number, check if its complement (target - num) exists in the hash map
#     3. Return the indices of the number and its complement if found

# Runs on leetcode: YES

def twoSum(self, nums, target):
    # Create a dictionary to store value-index pairs for O(1) lookups
    map = {}
    
    # First pass: populate the dictionary with each number as key and its index as value
    # Time complexity: O(n)
    for i in range(len(nums)):
        map[nums[i]] = i  # Store the value and its index
    
    # Second pass: check if the complement of each number exists in our map
    # Time complexity: O(n)
    for i in range(len(nums)):
        # Calculate the complement (the number we need to add to the current number to reach target)
        complement = target - nums[i]
        
        # Check if the complement exists in our map and is not the same element
        # The 'in' operation for dictionaries is O(1) on average
        if complement in map and map[complement] != i:
            # Return the current index and the index of its complement
            return [i, map[complement]]
    
    # If no solution is found after checking all numbers, return [-1, -1]
    return [-1, -1]

#_______________________________________________________________________________________________________

# TC : O(n) - We iterate through the array only once

# SC : O(n) - In the worst case, we store n-1 elements in the hash map
        
# Approach:
#     1. Use a hash map to store each number and its index
#     2. For each number, check if its complement (target - num) exists in the hash map
#     3. Return the indices of the number and its complement if found

# Runs on leetcode: YES

def twoSum(self, nums, target):
    # Dictionary to store numbers we've seen so far and their indices
    res = {}
    # List to store the output indices
    output = []

    # first populate the entire hash map, then check for complements
    
    # One-pass approach: check and update the hash map in a single loop
    for i in range(len(nums)):
        # Calculate the complement needed to reach the target
        cmp = target - nums[i]
        
        # If the complement exists in our hash map, we found our pair
        if cmp in res:
            # Add current index to output
            output.append(i)
            # Add the index of the complement to output
            output.append(res[cmp])
            # Return the indices as soon as we find the first valid pair
            return output
        else:
            # Store the current number and its index in our hash map
            # for future complement checks
            res[nums[i]] = i