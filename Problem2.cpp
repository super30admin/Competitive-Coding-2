//Time Complexity - O(n)
//Space Complexity - O(number of elements * max size limit)
//Did it run on leetcode - Link wasnt provided

int knapsack(vector<int>& w,vector<int>& v, int max_w)
{
	if(w.size()==0 || v.size()==0)
		return -1;
	int A[w.size()+1][max_w+1];
	for(int i=0;i<w.size()+1;i++)
		for(int j=0;j<max_w+1;j++)
		{
			if(i==0 || j==0)
				A[i][j]=0;
			if(w[i-1]>j)
				A[i][j]=A[i-1][j];
			else
				A[i][j]=max(A[i-1][j],V[i-1]+A[i-1][j-W[i-1]];
		}
	return A[w.size()+1][max_w+1];
}
		
	