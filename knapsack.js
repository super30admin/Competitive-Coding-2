// Time Complexity : exponential - O(n^2)
// Space Complexity : constant - O(1)
// Did this code successfully run on Leetcode : N/a
// Any problem you faced while coding this : No

const knapSack = (maxWeight, weightsArray, valueArray, index) => {
  if (!maxWeight || !index) {
    return 0;
  }

  if (weightsArray[index - 1] > maxWeight) {
    return knapSack(maxWeight, weightsArray, valueArray, index - 1);
  }

  const excludedItem = knapSack(maxWeight, weightsArray, valueArray, index - 1);
  const includedItem =
    valueArray[index - 1] +
    knapSack(
      maxWeight - weightsArray[index - 1],
      weightsArray,
      valueArray,
      index - 1
    );

  return Math.max(includedItem, excludedItem);
};

console.log(knapSack(50, [10, 20, 30], [60, 100, 120], 3));
