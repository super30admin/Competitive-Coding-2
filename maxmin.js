Time complexity - O(N)
 Space complexity - O(1)

function getMinMax(arr){
     
    let n = arr.length
    let mx,mn,i
    if(n % 2 == 0){
        mx = Math.max(arr[0], arr[1])
        mn = Math.min(arr[0], arr[1])
         
        
        i = 2
    }
         
    
    else{
        mx = mn = arr[0]
        i = 1
    }
         
    while(i < n - 1){
        if(arr[i] < arr[i + 1]){
            mx = Math.max(mx, arr[i + 1])
            mn = Math.min(mn, arr[i])
        }
        else{
            mx = Math.max(mx, arr[i])
            mn = Math.min(mn, arr[i + 1])
        }
        i += 2
    }
     
    return [mx, mn]
}
     
let arr = [1000, 11, 445, 1, 330, 3000]
let mx = getMinMax(arr)[0]
let mn = getMinMax(arr)[1]
console.log("Minimum element is", mn)
console.log("Maximum element is", mx)