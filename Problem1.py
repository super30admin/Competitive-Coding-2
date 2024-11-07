# Problem 1: Two Sum

def two_sum(nums: list[int], target: int)->list[int]:
    # logic: iterate ove array elements and store number: index pairs in a dict
    # if target - current element already present, return the two indices
    if not nums or len(nums) == 0:
        return [-1, -1]
    num_index_dict = {}
    for i in range(0, len(nums)):
        diff = target - nums[i]
        if diff in num_index_dict:
            return [num_index_dict[diff], i]

        num_index_dict[nums[i]] = i
    
    # Not found numbers from the loop, such numbers don't exist.
    return [-1, -1]

def main():
    nums = [1, 2, 5, 6, 4, 9, 10, 13, 15]
    target = 9
    result = two_sum(nums, target)
    print(result)

if __name__ == "__main__":
    main()

"""
    Complexity Analysis:
    Time : O(n)
    Space: O(n) [Extra dictionary used.]
    Ran on Leetcode? : Yes
    Any problems faced during solving this problem: No
"""