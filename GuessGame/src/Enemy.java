public class Enemy extends Hero {
	public Enemy(int flag) {
		emitter = new RandomGenertor();
		switch (flag) {
		case 1:
			name = "ϲ����";
			break;
		case 2:
			name = "������";
			break;
		case 3:
			name = "������";
			break;
		default:
			break;
		}
	}

	public void setResult() {
		this.result = emitter.getRandom();
		if (result == 1) {
			System.out.println(name + "��ȭ��ʯͷ");
		} else if (result == 2) {
			System.out.println(name + "��ȭ������");
		} else if (result == 3) {
			System.out.println(name + "��ȭ����");
		}
	}
}
