/* Problem Statement:
WORKS ON LEETCODE
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the sameelement twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,



Because nums[0] + nums[1] = 2 + 7 = 9,

return [0, 1].

 *
 * Time Complexity : O(n)
 * Space Complexity : O(k) where k is size of hash table
 */

/* PART 1 : Helper functions to implement a C hash table with
 *  collision handling in form of linked list
 *
 */

#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<stdbool.h>

#define HT_SIZE 50000 //hash_array table

struct hash_array
{
    int key;
    int value;
    bool valid;
    struct hash_array* next;
}hash_array[HT_SIZE];

/* Add entry in hash table. If entry exists, set it to that value
 *
 */

void add_entry_hash_table(int num, int value)
{
    int temp = abs(num % HT_SIZE);

    if(hash_array[temp].key==0) {
        hash_array[temp].key= num;
        hash_array[temp].value = value;

    }else if(hash_array[temp].key==num) {
        hash_array[temp].value = value;
    }else {

        struct hash_array *p = &hash_array[temp];

        while(p->key!=num&&p->next!=NULL) {
                p=p->next;
        }

        if(p->key==num){
                p->value = value;
        }
        else
        {
            p->next=(struct hash_array*)malloc(sizeof(struct hash_array));
            p = p->next;
            p->key = num;
            p->value = value;
            p->next = NULL;
        }
    }
    hash_array[temp].valid = true;
}

/* Check if entry is present in hash table for the key. If yes, then return the
 * value stored for that hash table in value and return 0 or 1 based on success/failure */
int is_present_hash_table(int num, int *value)
{

    int temp = abs(num % HT_SIZE);

    if (hash_array[temp].valid == false) {
        return 0;
    }
    if(hash_array[temp].key==num)
    {
        *value = hash_array[temp].value;
        return 1;
    }else
    {
        struct hash_array *p=&hash_array[temp];
        while((p->key != num) && (p->next != NULL)) {
                p = p->next;
        }
        if(p->key==num) {
                *value = p->value;
            return 1;
        }
        else
        {
            return 0;
        }
    }
    return 0;
}


void free_hash_table() {
    int idx = 0;

    struct hash_array *p = NULL;
    struct hash_array *temp_ptr = NULL;

    for (idx = 0; idx < HT_SIZE; idx++) {
        p = &hash_array[idx];
        p = p->next;
        while (p != NULL) {
            temp_ptr = p;
            p = p->next;
            free(temp_ptr);
        }
    }
}

/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* twoSum(int* nums, int numsSize, int target, int* returnSize){
    int *final_arr = NULL;
    int idx = 0;
    int hash_val = 0;
    
    /* Prepare global HT for inputs */
    memset(hash_array, 0, sizeof(struct hash_array) * HT_SIZE);
    /* Validations for input */
    if (!nums) {
        printf("Number array is NULL\n");
        return NULL;
    }
    
    if (!returnSize) {
        printf("Return size for final array not specified \n");
        return NULL;
    }
    /* Final array allocation for result */
    *returnSize = 2;
    final_arr = (int *)calloc(*returnSize, sizeof(int));
    
    if (!final_arr) {
        printf("Memory allocation failed for final arr\n");
        return NULL;
    }  
    /* Iterate over the inputs and then do the following
     *
     * 1. If number at the specific index is already in HT, that means its the second number which we are looking for.
          based on the input added to the hash table earlier.
           for eg : target : 9 ,,, ,  input array : 2 7 10 11
            ht[target - number[0]] = 0;
            ht[7] = ht[target] = 0 already present, hence answer will be 0,1
     */
    for (idx = 0; idx < numsSize; idx++) {
        
        if (is_present_hash_table(nums[idx], &hash_val)) {
            final_arr[0] = hash_val;
            final_arr[1] = idx;
            break;
        }
        if (!is_present_hash_table(target - nums[idx], &hash_val)) {
            add_entry_hash_table(target - nums[idx], idx);
        }
    }
    free_hash_table();
    return final_arr;
}


int main(int argc, char *argv[]) {
    int *num_p = NULL;
    int *final_arr = NULL;
    int returnSize = 0;
    int idx = 0;
    if (argc < 2) {
        printf("Usage: ./a.out <target> <num1> ... <num n>\n");
        exit(1);
    }
    printf("Target: %d \n", atoi(argv[1]));

    num_p = (int *)malloc((argc - 2)*sizeof(int));
    if (num_p == NULL) {
        printf("Memory allocation failed \n");
        return -1;
    }

    /* Dont want to change the function, so copying the input to int array */
    for (idx = 2; idx < argc; idx++) {
        num_p[idx - 2] = atoi(argv[idx]);
    }

    final_arr = twoSum(num_p, argc - 2, atoi(argv[1]), &returnSize);
    printf("Final indexes : ");
    for (idx = 0; idx < returnSize; idx++) {
        printf(" %d ", final_arr[idx]);

    }
    printf("\n");

    free(num_p);
    free(final_arr);
    return 0;
}
