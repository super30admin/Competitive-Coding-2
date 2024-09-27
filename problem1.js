//Time: O(n^2), Space: O(1)
var generate = function(numRows) {
    let res = Array(numRows).fill().map(() => Array());
    for(let i=0;i<numRows;i++){
        for(let j=0;j<=i;j++){
            if(j==0 || j == i){
               res[i].push(1) 
            }else{
                res[i].push(res[i-1][j-1] + res[i-1][j])
            }
        }
    }
    return res
};