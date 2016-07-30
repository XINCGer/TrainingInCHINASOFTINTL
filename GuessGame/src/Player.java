public class Player extends Hero {
	public Player(int flag) {
		switch (flag) {
		case 1:
			name = "沸羊羊";
			break;
		case 2:
			name = "暖羊羊";
			break;
		case 3:
			name = "美羊羊";
			break;
		default:
			break;
		}
	}

	public void setResult(int result) {
		if (result == 1) {
			System.out.println("你出拳：石头");
		} else if (result == 2) {
			System.out.println("你出拳：剪子");
		} else if (result == 3) {
			System.out.println("你出拳：布");
		}
		this.result = result;
	}
}
