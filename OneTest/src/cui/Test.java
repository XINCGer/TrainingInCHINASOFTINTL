package cui;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int totol = 0;
		for (int i = 10; i <= 20; i++) {
			totol += factorial(i);
		}
		System.out.println(totol);
		System.out.println(factorial(5));

	}

	public static int factorial(int num) {
		int sum = 1;
		for (int i = 1; i <= num; i++) {
			sum *= i;
		}
		return sum;
	}

}
