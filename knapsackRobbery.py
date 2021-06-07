def knapsack(arr1,arr2,maxWt):

    return helper(arr1,arr2,0,0,0,maxWt)


def helper(val,wt,index,sum,count,maxWt):
    #base condition
    if index == len(val) or maxWt < count + wt[index]:
        print("here")
        return sum
    #Choose
    choose = helper(val,wt,index+1,sum+val[index],count+wt[index],maxWt)
    #NotChoose
    notChoose = helper(val,wt,index+1,sum,count,maxWt)
    return max(choose,notChoose)


max1 = knapsack([60,100,120],[3,5,7],10)

print(max1)