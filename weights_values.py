from typing import List


def find_max(weights: List[int], values: List[int], max_weight: int) -> int:
    no_of_weights = len(weights)
    sol = [0] * (max_weight + 1)  # 0th Row
    for i in range(no_of_weights):
        temp_row = []
        for j in range(max_weight + 1):
            if weights[i] > j:  # Weight greater than  max_weight
                temp_row.insert(j, sol[j])  # Just bring the above value down, as we cannot select the value
            else:
                temp_row.insert(j, max(sol[j], values[i] + sol[j - weights[i - 1]]))
        sol = temp_row
        del temp_row
    return sol[max_weight - 1]


if __name__ == '__main__':
    weights_ = [1, 2, 5]
    values_ = [10, 15, 40]
    max_weight_ = 6
    print(find_max(weights_, values_, max_weight_))
