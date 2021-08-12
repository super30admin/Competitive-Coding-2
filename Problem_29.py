class Solution:

    def twoSum(self, nums , target) :     
        
       
        number_dictionary = dict()
        
        for index, number in enumerate(nums):
            
            
            number_dictionary[ number ] = index
            
       
        solution = list()
        
        for i in range( len(nums) ):
            
            value = nums[i]
            
           
            dual = target - value
            
            index_of_dual =  number_dictionary.get( dual, None)

            if index_of_dual is not None and index_of_dual != i:
               
                solution = list([i, index_of_dual])
                
                break

            else:
                
                continue
                

        return solution