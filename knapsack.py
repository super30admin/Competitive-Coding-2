# weight=[2,3,5]
# value=[1,2,6]
# capacity=8
value=[60,100,120]
weight=[10,20,30]
capacity=50
li=[]
li.append([0])
for i in range(capacity):
    li[0].append(0)
for i in range(1,len(weight)+1):
    li.append([])
    for j in range(capacity+1):
        
        if(j<weight[i-1]):
            # print(j)
            li[i].append(li[i-1][j])
        else:
            li[i].append(max(li[i-1][j],li[i-1][j-weight[i-1]]+value[i-1]))
   
print(li[len(weight)][capacity])
# print(li)
        