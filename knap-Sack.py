def knap_sack(w,p,capacity):
    #w=weight p=value Capacity=target
    #initializing dp matrix
    dp=[[0 for i in range(capacity+1)] for i in range(len(w))]
    #updating first row of dp matrix
    for i in range(0,w[0]):
        dp[0][i]=0
    for i in range(w[0],capacity+1):
        dp[0][i]=p[0]
    #updating remaing rows of Dp Matrix
    for i in range(1,len(w)):
        for j in range(1,capacity+1):
            if j<w[i]:
                dp[i][j]=dp[i-1][j]
            else:
                dp[i][j]=max(dp[i-1][j],p[i]+dp[i-1][j-w[i]])
    return(dp[len(w)-1][capacity])