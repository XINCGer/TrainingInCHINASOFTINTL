package fu;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Instrument instrument =new Piano();
		instrument.play();
		instrument=new Violin();
		instrument.play();

	}

}
