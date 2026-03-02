#Given two arrays, val[] and wt[], where each element represents the value 
# and weight of an item respectively, and an integer W representing the maximum 
# capacity of the knapsack (the total weight it can hold).


def solution(val, wt, W):
    # create 2 arrays 1 for updating current max values, other for using previous rows max values
    #  initialize of length w with base case where if no weight then max value of achieve that wight
    maxValArrCurr = [0]*(W+1)
    maxValArrPrev = [0]*(W+1)
    for i in range(0,len(wt)):
        currentWt = wt[i]
        currentVal = val[i]
        for j in range(0,len(maxValArrCurr)):
            if j < currentWt:
                maxValArrCurr[j] = maxValArrPrev[j]
                continue
            #noChoose value coming from top
            noChoose = maxValArrPrev[j]
            #choose value coming from chosing the wt and then fetching the value 
            choose = currentVal
            if j - currentWt >=0:
                choose += maxValArrPrev[j - currentWt]    
            maxValArrCurr[j] = max(noChoose,choose)
        maxValArrPrev = list(maxValArrCurr)
    
    return maxValArrCurr[len(maxValArrCurr)-1]
print(solution([6,10,12], [1,2,3], 5 ))

