public class TestProgramDynamic {

    public static void printKnapsack(IKnapsack k, IItem[] items) {
        System.out.println("Total weight " + k.getWeight() + ", value " + k.getValue() + "\n");

        for (int i = 0; i < items.length; i++)
        	if (k.getPercentage(i) == 1.0)
        		System.out.println("Item " + items[i].getId() + " weight " + items[i].getWeight() + " \t value " + items[i].getValue());

        System.out.println("");
    }

	public static void main(String[] args) {
		IKnapsackDynamic knapsack;
		IItem a, b, c, d, e, f;
		
		System.out.println("0-1 knapsack using dynamic programming \n");
		
		// knapsack with 6 items and weight 8
		
		a = new Item("A", 2, 1);
		b = new Item("B", 4, 2);
		c = new Item("C", 6, 4);
		d = new Item("D", 12, 5);
		e = new Item("E", 14, 7);
		f = new Item("F", 16, 8);
		
		IItem [] items1 = { a, b, c, d, e, f };

		knapsack = new KnapsackDynamic(8, items1);
				
		System.out.println(knapsack.toString("Tables"));
		printKnapsack(knapsack.getKnapsack(8), items1);

		// knapsack with 5 items and weight 8
		
		a = new Item("A", 20, 1);
		b = new Item("B", 28, 2);
		c = new Item("C", 5, 3);
		d = new Item("D", 33, 5);
		e = new Item("E", 12, 6);		
		
		IItem [] items2 = { a, b, c, d, e };

		knapsack = new KnapsackDynamic(8, items2);
		
		System.out.println(knapsack.toString("Tables"));
		printKnapsack(knapsack.getKnapsack(8), items2);
	}
}
