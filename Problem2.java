
class wt {
    public int method(int w,int weight[],int v[]){
        int i =0;
        int value = 0;
        return method(weight,i,w,value,v);}
        private int method(int[] weight, int i, int w, int value,int v[]){

    if(w==0){
        return value;
    }
            if(w<0){
                return -1;
            }
    if(i> weight.length-1){
        return value;
    }
    int select = method(weight,i+1,w-weight[i],value+v[i],v);
    int  notselect = method(weight,i+1,w,value,v);
            return Math.max(select,notselect);}

    public static void main(String[] arg)
    {
        int weight[] = {10,20,30};
        int v[] = {60,100,120};
    wt obj = new wt();

        System.out.println( obj.method(50,weight,v));

    }}

//tc=O(2^n)
//sc=O(1)
