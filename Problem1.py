###### Sum of two numbers to target values ######


# go through the array and try to find the target - nums[i] in the array
# time complexity O(n) and space complexity O(n)

def index_of_two_numbers_to_target(nums,k):
    if not nums:
        return [-1,-1]
    
    index_map = {}
    for i in range(len(nums)):
        if (k-nums[i]) in index_map:
            return [i,index_map[k-nums[i]]]

        else:
            index_map[nums[i]] = i
            
    return [-1,-1]


print(index_of_two_numbers_to_target([1,2,5,6],8))
