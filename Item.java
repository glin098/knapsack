public class Item implements IItem {
	private String id;
	private int value;
	private int weight;
	private double ratio;

    public Item(String id, int value, int weight) {
    	this.id = id;
    	this.value = value;
        this.weight = weight;
        this.ratio = (double)value / (double)weight;
    }
    
    @Override
	public String getId() {
    	return this.id;
    }
    
    @Override
	public int getValue() {
    	return this.value;
    }
    
    @Override
	public int getWeight() {
    	return this.weight;
    }
    
    @Override
	public double getRatio() {
    	return this.ratio;
    }
}
