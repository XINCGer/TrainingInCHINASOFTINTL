package fu;

public abstract class Instrument {
	
	String name;
	float weight;
	String brand;
	float price;

	public Instrument() {
		
	}
	abstract void play();
}
