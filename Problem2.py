def maxValue(weights, values, limit):

  matrix = [[0]*(limit+1) for _ in range(len(weights)+1)]
  for i in range(1, (len(weights)+1)):
    for j in range(1, (limit+1)):
      if j < weights[i-1]:
        matrix[i][j] = matrix[i-1][j]
      else:
        matrix[i][j] = max(values[i-1] + matrix[i-1][j-weights[i-1]], matrix[i-1][j])
  
  return matrix[len(matrix)-1][limit]

w = [1,2,3]
v = [2,1,10]
l = 5 #expected result is 12 by using weights 3 and 1
print(maxValue(w,v,l))

w1 = [10, 20, 30]
v1 = [60, 100, 120]
l1 = 50 #expected result is 220 by using weights 20 and 30
print(maxValue(w1,v1,l1))

#Time complexity is O(m*n) where n is length of the weights array and m is the max weight limit value
#Space complexity is also O(m*n) for the above reason.
#Aprroach used is DP matrix approach