public class Hero {
	protected String name;
	private int score;
	protected int result;
	protected RandomGenertor emitter;

	public int getResult() {
		return this.result;
	}

	/**
	 * 1:win,2:ping,-1:lose
	 * 
	 * @param enemy
	 */
	public int judge(Hero enemy) {
		switch (result) {
		case 1:
			if (enemy.getResult() == 1) {
				System.out.println("结果：运气一般，平局！");
				return 2;
			} else if (enemy.getResult() == 2) {
				System.out.println("结果：运气真好，你赢了！");
				addScore();
				return 1;
			} else if (enemy.getResult() == 3) {
				System.out.println("结果：啊！你输了！");
				enemy.addScore();
				return -1;
			}
			break;
		case 2:
			if (enemy.getResult() == 1) {
				System.out.println("结果：啊！你输了！");
				enemy.addScore();
				return -1;
			} else if (enemy.getResult() == 2) {
				System.out.println("结果：运气一般，平局！");
				return 2;
			} else if (enemy.getResult() == 3) {
				System.out.println("结果：运气真好，你赢了！");
				addScore();
				return 1;
			}
			break;
		case 3:
			if (enemy.getResult() == 1) {
				System.out.println("结果：运气真好，你赢了！");
				addScore();
				return 1;
			} else if (enemy.getResult() == 2) {
				System.out.println("结果：啊！你输了！");
				enemy.addScore();
				return -1;
			} else if (enemy.getResult() == 3) {
				System.out.println("结果：运气一般，平局！");
				return 2;
			}
			break;

		default:
			break;
		}
		return -1;
	}

	private void addScore() {
		score++;
	}

	public int getScore() {
		return score;
	}
}
