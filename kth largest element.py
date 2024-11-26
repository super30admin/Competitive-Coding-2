#Time Complexity: (n-k)*logk
#Space Complexity: O(k)
class Solution(object):
    def findKthLargest(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        import heapq
        heap_arr = list(nums[0:k])
        #new_ls = list(nums)
        heapq.heapify(heap_arr)
        for i in range(k, len(nums)):
            if nums[i] > heap_arr[0]:
                heapq.heappop(heap_arr)
                heapq.heappush(heap_arr,nums[i])
        return heap_arr[0]
