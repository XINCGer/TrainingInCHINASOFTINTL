public class Enemy extends Hero {
	public Enemy(int flag) {
		emitter = new RandomGenertor();
		switch (flag) {
		case 1:
			name = "Ï²ÑòÑò";
			break;
		case 2:
			name = "ÂıÑòÑò";
			break;
		case 3:
			name = "ÀÁÑòÑò";
			break;
		default:
			break;
		}
	}

	public void setResult() {
		this.result = emitter.getRandom();
		if (result == 1) {
			System.out.println(name + "³öÈ­£ºÊ¯Í·");
		} else if (result == 2) {
			System.out.println(name + "³öÈ­£º¼ô×Ó");
		} else if (result == 3) {
			System.out.println(name + "³öÈ­£º²¼");
		}
	}
}
