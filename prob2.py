#Time Complexity = O(n*m)
# Space Complexity = O(n*m)

def knapsack_01(capacity, values, weights):
    num_items = len(values)
    dp_table = [[0 for i in range(capacity + 1)] for i in range(num_items + 1)]

    for item in range(1, num_items + 1):
        for cap in range(1, capacity + 1):
            if weights[item - 1] <= cap:
                dp_table[item][cap] = max(
                    values[item - 1] + dp_table[item - 1][cap - weights[item - 1]],
                    dp_table[item - 1][cap]
                )
            else:
                dp_table[item][cap] = dp_table[item - 1][cap]

    return dp_table[num_items][capacity]
