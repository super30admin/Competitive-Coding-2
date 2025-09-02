class Problem1(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        # tc : O(n)
        # sc : O(n)
        # optimize approach save the value we come across in the array and keep checking if the compliment of the target-arr[i]
        # is in the hash map and since there is only exactly one solution once found we can return the indexes from the map

        if len(nums) < 2:
            return -1 # requires two indices which add up to the target

        hash_map = {}

        for i in range(len(nums)):
            if target - nums[i] in hash_map:
                return [i,hash_map[target - nums[i]]]
            else:
                hash_map[nums[i]] = i

        return -1 # fallback if no valid solution exists returning -1 ( this won't be required as the question says there is exaclty one solution)

        

        
        