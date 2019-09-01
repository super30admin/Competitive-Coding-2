
/* Problem Statement: 
Cannot Verify on leetcode. Problem cannot be found on leetcode

Given weights and values of n items, put these items in a knapsack of capacity W 
to get the maximum total value in the knapsack. In other words, given two integer 
arrays val[0..n-1] and wt[0..n-1] which represent values and weights associated with 
n items respectively. Also given an integer W which represents knapsack capacity,
 find out the maximum value subset of val[] such that sum of the weights of this
  subset is smaller than or equal to W. You cannot break an item, either pick the
   complete item, or don’t pick it (0-1 property).

 *
 * Time Complexity : O(n*m) where n is number of weights, m is the capacity of the knapsack 
 * Space Complexity : O(n*m)
 */

#include<stdio.h>
#include<stdlib.h>
#include<stdbool.h>

/* Macro for calculating max value among 2 numbers */
#ifndef max
    #define max(a,b) ((a) > (b) ? (a) : (b))
#endif

/* Macro for calculating min value among 2 numbers */
#ifndef min
    #define min(a,b) ((a) > (b) ? (b) : (a))
#endif

/* This function performs the 0/1 knapsack problem calculations for the given input
 *
 * Example : 
 * Weights: 1 3 4 5
   Values: 1 4 5 7
   W  --------Capacity ->>>>-------
 | 1 :  0  1  1  1  1  1  1  1
 | 3 :  0  1  1  4  5  5  5  5
 | 4 :  0  1  1  4  5  6  6  9
 | 5 :  0  1  1  4  5  7  8  9
 Max value possible for capacity : 7 is 9
 *
 * 1. Allocate 2D array considering the rows as weights, and columns as capacity
*. 2. for each capacity keep calculating the max sum of values which can be achieved
 * 3. If we are at 2nd row, that means we can consider weights with 1 and 3 denominations.
 */
int solve_0_1_knapsack_problem(int *weights, int *values, int capacity, int len_of_weight_arr){
    int idx1 = 0, idx2 = 0;
    int **value_arr = NULL;
    int max_val = 0;

    if (!weights || !values) {
        printf("Input weights or values are NULL \n");
        return -1;
    }
    value_arr = (int **)malloc(sizeof(int *) * len_of_weight_arr);

    printf ("  W  --------Capacity ->>>>-------\n");
    for (idx1 = 0; idx1 < len_of_weight_arr; idx1++) {

        printf ("| %d : ",weights[idx1]);
        value_arr[idx1] = (int *)calloc(capacity + 1, sizeof(int));

        if (!value_arr[idx1]) {
            printf("Failed allocating memory for idx: %d\n",idx1);
            break;
        }
        for (idx2 = 0; idx2 <= capacity; idx2++) {
            /* If capacity is more than equal to weight then fill it with that value. it may get overwritten again*/
            if (idx2 >= weights[idx1]) {
                value_arr[idx1][idx2] = values[idx1];
            } else {
                value_arr[idx1][idx2] = 0;
            }
            /* For index > 1, we can see the capacity values in the previous index */
            if (idx1 > 0) {
                /* If weight is more than capacity, just take the value in the previous index for same capacity */
                /* If weight is less than or equal to capacity, then perform calculation  */
                /* For more info see the function description */
                if (weights[idx1] > idx2) {
                    value_arr[idx1][idx2] = value_arr[idx1 - 1][idx2];
                } else {
                    value_arr[idx1][idx2] = max((values[idx1] + value_arr[idx1 - 1][idx2 - weights[idx1]]), value_arr[idx1 - 1][idx2]);
                }
            }
            printf(" %d ", value_arr[idx1][idx2]);
        }
        printf("\n");
    }
    max_val = value_arr[idx1 - 1][idx2 - 1];
    for (idx1 = 0; idx1 < len_of_weight_arr; idx1++) {
        free(value_arr[idx1]);
    }
    free(value_arr);
    return max_val;
}

int main(int argc, char *argv[]) {
/*
    int weights[4] = {1,3,4,5};
    int values[4] = {1,4,5,7};
    int capacity = 7;
*/
    int weights[3] = {10,20,30};
    int values[3] = {60, 100, 120};
    int capacity = 50;

    /* Execute the dynamic programming solution for best result */
    printf("Max value possible for capacity : %d is %d\n", capacity, solve_0_1_knapsack_problem(weights, values, capacity, sizeof(weights)/sizeof(weights[0])));

    return 0;
}

/* Test Cases
./a.out
  W  --------Capacity ->>>>-------
| 10 :  0  0  0  0  0  0  0  0  0  0  60  60  60  60  60  60  60  60  60  60  60  60  60  60  60  60  60  60  60  60  60  60  60  60  60  60  60  60  60  60  60  60  60  60  60  60  60  60  60  60  60
| 20 :  0  0  0  0  0  0  0  0  0  0  60  60  60  60  60  60  60  60  60  60  100  100  100  100  100  100  100  100  100  100  160  160  160  160  160  160  160  160  160  160  160  160  160  160  160  160  160  160  160  160  160
| 30 :  0  0  0  0  0  0  0  0  0  0  60  60  60  60  60  60  60  60  60  60  100  100  100  100  100  100  100  100  100  100  160  160  160  160  160  160  160  160  160  160  180  180  180  180  180  180  180  180  180  180  220
Max value possible for capacity : 50 is 220


*/
