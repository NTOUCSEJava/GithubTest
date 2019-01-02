package ntou.cs.java.rpg;

import java.util.Random;

public class Pet implements ATK {
	int maxAttack;

	public Pet(int maxAttack) {
		if (maxAttack > 0) {
			this.maxAttack = maxAttack;
		}
	}

	@Override
	public double attack() {
		Random r = new Random();
		return 1 + r.nextInt(maxAttack);
	}

}
