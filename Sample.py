########1. Two Sum#################################################################################################################
// Time Complexity : n
// Space Complexity : n
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : though to do with 2 pointer but hasp was more efficient

// Your code here along with comments explaining your approach in three sentences only
Took hash map and than found diff of elements and stored in hashmap if found the match than return result


class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        dict1={}
        l1=[]
        for i,val in enumerate(nums):
            chk=target-val
            if chk in dict1:
                l1.append(i)
                l1.append(dict1[chk])
                return l1
            else:
                dict1[val]=i
        return -1

        

        

########https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/###################################################################################################################


// Time Complexity : recursion - 2^number of weight, tabular - number of weightXcapacity
// Space Complexity : recursion - not idea, tabular - number of weightXcapacity
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : first did recursion than worked tabular way, tabular was having bit problem but saw previous video and got idea

// Your code here along with comments explaining your approach in three sentences only
In recursion I kept select/not select each weight and for tabular build tabular data as per class


############Recursion
class Solution:
    def maximumProfit(self, profit: List[int], weight: List[int], capacity: int) -> int:
        return self.bruteforce(profit,weight,capacity,0)


    def bruteforce(self,profit,weight,capacity,idxw):
        #base.
        if capacity==0:
            return 0
        elif idxw==len(weight) and capacity>0:
            return 0
        elif capacity<0:
            return (-1)*profit[idxw-1]
        

        #select
        print('case1: ',weight,capacity-weight[idxw],idxw+1)
        case1=profit[idxw] + self.bruteforce(profit,weight,capacity-weight[idxw],idxw+1)
        print('case1: ',case1)
        #no select
        print('case2: ',weight,capacity,idxw+1)
        case2=0 + self.bruteforce(profit,weight,capacity,idxw+1)
        print('case2: ',case2)
        return max(case1,case2)




############Tabular
class Solution:
    def maximumProfit(self, profit: List[int], weight: List[int], capacity: int) -> int:
        mat=[[0 for i in range(capacity+1)] for j in range(len(weight)+1)]
        print(mat)
        for i in range(1,len(weight)+1):
            for j in range(capacity+1):
                #print(i,j,weight[i-1])
                if j<weight[i-1]:
                    mat[i][j]=mat[i-1][j]
                else:
                    mat[i][j]=max(mat[i-1][j],mat[i-1][j-weight[i-1]]+profit[i-1])
        for i in mat:
            print(i)
        return mat[len(weight)][capacity]

        

        
