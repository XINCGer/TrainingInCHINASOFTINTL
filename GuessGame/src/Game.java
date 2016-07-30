import java.util.Scanner;

public class Game {
	private Player player;
	private Enemy enemy;
	private int round;
	private int tied;

	public void init() {
		System.out.println("-----------------欢迎进入羊村游戏世界--------------------");
		System.out
				.println("\n\t\t******************\n\t\t   **游戏开始  **\n\t\t******************\n");
		System.out.println("出拳规则：1.石头2.剪子3.布");
		System.out.println("请选择你的角色(1.沸羊羊  2.暖羊羊  3.美羊羊)");
		Scanner s = new Scanner(System.in);
		int flag;
		flag = s.nextInt();
		player = new Player(flag);
		System.out.println("请选择对手角色(1.喜羊羊  2. 慢羊羊 3.懒羊羊)");
		flag = s.nextInt();
		enemy = new Enemy(flag);
	}

	public void start() {
		System.out.println("开始游戏吗？ (y/n)");
		Scanner s = new Scanner(System.in);
		while (s.next().equals("y")) {
			System.out.println("请出拳：1.石头2.剪子3.布");
			Scanner cin = new Scanner(System.in);
			int flag = cin.nextInt();
			player.setResult(flag);
			enemy.setResult();
			if (player.judge(enemy) == 2) {
				tied++;
			}
			round++;
			System.out.println("是否开始下一轮?  (y/n)");
		}
	}

	public void showPlane() {
		System.out
				.println("---------------------------------------------------");
		System.out.println("\t\t  " + player.name + "对决" + enemy.name);
		System.out.println("次数：" + round);
		System.out.println("平局：" + tied);
		System.out.println(player.name + "得分：" + player.getScore());
		System.out.println(enemy.name + "得分：" + enemy.getScore());
		if (player.getScore() > enemy.getScore()) {
			System.out.println("最终结果：赢了！");
		} else if (player.getScore() == enemy.getScore()) {
			System.out.println("最终结果：平局！");
		} else if (player.getScore() < enemy.getScore()) {
			System.out.println("最终结果：输了！");
		}
		System.out
				.println("---------------------------------------------------");
	}
}
