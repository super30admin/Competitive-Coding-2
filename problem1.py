

def solution(weights,values,weight,idx):
    if idx >= len(weights):
        return 0
    case1 = solution(weights,values,weight,idx+1)
    
    if weight - weights[idx] >= 0:
        case2 = values[idx]+ solution(weights,values,weight-weights[idx],idx+1)
    else:
        case2 = float('-inf')
    return max(case1,case2)

print(solution([10, 20, 30],[60, 100, 120],50,0))
    