#Time COmplexity: O(n)
#Space Complexity: O(n) Because there can be maximum n elements in all the lists combined in the hash values.
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        dic = {}
        ind = 0
        for num in nums:
            if num not in dic:
                dic[num] = [ind]
            else:
                dic[num].append(ind)
            ind += 1
        ind = 0
        ans = []
        for num in nums:
            if target-num in dic and target-num != num:
                ans.append(ind)
                ans.append(dic[target-num][0])
                break
            elif target-num == num and len(dic[target-num]) >=2:
                ans.append(dic[num][0])
                ans.append(dic[num][1])
                break
            ind += 1
        return ans
