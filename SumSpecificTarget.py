# Time complexity : O(n^2) where n is the size of the array
# Space Complexity : None not using the extra space

class SumSpecificTarget:
	def solution1(self, arr, targetSum):
		for i in range(len(arr)):
			for j in range(i, len(arr)):
				if arr[i] + arr[j] == targetSum:
					return [i, j]

if __name__ == '__main__':
	sst = SumSpecificTarget()
	print(sst.solution1([2, 7, 11, 15], 9))