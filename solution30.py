#Time Complexity:O(mn)
#SpaceComplexity:O(mn)
value=[60,100,120]
weight=[10,20,30]
W=50
result=[[0 for i in range(W+1)]]
for i in range(1,len(value)+1):
    prev=result[i-1]
    arr=[0]
    for j in range(1,W+1):
        if j<weight[i-1]:
            arr.append(prev[j])
        else:
            if(j%weight[i-1]==0):
                v=((j//weight[i-1])*value[i-1])
            else:
                v=((j//weight[i-1])*value[i-1])+arr[j-weight[i-1]]
            arr.append(v)
    result.append(arr)
print(arr[-1])