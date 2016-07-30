import java.util.Random;

public class RandomGenertor {
	private Random rand;

	public RandomGenertor() {
		rand = new Random();
	}

	public int getRandom() {
		return rand.nextInt(2) + 1;
	}
}
