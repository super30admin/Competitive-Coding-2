//0-1 Knapsack Problem using Recursion

public class KnapsackRecursion {
    int[] prices;
    int[] weights;
    int capacity;

    public int maxPrice(int price, int weight, int index) {
        int choose;
        int dontCh;
        if (index >= weights.length || weight >= capacity)
            return price;
        if (weights[index] + weight <= capacity)
            choose = maxPrice(price + prices[index], weight + weights[index], index + 1);
        else
            choose = maxPrice(price, weight, index + 1);
        dontCh = maxPrice(price, weight, index + 1);
        return Math.max(choose, dontCh);
    }

    public static void main(String[] args) {
        KnapsackRecursion obj = new KnapsackRecursion();
        obj.prices = new int[] { 60, 100, 120, 300 };
        obj.weights = new int[] { 1, 2, 3, 2 };
        obj.capacity = 5;
        System.out.println(obj.maxPrice(0, 0, 0));
    }
}