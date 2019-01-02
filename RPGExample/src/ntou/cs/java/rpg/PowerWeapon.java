package ntou.cs.java.rpg;

public class PowerWeapon extends Weapon {

	public PowerWeapon(double offense) {
		super(offense);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double attack() {
		double attackPoint = getOffense() * 1.2;
		// System.out.println("強力武器造成" + (int)attackPoint + "點的傷害");
		return attackPoint;
	}

	@Override
	public String toString() {
		return "強力武器: " + super.toString();
	}
}
