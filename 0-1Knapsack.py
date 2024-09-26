def  knapsackRec(value,weight,W):
    # sort value and weight
    import heapq
    hp = []
    for i in range(0,len(weight)):
        heapq.heappush(hp, (weight[i],value[i]))
    def knapsackRecursive(hp,W):
        # choose the weight or avoid the weight
        if(W==0):
            return 0
        if(W<0):
            return -1*float("inf")
        if(len(hp)==0):
            return 0
        w,v = heapq.heappop(hp)
        z = max(v + knapsackRecursive(hp.copy(),W-w), knapsackRecursive(hp.copy(),W))
        return z
    
    return knapsackRecursive(hp.copy(),W)


def knapsackDP(value,weight,W):
    # sort value and weight
    if(len(value)==0):
        return 0
    import heapq
    hp = []
    for i in range(0,len(weight)):
        heapq.heappush(hp, (weight[i],value[i]))
    hp1 = heapq.nsmallest(len(hp),hp)
    x = [[ 0 for i in range(0,len(hp))] for j in range(0,W+1)]
    
    for j in range(1,W+1):
        for i in range(0,len(hp1)):
            w,v = hp1[i]
            if(i==0):
                if(j-w>=0):
                    x[j][i] = v
            else:
                if(j-w>=0):
                    x[j][i] = max(x[j-w][i-1]+v, x[j][i-1])  
                else:
                    x[j][i] = x[j][i-1]
    
    return x[-1][-1]
    
print(knapsackRec([60,100,120],[10,20,30],50))
print(knapsackDP([60,100,120],[10,20,30],50))
print(knapsackRec([],[],50))
print(knapsackDP([],[],50))
print(knapsackRec([20],[20],50))
print(knapsackDP([20],[20],50))
