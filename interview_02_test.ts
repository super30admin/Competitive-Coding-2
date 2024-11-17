let find_max_profit = function (
  profits: number[],
  weights: number[],
  capacity: number
) {
  // Space Complexity = O(capacity x weights)
  let matrix: number[][] = createMatrix(weights.length + 1, capacity + 1);
  matrix[0].fill(0);

  // I = Weight
  for (let i = 1; i <= weights.length; i++) {
    let weight = weights[i - 1];
    let profit = profits[i - 1];
    // J = Capacity
    for (let j = 0; j <= capacity; j++) {
      // if Choose Case Available
      if (weight <= j) {
        let max_profit = Math.max(
          profit + matrix[i - 1][j - weight],
          matrix[i - 1][j]
        );
        matrix[i][j] = max_profit;
      } else {
        // Else set no choose case
        matrix[i][j] = matrix[i - 1][j];
      }
    }
  }

  return matrix[weights.length][capacity];
};

let find_max_profit_space_optimised = function (
  profits: number[],
  weights: number[],
  capacity: number
) {
  // Space Complexity = O(1)
  let array: number[] = new Array(capacity + 1).fill(0);

  // I = Weight
  for (let i = 1; i <= weights.length; i++) {
    let weight = weights[i - 1];
    let profit = profits[i - 1];
    // J = Capacity
    for (let j = 0; j <= capacity; j++) {
      // if Choose Case Available
      if (weight <= j) {
        let max_profit = Math.max(profit + array[j - weight], array[i - 1]);
        array[j] = max_profit;
      }
    }
  }

  return array[capacity];
};

function createMatrix(rows: number, columns: number): number[][] {
  return Array.from({ length: rows }, () => Array(columns));
}

describe("Find Max Profit", () => {
  it("Happy Path", () => {
    let capacity = 5;
    let weights = [1, 2, 3];
    let profits = [60, 100, 120];
    expect(find_max_profit(profits, weights, capacity)).toStrictEqual(220);
  });

  it("Space Optimised", () => {
    let capacity = 5;
    let weights = [1, 2, 3];
    let profits = [60, 100, 120];
    expect(
      find_max_profit_space_optimised(profits, weights, capacity)
    ).toStrictEqual(220);
  });
});
