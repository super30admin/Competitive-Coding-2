# tc O(n), sc O(n).
seen_numbers_hashmap = {}
for idx, num in enumerate(nums):
    curr_difference = target - num
    if curr_difference in seen_numbers_hashmap:
       return [seen_numbers_hashmap[curr_difference], idx]
    seen_numbers_hashmap[num] = idx
