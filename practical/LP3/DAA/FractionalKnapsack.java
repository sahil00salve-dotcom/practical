import java.util.*;

class Item {
    int weight;
    int profit;
    double ratio;

    Item(int weight, int profit) {
        this.weight = weight;
        this.profit = profit;
        this.ratio = (double) profit / weight;
    }
}

public class FractionalKnapsack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of items: ");
        int n = sc.nextInt();
        Item[] items = new Item[n];
        System.out.println("Enter weight and profit of each item:");

        for (int i = 0; i < n; i++) {
            int weight = sc.nextInt();
            int profit = sc.nextInt();

            items[i] = new Item(weight, profit);
        }
        System.out.print("Enter knapsack capacity: ");
        int capacity = sc.nextInt();

        // Sort items by profit/weight ratio in descending order
        Arrays.sort(items, (a, b) -> Double.compare(b.ratio, a.ratio));

        double totalProfit = 0;

        for (int i = 0; i < n; i++) {
            if (capacity == 0)
                break;
            if (items[i].weight <= capacity) {
                // Take complete item
                capacity -= items[i].weight;
                totalProfit += items[i].profit;
            } else {
                // Take fractional part
                totalProfit += items[i].ratio * capacity;
                capacity = 0;
            }
        }
        System.out.println("Maximum Profit = " + totalProfit);
        sc.close();
    }
}

// Sample Input
// Enter number of items: 3

// Enter weight and profit of each item:
// 10 60
// 20 100
// 30 120

// Enter knapsack capacity: 50
