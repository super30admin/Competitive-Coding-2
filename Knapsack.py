# Geeks for geeks URL: https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/
# Modification - Returning the max weight instead of value
# Problem : Maximize values under target weight
# Time Complexity : O(nm) where n - size of the values or weights and m is the target
# Space Complexity : O (nm)
def bottom_up_maximize_wt(self,v_w_dict,target):
	bottom_up = dict()
	bottom_up[0] = [0]*(target+1)
	val = 1
	for i in range(0,len(v_w_dict.keys())):
		bottom_up[val] = [0]*(target+1)
		for j in range(1,target+1):
			index = 0
			if j-list(v_w_dict.keys())[i]<0:
				index = 0
			else:
				index=v_w_dict[list(v_w_dict.keys())[i]]+bottom_up[val-1][j-list(v_w_dict.keys())[i]]
			bottom_up[val][j] = max(index,bottom_up[val-1][j])
		val = val+1
	return bottom_up[len(v_w_dict.keys())][-1]