int* func_returnindices(int nums[],int size,int target,int result[])
{
    int i,j;
    //Edge case
    if(size==0||size==1||nums==NULL)
    {
        return 0;
    }
    else 
        for(i=0,j=size-1;i<size;++i)
        {
            for(j=size-1;j>0;)
            {
                if(target==(nums[i]+nums[j]))
                {
                    result[0]=i;
                    result[1]=j;
                }
                else 
                    j--;
            }
        }
    
    return result;
}



int main()
{
    int nums[]={11,7,15,2};
    int result[2];
    int size=*(&nums+1)-nums;
    int target=9;
    int* indexofresult;
    indexofresult=func_returnindices(nums,size,target,result);
    cout<<result[0]<<result[1];
}
