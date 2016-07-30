import java.util.Scanner;

public class Game {
	private Player player;
	private Enemy enemy;
	private int round;
	private int tied;

	public void init() {
		System.out.println("-----------------��ӭ���������Ϸ����--------------------");
		System.out
				.println("\n\t\t******************\n\t\t   **��Ϸ��ʼ  **\n\t\t******************\n");
		System.out.println("��ȭ����1.ʯͷ2.����3.��");
		System.out.println("��ѡ����Ľ�ɫ(1.������  2.ů����  3.������)");
		Scanner s = new Scanner(System.in);
		int flag;
		flag = s.nextInt();
		player = new Player(flag);
		System.out.println("��ѡ����ֽ�ɫ(1.ϲ����  2. ������ 3.������)");
		flag = s.nextInt();
		enemy = new Enemy(flag);
	}

	public void start() {
		System.out.println("��ʼ��Ϸ�� (y/n)");
		Scanner s = new Scanner(System.in);
		while (s.next().equals("y")) {
			System.out.println("���ȭ��1.ʯͷ2.����3.��");
			Scanner cin = new Scanner(System.in);
			int flag = cin.nextInt();
			player.setResult(flag);
			enemy.setResult();
			if (player.judge(enemy) == 2) {
				tied++;
			}
			round++;
			System.out.println("�Ƿ�ʼ��һ��?  (y/n)");
		}
	}

	public void showPlane() {
		System.out
				.println("---------------------------------------------------");
		System.out.println("\t\t  " + player.name + "�Ծ�" + enemy.name);
		System.out.println("������" + round);
		System.out.println("ƽ�֣�" + tied);
		System.out.println(player.name + "�÷֣�" + player.getScore());
		System.out.println(enemy.name + "�÷֣�" + enemy.getScore());
		if (player.getScore() > enemy.getScore()) {
			System.out.println("���ս����Ӯ�ˣ�");
		} else if (player.getScore() == enemy.getScore()) {
			System.out.println("���ս����ƽ�֣�");
		} else if (player.getScore() < enemy.getScore()) {
			System.out.println("���ս�������ˣ�");
		}
		System.out
				.println("---------------------------------------------------");
	}
}
