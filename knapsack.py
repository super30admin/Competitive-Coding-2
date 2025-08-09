# Knapsack problem implementation
def knapsack(weights, values, capacity, i, profit):
    # Base case: if no items left or capacity is 0
    if i >= len(weights) or capacity <= 0:
        return profit
    case1 = 0
    # Case 1: include the current item if it fits in the knapsack
    if weights[i] <= capacity:
        case1 = knapsack(weights, values, capacity - weights[i], i + 1, profit + values[i])
    # Case 2: exclude the current item
    case2 = knapsack(weights, values, capacity, i + 1, profit)
    # Return the maximum of both cases
    return max(case1, case2)

def main():
    profit = [60,100, 120]
    weights = [10, 20, 30]
    capacity = 20
    result = knapsack(weights, profit, capacity, 0, 0)
    print(f"Maximum profit: {result}")

if __name__ == "__main__":
    main()
