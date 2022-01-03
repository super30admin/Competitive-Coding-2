# Time complexity: 2 ^ len(weights) + len(profits)
# Space complexity: O(len(weights) + len(profits))

def knapsack(profits, weights, capacity):
    return knap_helper(profits, capacity, weights, 0, 0)

def knap_helper(profits, capacity, weights, index, maxprofit):
    if capacity <= 0 or index >= len(weights):
        return maxprofit


    if weights[index] > capacity:
        return knap_helper(profits, capacity, weights, index + 1, maxprofit)

    # not choose case
    case1 = knap_helper(profits, capacity, weights, index + 1, maxprofit)

    # choose case
    case2 = knap_helper(profits, capacity-weights[index], weights, index + 1, maxprofit + profits[index])

    return max(case1, case2)



profits =[5,10,15,20]
weights = [1,2,3,4]
ans =0
final = knapsack(profits, weights, 5)
print(final)