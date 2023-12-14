public class Knapsack implements IKnapsack {
	private int weight;
	private int value;
	private double [] percentage;
	
	public Knapsack(int items) {
		this.weight = 0;
		this.value = 0;
		this.percentage = new double[items];
	}
	
	@Override
	public int getWeight() {
		return this.weight;
	}
	
	@Override
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	@Override
	public int getValue() {
		return this.value;
	}
	
	@Override
	public void setValue(int value) {
		this.value = value;
	}
	
	@Override
	public double getPercentage(int i) {
		return this.percentage[i];
	}
	
	@Override
	public void setPercentage(int i, double percentage) {
		this.percentage[i] = percentage;
	}
}
