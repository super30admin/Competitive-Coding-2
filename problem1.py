// Time Complexity : O(n) 
// Space Complexity : O(n) 
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

nums=[2,8,10,14,15]
target=12
dictionary=dict()

if len(nums)==0:
	print("Empty array")
flag=0
for i in range(len(nums)):
	dictionary[nums[i]]=i

for i in range(len(nums)):
	if target-nums[i] in dictionary:
		index=dictionary[target-nums[i]]
		if index!=i:
			flag=1
			print([i,index])
			break

if flag==0:
	print(-1)
