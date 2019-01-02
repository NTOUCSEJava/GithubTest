package ntou.cs.java.rpg;

import java.util.Random;

public class DoubleWeapon extends Weapon {

	public DoubleWeapon(double offense) {
		super(offense);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double attack() {
		Random r = new Random();
		double attackPoint = 0;

		if (r.nextInt(5) == 0) {
			attackPoint = getOffense() * 2;
		} else {
			attackPoint = getOffense();
		}
		// System.out.println("雙倍武器造成" + (int)attackPoint + "點的傷害");
		return attackPoint;
	}

	@Override
	public String toString() {
		return "雙倍攻擊武器: " + super.toString();
	}
}
