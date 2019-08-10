class Knapsack:
	def solution1(self, weights, values, max_wt):
		# Time Complexity : O(mn) where m is the number of items and n is the value
		# Space Complexity : O(mn) where m is the number of items and n is the value
		dp_arr = [[0 for i in range(max_wt + 1)] for j in range(len(weights) + 1)]
		for i in range(1, len(dp_arr)):
			for j in range(1, len(dp_arr[0])):
				if j > weights[i - 1]:
					dp_arr[i][j] = max(values[i - 1] + dp_arr[i][j - weights[i - 1]], dp_arr[i - 1][j])
				else:
					dp_arr[i][j] = dp_arr[i - 1][j]
		return dp_arr[-1][-1]

	def solution2(self, weights, values, max_wt):
		# Time Complexity : O(mn) where m is the number of items and n is the value
		# Space Complexity : O(n) where n is the value
		# Here use a 1D array to do the same
		dp_arr = [0 for i in range(max_wt + 1)]
		for i in range(1, len(dp_arr)):
			for j in range(len(weights)):
				if i > weights[j]:
					dp_arr[i] = max(values[j] + dp_arr[i - weights[j]], dp_arr[i])
				print(dp_arr)
		return dp_arr[-1]

if __name__ == '__main__':
	sol = Knapsack()
	print(sol.solution1([1, 3, 4, 5], [12, 13, 14, 15], 18))
	print(sol.solution2([1, 3, 4, 5], [12, 13, 14, 15], 18))
	print(sol.solution1([10, 20, 30], [60, 100, 120], 50))
	print(sol.solution2([10, 20, 30], [60, 100, 120], 50))