def find_max(a1,a2,index,ans,capacity):
    #print (ans)
    if(index >= len(a1) or capacity ==0):
        return ans
    if(a2[index]>capacity):
        return find_max(a1,a2,index+1,ans,capacity)
       
    #Dont consider the value
    case0 = find_max(a1,a2,index+1,ans,capacity)
    #Consider the value
    case1 = find_max(a1,a2,index+1,ans+a1[index],capacity-a2[index])
    
    return max(case0,case1)
    


a1 =[6,10,20]
a2 = [5,2,1]
ans =0
final = find_max(a1,a2,0,ans,5)
print(final)
