public class KnapsackDynamic implements IKnapsackDynamic {
	private int weight;
	private IItem [] items;
	private int [][] T;
	private boolean [][] S;
	
	/* 
	 * Recursive function for the knapsack problem using dynamic programming
	 * 
	 *             | 0                                                            if j = 0                  case (a)
	 *  T[i][j] =  | items[0].value                                               if (items[0].weight <= j) case (b)
	 *             | T[i-1][j]                                                    if items[i].weight > j    case (c)
	 *             | max(T[i-1][j], T[i-1][j - items[i].weight] + items[i].value) otherwise                 case (d)
	 * 
	 */

	public KnapsackDynamic(int weight, IItem [] items) {
		this.weight = weight;
		this.items = items.clone();
		this.T = new int[this.items.length][this.weight + 1];
		this.S = new boolean[this.items.length][this.weight + 1];
		
	    // case (a): column 0 of table T takes the value 0

	    for (int i=0; i<this.items.length; i++) {
	    	this.T[i][0] = 0;
	    }

	    // case (b): row 0 of table T takes the value of item 0 if its weight is smaller or equal than j
	    //           row 0 of table S takes the value true if the weight of item 0 is smaller or equal than j
		
        for (int j=1; j<=this.weight; j++) {
            this.T[0][j] = (this.items[0].getWeight() <= j) ? this.items[0].getValue() : 0;
            this.S[0][j] = (this.items[0].getWeight() <= j) ? true : false;
        }
        
        // case (c): T[i-1][j]
        // case (d): max(T[i-1][j], T[i-1][j - items[i].weight] + items[i].value)
        
        for (int i=1; i<this.items.length; i++) {
        	for (int j=1; j<=this.weight; j++) {
        		if (j < this.items[i].getWeight()) {
        			
        			// case (c): T[i-1][j]
        			
                    this.T[i][j] = this.T[i - 1][j];
                    this.S[i][j] = false;
        			
        		} else {
        			
        			// case (d): max(T[i-1][j], T[i-1][j - items[i].weight] + items[i].value)
        			
                    this.T[i][j] = max(this.T[i - 1][j], this.T[i - 1][j - this.items[i].getWeight()] + this.items[i].getValue());
                    this.S[i][j] = (this.T[i][j] == this.T[i - 1][j]) ? false : true;                     
        			
        		}
        	}
        }
	}	
	
	@Override
	public IKnapsack getKnapsack(int weight) {
		IKnapsack k = new Knapsack(this.items.length);

		int item = this.items.length - 1;

		while ((k.getValue() < this.T[this.items.length - 1][this.weight])) { 
			if (!this.S[item][weight] || k.getPercentage(item) == 1.0)
				item--;
			else {
				k.setWeight( k.getWeight() + this.items[item].getWeight() );
				k.setValue( k.getValue() + this.items[item].getValue() );
				k.setPercentage(item, 1.0);
				
				weight = weight - this.items[item].getWeight();
			}	
		}
		
		return k;
	}
	
    private static int max(int a, int b) {
        return (b > a) ? b : a;
    }
    
    @Override
	public String toString(String title) {    	
    	String s = title + "\n\nTable T \n";
    	
        for (int i=0; i < this.T.length; i++) {
            s = s + "\n[" + ((i < 10) ? " " + i : "" + i) + "]";

            for (int j = 0; j < this.T[0].length; j++)
                if (this.T[i][j] == 0)
                    s = s + "   0 ";
                else
                    if (this.T[i][j] < 10)
                    s = s + "   " + T[i][j] + " ";
                else
                	if (this.T[i][j] < 100)
                		s = s + "  " + T[i][j] + " ";
                	else
                		s = s + " " + T[i][j] + " ";
        }

        s = s + "\n\nTable S \n";
    	
        for (int i=0; i < this.S.length; i++) {
            s = s + "\n[" + ((i < 10) ? " " + i : "" + i) + "]";
            
            for (int j = 0; j < this.S[0].length; j++)
            	s = s + ((this.S[i][j]) ? " 1 " : " 0 ");
        }

        return s + "\n";
    }
}
