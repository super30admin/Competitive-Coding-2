# 0/1 Knapsack Problem using Dynamic Programming
def knapsack(values, weights, capacity):
    
    arr= [[0 for _ in range(capacity+1)] for _ in range(len(values)+1)]
    
    for r in range(1,len(values)+1):
        for c in range(1,capacity+1):
            if( c< weights[r-1] ):
                arr[r][c]= arr[r-1][c]
            else:
                arr[r][c]= max(values[r-1] + arr[r -1 ][c - weights[r-1]], arr[r-1][c] )
    if( arr[len(values)][capacity] !=0):
        return arr[len(values)][capacity]
    else:
        return 0
# Driver code with sample inputs and test cases
if __name__ == "__main__":
    # Test Case 1
    values1 = [60, 100, 120]
    weights1 = [10, 20, 30]
    capacity1 = 50
    print("Test Case 1")
    print(f"Maximum value for capacity {capacity1}: {knapsack(values1, weights1, capacity1)}")  # Output: 220

    # Test Case 2
    values2 = [20, 5, 10, 40, 15, 25]
    weights2 = [1, 2, 3, 8, 7, 4]
    capacity2 = 10
    print("\nTest Case 2")
    print(f"Maximum value for capacity {capacity2}: {knapsack(values2, weights2, capacity2)}")  # Output: 60

    # Test Case 3
    values3 = [10, 40, 30, 50]
    weights3 = [5, 4, 6, 3]
    capacity3 = 10
    print("\nTest Case 3")
    print(f"Maximum value for capacity {capacity3}: {knapsack(values3, weights3, capacity3)}")  # Output: 90
