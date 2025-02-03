# https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/


def rec(sack_weight,value,idx,m,w,v):
    if (idx >= m): 
        return 0
    if (sack_weight <= 0):
        return 0
    if(memo[idx][sack_weight] != -1):
        return memo[idx][sack_weight]

    case1 = 0
    if(sack_weight >= w[idx]):
        case1 = v[idx]+ rec(sack_weight - w[idx],idx+1,m,w,v)
    case2 = rec(sack_weight,  idx+1,m,w,v)
    memo[idx][sack_weight] = max(case1, case2)
    return memo[idx][sack_weight]

if __name__ == "__main__":
    w = [10,20,30]
    v = [60,100,120]
    sack_weight = 50
    m = len(w)
    memo = [[-1] * (sack_weight+1) for _ in range(m+1)]
    #value = 0    
    
    print(rec(sack_weight, 0,m,w,v))