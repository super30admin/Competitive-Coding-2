# Time Complexity : O( (2 ^ n)) [n = number of weights]

# Space Complexity : O( (2 ^ n)) [n = number of weights]

# Did this code successfully run on Leetcode : N/A

def knapsackUtil(w, v, cap, index, curr_cap, curr_val):
    # Either all the weights are covered
    # or, the capacity of bag has been reached
    if index >=len(w) or curr_cap == 0: 
        return curr_val
    
    # if the capacity of the bag is less than the current weight, try the next weight
    if curr_cap - w[index] < 0:
        return knapsackUtil(w, v, cap, index+1, curr_cap, curr_val) 
    
    case_0 =  knapsackUtil(w, v, cap, index+1, curr_cap, curr_val) # Do not choose the current weight and move to next weight
    case_1 =  knapsackUtil(w, v, cap, index+1, curr_cap-w[index], curr_val+v[index]) # Choose the current weight and move to next weight
    return max(case_0, case_1)


def knapsack(w,v,cap):
    return knapsackUtil(w,v,cap, 0, cap, 0)


testcases = [[[1, 5, 2, 6], [20, 20, 30, 50], 8], [[20,10,10], [30,20,40], 10],
             [[1, 8, 12, 6], [40, 13, 45, 10], 20],
             [[48, 72, 30, 52, 80, 58, 92, 55, 85, 50, 35, 60, 82, 64, 88, 37, 99, 94, 91, 39, 42, 97, 45, 47, 69, 61, 57, 40, 41, 86, 77, 54, 98, 87, 63, 70, 76, 93, 67, 46, 43, 59, 73, 71, 62, 51, 33, 89, 38, 49], [166, 114, 159,154, 94, 191, 105, 64, 23, 42, 18, 129, 185, 133, 171, 134, 168, 16, 68, 11, 80, 150, 62, 47, 182, 142, 93, 112, 137, 33, 153, 11, 99, 180, 176, 49, 105, 152, 180, 124, 160, 29, 62, 197, 28, 45, 37, 119, 32, 147], 456]]
for i in testcases[0:3]:
    print(knapsack(*i))