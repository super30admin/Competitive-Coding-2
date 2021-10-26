#Time complexity O(2^n) and space O(n)

p=[60,100,120]
w=[10,20,30]
mc=50

#Creating the helper function 
def helper(p,mc,mp,w,i):
    
    if i>=len(w) or mc == 0:
        return (mp)
    if w[i] > mc:
        return helper(p,mc,mp,w,i+1)
 #Conditions to whether we choose or not 
    choose = helper(p,mc-w[i],mp+p[i],w,i+1)
    notchoose= helper(p,mc,mp,w,i+1)

    return (max(choose,notchoose))
    

print(helper(p,mc,0,w,0))
