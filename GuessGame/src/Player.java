public class Player extends Hero {
	public Player(int flag) {
		switch (flag) {
		case 1:
			name = "������";
			break;
		case 2:
			name = "ů����";
			break;
		case 3:
			name = "������";
			break;
		default:
			break;
		}
	}

	public void setResult(int result) {
		if (result == 1) {
			System.out.println("���ȭ��ʯͷ");
		} else if (result == 2) {
			System.out.println("���ȭ������");
		} else if (result == 3) {
			System.out.println("���ȭ����");
		}
		this.result = result;
	}
}
