package ntou.cs.java.rpg;

public class NormalWeapon extends Weapon {

	public NormalWeapon(double offense) {
		super(offense);
	}

	@Override
	public double attack() {
		return getOffense();
	}

	@Override
	public String toString() {
		return "一般武器: " + super.toString();
	}

}
