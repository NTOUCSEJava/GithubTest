package ntou.cs.java.rpg;

public abstract class Weapon implements ATK {

	public static double MAX_VALUE = 255;
	private double offense;

	public Weapon(double offense) {
		setOffense(offense);
	}

	public double getOffense() {
		return offense;
	}

	public void setOffense(double offense) {
		if ((0 < offense) && (offense < MAX_VALUE))
			this.offense = offense;
		else
			this.offense = 0;
	}

	@Override
	public String toString() {
		return "Weapon [offense=" + offense + "]";
	}
}
