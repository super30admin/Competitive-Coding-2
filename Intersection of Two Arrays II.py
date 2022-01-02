# Time Complexity: O(n+m)
# Space Complexity: O(m)
class Solution(object):
    def intersect(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[int]
        """
        dic = {}
        one_arr = None
        two_arr = None
        if len(nums1) >= len(nums2):
            one_arr = nums2
            two_arr = nums1
        else:
            one_arr = nums1
            two_arr = nums2
        for i in one_arr:
            if i not in dic:
                dic[i] = 1
            else:
                dic[i] += 1
        ans = []
        for j in two_arr:
            if j in dic and dic[j] > 0:
                ans.append(j)
                dic[j] -= 1
        return ans
# Time Complexity: O(logn+logm+m)
# Space Complexity: O(1)
class Solution(object):
    def intersect(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[int]
        """
        nums1.sort()
        nums2.sort()
        p1 = 0
        p2 = 0
        ans = []
        while p1 <len(nums1) and p2 < len(nums2):
            if nums1[p1] == nums2[p2]:
                ans.append(nums1[p1])
                p1 += 1
                p2 += 1
            elif nums1[p1] < nums2[p2]:
                p1 += 1
            else:
                p2 += 1
        return ans

# Time Complexity: O(logn+logm+mlogn)
# Space Complexity: O(1)
class Solution(object):
    def intersect(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[int]
        """
        nums1.sort()
        nums2.sort()
        ans = []
        low = 0
        high = len(nums2) - 1
        for i in nums1:
            bs_index = self.binary_search(nums2, i, low, high)
            if bs_index != -1:
                low = bs_index + 1
                ans.append(i)
        return ans
            
    def binary_search(self, arr, target, low, high):
        while low <= high:
            mid = low + (high-low)/2
            if arr[mid] == target:
                if mid == low or arr[mid-1] < arr[mid]:
                    return mid
                else:
                    high = mid - 1
            elif arr[mid] > target:
                high = mid - 1
            else:
                low = mid + 1
        return -1


                
            
            
            
          
          
  
            
