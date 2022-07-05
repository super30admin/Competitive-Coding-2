#Time Complexity = O(n^2)
#Space Complexity = O(n^2)
wts = [5,3,4,2]
val = [70, 60, 50, 10]
max_weight = 7
m = len(wts)
n = max_weight
tab = [[0 for i in range(n+1)]for j in range(m+1)]
for i in range(m+1):
    for j in range(n+1):
        if(i==0 or j==0):
            tab[i][j] = 0
        elif(j<wts[i-1]):
            tab[i][j] = tab[i-1][j]
        else:
            tab[i][j] = max(tab[i-1][j], val[i-1]+tab[i-1][j-wts[i-1]])
print(tab[i][j])