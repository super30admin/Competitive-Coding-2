# Brute Force : I would sort the numbers and have applied 2 pointers to add up 2 numbers everytime and check which adds to target
# But, here we need the indices so we cant sort the numbers

# Soultion: Maintain a hashmap whcih will check for the complement if exists in the hashmap and return the indices
# Edge cases: Since sum says one such combination will always exist, we can return this combination if not in general return -1

def two_sum(nums, target):

    lastSeen = {}

    for idx, val in enumerate(nums):

        potentialMatch = target - val

        if potentialMatch in lastSeen:
            return [idx, lastSeen[potentialMatch]]

        lastSeen[val] = idx


    return -1