// Knapsack

const knapSack = (maxCapacity, valueList, weightList, size) => {
    let K = new Array(size + 1);

    for (let i = 0; i <= size; i++) {
        K[i] = new Array(maxCapacity + 1);
        for (let w = 0; w <= maxCapacity; w++) {
            // base
            if (i === 0 || w === 0) {
                K[i][w] = 0;
            }
            // if selected weight <= capacity weight
            else if (weightList[i-1] <= w) {
                // k[i][w] = Math.max(include, exclude)
                K[i][w] = Math.max(valueList[i-1] + K[i-1][w - weightList[i-1]] , K[i-1][w]);
            } 
            // if it exceeds
            else {
                K[i][w] = K[i-1][w];
            }
        }
    }
    return K[size][maxCapacity];
}

let valueList = [60, 100, 120];
let weightList = [10, 20, 30];
let maxCapacity = 50;
let size = valueList.length;
console.log(knapSack(maxCapacity, valueList, weightList, size));