"""
// Time Complexity :O(n) Iterating over an array once
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :NA
// Any problem you faced while coding this :NA

//Explanation:
//BF Solution:
Traverse through the entire array and check if the sum
arr[i]+arr[j]==target T=O(n2)

//Optimized solution using two pointers l and h
sum=array[l]+array[h]
if sum==target return
sum>target-> Update h
sum<target-> update l
"""
class Solution:
  def getTarget(self,a,t):
    result=[]
    l=0
    array=a
    target=t
    h=len(array)-1

    while(l<h):
      sum=array[l]+array[h]
      if sum==target:
        result.append(array[l])
        result.append(array[h])
        return result
      elif sum>target:
        h-=1
      else:
        l+=1
    return -1


if __name__=="__main__":
  s=Solution()
  array=[2, 7, 11, 15]
  target=26
  print(s.getTarget(array,target))

"""
#BF solution
array=[2, 7, 11, 15]
target=9
com=0
res=[]

for i in range(len(array)):
  for j in range(len(array)):
    if array[i]+array[j]==target:
      if array[i] not in res:
        res.append(array[i])
      if array[j] not in res:
        res.append(array[j])

print(res)

"""
